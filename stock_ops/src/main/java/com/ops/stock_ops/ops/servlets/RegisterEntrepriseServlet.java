package com.ops.stock_ops.ops.servlets;

import com.ops.stock_ops.DatabaseConnection;
import com.ops.stock_ops.Security;
import com.ops.stock_ops.client.daos.PermissionDAO;
import com.ops.stock_ops.client.daos.UserDAO;
import com.ops.stock_ops.client.daos.User_permissionDAO;
import com.ops.stock_ops.client.entities.Permission;
import com.ops.stock_ops.client.entities.User;
import com.ops.stock_ops.client.entities.User_permission;
import com.ops.stock_ops.ops.Migrations;
import com.ops.stock_ops.ops.daos.BaseDeDonneeDao;
import com.ops.stock_ops.ops.daos.EntrepriseDao;
import com.ops.stock_ops.ops.daos.OffreDao;
import com.ops.stock_ops.ops.entities.BaseDeDonnee;
import com.ops.stock_ops.ops.entities.Entreprise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(value = "/register_entreprise")
public class RegisterEntrepriseServlet extends HttpServlet {

    public RegisterEntrepriseServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "jdbc:sqlite:" + getServletContext().getRealPath("") + "opsbase.db";
        Connection connection = DatabaseConnection.getInstance(path);
        OffreDao offreDao = new OffreDao(connection);
        req.setAttribute("list_offre", offreDao.get_all());
        this.getServletContext().getRequestDispatcher("/jsp/pages/register_entreprise.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String real_path = "jdbc:sqlite:" + getServletContext().getRealPath("");

        Connection connection = DatabaseConnection.getInstance(real_path + "opsbase.db");

        EntrepriseDao entrepriseDao = new EntrepriseDao(connection);
        BaseDeDonneeDao baseDeDonneeDao = new BaseDeDonneeDao(connection);

        String nom_entreprise = req.getParameter("nom_entreprise");
        String mot_de_passe = Security.hasher(req.getParameter("mot_de_passe"));
        String nif = req.getParameter("nif");
        String stat = req.getParameter("stat");
        String email = req.getParameter("email");
        String logo = req.getParameter("logo"); // Todo implement upload file for this field
        String phone = req.getParameter("phone");
        String localisation = req.getParameter("localisation");
        String proprio = req.getParameter("proprio");
        int id_offre = Integer.parseInt(req.getParameter("id_offre"));

        Entreprise entreprise = new Entreprise(nom_entreprise, mot_de_passe, nif, stat, email,
                logo, phone, localisation, proprio, id_offre);

        if (entrepriseDao.create(entreprise)) {
            String migration_url = real_path + entreprise.getNom_entreprise() + ".db";
            if (Migrations.migrate(migration_url, real_path + "client_schema.sql")) {
                System.out.println("Migrate success");

                Connection client_connection = DatabaseConnection.getInstance(migration_url); // get connection from entreprise database

                UserDAO userDao = new UserDAO(client_connection);
                User user = new User(proprio, mot_de_passe, email, phone);
                userDao.create(user); // add Client

                // Insert Permission in entreprise database
                Permission permission_stock = new Permission("stock");
                Permission permission_user = new Permission("user");
                Permission permission_sales = new Permission("sales");
                Permission permission_admin = new Permission("admin");

                PermissionDAO permissionDAO = new PermissionDAO(connection);
                permissionDAO.create(permission_stock);
                permissionDAO.create(permission_user);
                permissionDAO.create(permission_sales);
                permissionDAO.create(permission_admin);
                // finish permission insertion

                // add admin permission for the user
                int id_user = userDao.get("email").getId_user();
                int id_permission = permission_admin.getId_permission();
                User_permission userPermission = new User_permission(id_user, id_permission);
                User_permissionDAO userPermissionDAO = new User_permissionDAO(client_connection);
                userPermissionDAO.create(userPermission);
                // finish

                if (baseDeDonneeDao.create(new BaseDeDonnee(real_path, entreprise.getId_entreprise()))) {
                    resp.sendRedirect("/connexion_entreprise?message=Entreprise is created");
                }
            }
        } else {
            resp.sendRedirect("/connexion_entreprise?message=Failed to create entreprise");
        }
    }
}
