package com.ops.stock_ops.client.servlets;



import com.ops.stock_ops.client.ClientDatabaseConnection;
import com.ops.stock_ops.client.daos.ProductDAO;
import com.ops.stock_ops.client.entities.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;


@WebServlet(value= "/modification_produit")
public class ModificationProduitServlets extends HttpServlet {

    private final Connection connection = ClientDatabaseConnection.getInstance("");
    private final ProductDAO productDAO = new ProductDAO(connection);

    public ModificationProduitServlets() {super();}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_product = Integer.parseInt(req.getParameter("id_product"));
        Product product = productDAO.get(id_product);
        if (product != null) {
            req.setAttribute("product" ,product);
        } else {
            resp.sendRedirect(("get_product?message= Erreur lors de la modification du produit"));
        }
        req.getRequestDispatcher("/WEB-INF/jsp/pages/........jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_product = Integer.parseInt(req.getParameter("id_product"));
        String nom_du_produit = req.getParameter("nom_du_produit");
        Float prix = Float.valueOf(req.getParameter("prix"));
        String description = req.getParameter("description");
        int stock = Integer.parseInt(req.getParameter("stock"));

        Product product = new Product(id_product, nom_du_produit, prix, description, stock);
        if (productDAO.update(product)) {
            resp.sendRedirect("/.........");
        } else {
            req.setAttribute("erreur", "le modification a echoué!");
            resp.sendRedirect("modification_product?idProduct=" + id_product);
        }
    }
}
