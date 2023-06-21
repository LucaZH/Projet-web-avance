package com.ops.stock_ops.ops.servlets;

import com.ops.stock_ops.ops.DatabaseConnection;
import com.ops.stock_ops.ops.Migrations;
import com.ops.stock_ops.ops.daos.BaseDeDonneeDao;
import com.ops.stock_ops.ops.daos.EntrepriseDao;
import com.ops.stock_ops.ops.entities.BaseDeDonnee;
import com.ops.stock_ops.ops.entities.Entreprise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(value = "/register_entreprise")
public class RegisterEntrepriseServlet extends HttpServlet {
    private final Connection connection = DatabaseConnection.getInstance();

    public RegisterEntrepriseServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/jsp/pages/register_entreprise.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom_entreprise = req.getParameter("nom_entreprise");
        String mot_de_passe = req.getParameter("mot_de_passe");
        String nif_stat = req.getParameter("nif_stat");
        String mail = req.getParameter("email");
        String logo = req.getParameter("logo"); // Todo implement upload file for this field
        String phone = req.getParameter("phone");
        String localisation = req.getParameter("localisation");
        String proprio = req.getParameter("proprio");
        int id_offre = Integer.parseInt(req.getParameter("id_offre"));
        Entreprise entreprise = new Entreprise(nom_entreprise, mot_de_passe, nif_stat, mail,
                logo, phone, localisation, proprio, id_offre);
        EntrepriseDao entrepriseDao = new EntrepriseDao(connection);
        if (entrepriseDao.create(entreprise)) {
            if (Migrations.migrate(entreprise.getNom_entreprise())) { // crée la base de donnée de l'entreprise
                System.out.println("Migrate success");
                BaseDeDonneeDao baseDeDonneeDao = new BaseDeDonneeDao(connection);
                String lien = entreprise.getNom_entreprise() + ".db";
                if (baseDeDonneeDao.create(new BaseDeDonnee(lien, entreprise.getId()))) {
                    resp.sendRedirect("connexion_entreprise?message=Entreprise is created");
                }
            }
        } else {
            resp.sendRedirect("connexion_entreprise?message=Failed to create entreprise");
        }

    }
}