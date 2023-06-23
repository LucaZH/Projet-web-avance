package com.ops.stock_ops.ops.servlets;

import com.ops.stock_ops.DatabaseConnection;
import com.ops.stock_ops.client.daos.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

public class SuppressionProductServlets extends HttpServlet {

    public SuppressionProductServlets() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String path = (String) session.getAttribute("path_db");
        Connection connection = DatabaseConnection.getInstance(path);

        int id_product = Integer.parseInt(req.getParameter("id_product"));
        ProductDAO productDao = new ProductDAO(connection);
        if (productDao.delete(id_product)) {
            resp.sendRedirect("gestion_product");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
