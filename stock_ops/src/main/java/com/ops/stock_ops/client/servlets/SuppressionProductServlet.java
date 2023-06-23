package com.ops.stock_ops.client.servlets;

import com.ops.stock_ops.client.ClientDatabaseConnection;
import com.ops.stock_ops.client.daos.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(value="suppression_produit")
public class SuppressionProductServlet extends HttpServlet {

    private final Connection connection = ClientDatabaseConnection.getInstance("");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_product = Integer.parseInt(req.getParameter("id_product"));
        ProductDAO productDAO = new ProductDAO(connection);
        if (productDAO.delete(id_product)) {
            resp.sendRedirect("gestion_product");
        }
        else {
            req.setAttribute("Erreur","Suppression échoué.");
        }
    }

}
