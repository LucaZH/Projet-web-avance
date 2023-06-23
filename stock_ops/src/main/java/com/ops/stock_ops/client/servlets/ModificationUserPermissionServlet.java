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

@WebServlet(value="/modification_user_permission")
public class ModificationUserPermissionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String path = (String) session.getAttribute("path_db");

        Connection connection = DatabaseConnection.getInstance(path);
        User_permissionDAO user_permissionDAO = new User_permissionDAO(connection);

        int id_user = Integer.parseInt(req.getParameter("id_user"));
        User_permission user_permission = user_permissionDAO.get(id_user);
        if (user_permission != null) {
            req.setAttribute("user_permission", user_permission);
        } else {
            resp.sendRedirect("get_user_permission?message= Erreur lors de la modification de la permission ");
        }
        req.getRequestDispatcher("/WEB-INF/jsp/pages/........jsp").forward(req, resp);
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
        if (user_permissionDAO.update(user_permission)){
            resp.sendRedirect("/");
        } else {
            req.setAttribute("erreur", "le modification a echoué!");
            resp.sendRedirect("modification_user_permission?idUser=" + id_user);
        }
    }
}
