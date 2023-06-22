package com.ops.entreprise.servlets;

import com.ops.entreprise.daos.ProductDAO;
import com.ops.entreprise.entity.Product;
import com.ops.stock_ops.ops.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;


@WebServlet(value="/register_product")
public class RegisterProductServlets extends HttpServlet {
    private final Connection connection = DatabaseConnection.getInstance();

    public RegisterProductServlets () {super();}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("RegisterProductSuccess", false);
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/pages/register_product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom_du_produit = req.getParameter("nom_du_produit");
        Float prix = Float.parseFloat(req.getParameter("prix"));
        String description = req.getParameter("description");
        int stock = Integer.parseInt(req.getParameter("stock"));

        Product product = new Product(nom_du_produit, prix, description, stock);
        ProductDAO productDAO = new ProductDAO(connection);
        if (productDAO.create(product)) {
            req.setAttribute("RegisterProductSuccess", true);
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/pages/register_product.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(("register_product?message=Erreur lors de l'ajout du produit" + nom_du_produit + ".<br> Veuillez verifier les informations entrées."));
        }
    }

}
