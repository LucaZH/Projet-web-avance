package com.ops.stock_ops.client.servlets;

import com.ops.stock_ops.DatabaseConnection;
import com.ops.stock_ops.client.daos.Vente_produitDAO;
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
import java.util.List;


@WebServlet(value = "/gestion_de_vente")
public class GestionVenteServlets extends HttpServlet {
    private Date date_d_achat;

    public GestionVenteServlets() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String path = (String) session.getAttribute("path_db");
        Connection connection = DatabaseConnection.getInstance(path);

        Vente_produitDAO vente_produitDAO = new Vente_produitDAO(connection);
        List<Vente_produit> list_vente = vente_produitDAO.get_all();
        req.setAttribute("list_vente", list_vente);
        req.setAttribute("RegisterVenteSuccess", false);
        this.getServletContext().getRequestDispatcher("/jsp/pages/gestion_vente.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String path = (String) session.getAttribute("path_db");
        Connection connection = DatabaseConnection.getInstance(path);

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
        Vente_produitDAO vente_produitDAO = new Vente_produitDAO(connection);
        if (vente_produitDAO.create(vente_produit)) {
            req.setAttribute("RegisterVenteSuccess", true);
            this.getServletContext().getRequestDispatcher("/jsp/pages/gestion_vente.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("register_vente?message=Erreur lors de l'ajout de vente");
        }
    }
}
