package com.ops.stock_ops.client.servlets;


import com.ops.stock_ops.DatabaseConnection;
import com.ops.stock_ops.client.daos.User_permissionDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(value = "/suppression_user_permission")
public class SuppressionUserPermission extends HttpServlet {

    public SuppressionUserPermission () {super();}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String path = (String) session.getAttribute("path_db");

        Connection connection = DatabaseConnection.getInstance(path);
        User_permissionDAO user_permissionDAO = new User_permissionDAO(connection);

        int id_user = Integer.parseInt(req.getParameter("id_user"));
        if (user_permissionDAO.delete(id_user)) {
            resp.sendRedirect("gestion_user_permission");
        } else {
            req.setAttribute("Erreur", "Suppression échoué.");
        }
    }
}
