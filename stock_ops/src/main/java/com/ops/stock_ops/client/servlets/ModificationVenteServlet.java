package com.ops.stock_ops.client.servlets;

import com.ops.stock_ops.DatabaseConnection;
import com.ops.stock_ops.client.daos.Vente_produitDAO;
import com.ops.stock_ops.client.entities.Product;
import com.ops.stock_ops.client.entities.Vente_produit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(value = "/modification_vente")
public class ModificationVenteServlet extends HttpServlet {
    private Date date_d_achat;

    public ModificationVenteServlet () {super();};

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String path = (String) session.getAttribute("path_db");

        Connection connection = DatabaseConnection.getInstance(path);
        Vente_produitDAO vente_produitDAO = new Vente_produitDAO(connection);

        int id_product = Integer.parseInt(req.getParameter("id_product"));
        Vente_produit vente_produit = vente_produitDAO.get(id_product);
        if (vente_produit != null) {
            req.setAttribute("vente_produit", vente_produit);
        } else {
            resp.sendRedirect(("get_vente?message= Erreur lors de la modification du produit"));
        }
        req.getRequestDispatcher("/jsp/pages/........jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String path = (String) session.getAttribute("path_db");

        Connection connection = DatabaseConnection.getInstance(path);
        Vente_produitDAO vente_produitDAO = new Vente_produitDAO(connection);

        String date = req.getParameter("date_d_achat");
        int quantite = Integer.parseInt(req.getParameter("quantite"));
        int id_user = Integer.parseInt(req.getParameter("id_user"));
        int id_product = Integer.parseInt(req.getParameter("id_product"));

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            date_d_achat = (Date) dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Vente_produit vente_produit = new Vente_produit(date_d_achat, quantite, id_user, id_product);
        if (vente_produitDAO.update(vente_produit)) {
            resp.sendRedirect("/");
        } else {
            req.setAttribute("erreur", "le modification a echoué!");
            resp.sendRedirect("modification_vente?idProduct=" + id_product);
        }
    }
}
