package com.ops.stock_ops.ops.servlets;

import com.ops.stock_ops.Security;
import com.ops.stock_ops.ops.DatabaseConnection;
import com.ops.stock_ops.ops.daos.AdminDao;
import com.ops.stock_ops.ops.entities.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/connexion_admin")
public class ConnexionAdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ConnexionAdminServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/jsp/pages/connexion_admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String motDePasse = Security.hasher(req.getParameter("mot_de_passe"));
        AdminDao adminDao = new AdminDao(DatabaseConnection.getInstance());
        Admin admin = adminDao.get(email);
        if (admin != null) {
            if (admin.getMot_de_passe().equals(motDePasse)) {
                HttpSession session = req.getSession();
                session.setAttribute("admin", admin);
                resp.sendRedirect("accueil");
            } else {
                resp.sendRedirect("admin_connexion?message=Mot de passe incorrect");
            }
        } else {
            resp.sendRedirect("admin_connexion?message=Utilisateur non existant");
        }
    }
}
