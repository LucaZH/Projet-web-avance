package com.ops.stock_ops.client.servlets;

import com.ops.stock_ops.DatabaseConnection;
import com.ops.stock_ops.client.daos.User_permissionDAO;
import com.ops.stock_ops.client.entities.User_permission;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(value="/gestion_user_permission")
public class GestionUserPermissionServlets extends HttpServlet {

    public GestionUserPermissionServlets () {super();}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String path = (String) session.getAttribute("path_db");

        Connection connection = DatabaseConnection.getInstance(path);
        User_permissionDAO user_permissionDAO = new User_permissionDAO(connection);

        List<User_permission> list_user_permission = user_permissionDAO.get_all();
        req.setAttribute("list_user_permission", list_user_permission);
        this.getServletContext().getRequestDispatcher("/jsp/pages/gestion_vente.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String path = (String) session.getAttribute("path_db");

        Connection connection = DatabaseConnection.getInstance(path);
        User_permissionDAO user_permissionDAO = new User_permissionDAO(connection);

        int id_user = Integer.parseInt(req.getParameter("id_user"));
        int id_permission = Integer.parseInt(req.getParameter("id_permission"));
        User_permission user_permission = new User_permission(id_user, id_permission);
        if (user_permissionDAO.create(user_permission)) {
            req.setAttribute("RegisterUserPermissionSuccess", true);
            this.getServletContext().getRequestDispatcher("/jsp/pages/.......jsp").forward(req, resp);
        } else {
            resp.sendRedirect("register_user_permission?message=Erreur lors de l'ajout de vente");
        }
    }
}
