package com.ops.stock_ops.client.servlets;

import com.ops.stock_ops.client.ClientDatabaseConnection;
import com.ops.stock_ops.client.daos.UserDAO;
import com.ops.stock_ops.client.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(value="gestion_user")
public class GestionUserServlets extends HttpServlet {

    String UPLOAD_DIRECTORY = "uploads";

    private final Connection connection = ClientDatabaseConnection.getInstance("");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userdao = new UserDAO(connection);
        List<User> list_user = userdao.get_all();
        req.setAttribute("list_user", list_user);
        req.setAttribute("RegisterUserSuccess", false);
        this.getServletContext().getRequestDispatcher("/jsp/pages/gestion_user.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String mot_de_passe = req.getParameter("mot_de_passe");
        String email = req.getParameter("email");
        String contact = req.getParameter("contact");
        String image = req.getPart("image").getSubmittedFileName();

        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists())
            uploadDir.mkdir();

        String filename = "";

        for (Part part : req.getParts()) {
            filename = part.getSubmittedFileName();
            part.write(uploadPath + File.separator + filename);
        }

        User user = new User(username, mot_de_passe, email, contact, image);
        UserDAO userdao = new UserDAO(connection);
        if (userdao.create(user)) {
            req.setAttribute("RegisterUserSuccess", true);
            this.getServletContext().getRequestDispatcher("/jsp/pages/gestion_user.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(("register_product?message=Erreur lors de l'ajout de l'utilisateur" + username + ".<br> Veuillez verifier les informations entrées."));
        }

    }
}
