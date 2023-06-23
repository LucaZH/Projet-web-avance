package com.ops.stock_ops.ops.servlets;

import com.ops.stock_ops.Security;
import com.ops.stock_ops.ops.OpsDatabaseConnection;
import com.ops.stock_ops.ops.daos.EntrepriseDao;
import com.ops.stock_ops.ops.entities.Entreprise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(value = "/connexion_entreprise")
public class ConnexionEntrepriseServlet extends HttpServlet {
    Connection connection = OpsDatabaseConnection.getInstance();

    private final EntrepriseDao entrepriseDao = new EntrepriseDao(connection);

    public ConnexionEntrepriseServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/jsp/pages/connexion_entreprise.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String mot_de_passe = Security.hasher(req.getParameter("mot_de_passe"));

        Entreprise entreprise = entrepriseDao.get(email);
        if (entreprise != null) {
            if (entreprise.getMot_de_passe().equals(mot_de_passe)) {
                HttpSession session = req.getSession();
                session.setAttribute("entreprise", entreprise);
                session.setAttribute("is_entreprise_login", true);
            } else {
                resp.sendRedirect("/connexion_entreprise?message=Mot de passe incorrect");
            }
        } else {
            resp.sendRedirect("/connexion_entreprise?message=Utilisateur introuvable");
        }
    }
}
