package com.ops.stock_ops.client.servlets;

import com.ops.stock_ops.DatabaseConnection;
import com.ops.stock_ops.Security;
import com.ops.stock_ops.client.daos.UserDAO;
import com.ops.stock_ops.client.entities.User;
import com.ops.stock_ops.ops.daos.BaseDeDonneeDao;
import com.ops.stock_ops.ops.daos.EntrepriseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(value = "/connexion_entreprise")
public class ConnexionEntrepriseServlet extends HttpServlet {
    public ConnexionEntrepriseServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/jsp/pages/connexion_entreprise.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String mot_de_passe = Security.hasher(req.getParameter("mot_de_passe"));

        String path = "jdbc:sqlite:" + getServletContext().getRealPath("") + "opsbase.db";

        Connection connection = DatabaseConnection.getInstance(path);

        BaseDeDonneeDao baseDeDonneeDao = new BaseDeDonneeDao(connection);

        EntrepriseDao entrepriseDao = new EntrepriseDao(connection);
        int id_entreprise = entrepriseDao.get(email).getId_entreprise();

        String path_db = baseDeDonneeDao.get_by(id_entreprise).getLien();

        try { // I don't know why it's not work with DatabaseConnection
            Class.forName("org.sqlite.JDBC");
            Connection client_connection = DriverManager.getConnection(path_db);
            UserDAO userDAO = new UserDAO(client_connection);
            User user = userDAO.get(email);
            if (user.getMot_de_passe().equals(mot_de_passe)) {
                HttpSession session = req.getSession();
                session.setAttribute("connection", client_connection);
                resp.sendRedirect("/gestion_produit");
            } else {
                resp.sendRedirect("/connexion_entreprise");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
