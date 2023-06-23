package com.ops.stock_ops.client.servlets;

import com.ops.stock_ops.DatabaseConnection;
import com.ops.stock_ops.client.daos.PermissionDAO;
import com.ops.stock_ops.client.daos.Vente_produitDAO;
import com.ops.stock_ops.client.entities.Permission;
import com.ops.stock_ops.client.entities.Vente_produit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(value = "/gestion_permission")
public class GestionPermission extends HttpServlet {

    public GestionPermission () {super();}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String path = (String) session.getAttribute("path_db");

        Connection connection = DatabaseConnection.getInstance(path);
        PermissionDAO permissionDAO = new PermissionDAO(connection);

        List<Permission> list_permission = permissionDAO.get_all();
        req.setAttribute("list_permission", list_permission);
        this.getServletContext().getRequestDispatcher("/jsp/pages/gestion_vente.jsp").forward(req, resp);
    }
}
