package com.ops.stock_ops.ops.servlets;

import com.ops.stock_ops.client.daos.ProductDAO;
import com.ops.stock_ops.client.ClientDatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class SuppressionProductServlets extends HttpServlet {

    private final Connection connection = ClientDatabaseConnection.getInstance("");
    public SuppressionProductServlets () {super();}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_product = Integer.valueOf(req.getParameter("id_product"));
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
