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

@WebServlet(value="modification_user")
public class ModificationUserServlets extends HttpServlet {

    String UPLOAD_DIRECTORY = "uploads";
    private final Connection connection = ClientDatabaseConnection.getInstance("");
    private final UserDAO userDAO = new UserDAO(connection);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_user = Integer.parseInt(req.getParameter("id_user"));
        String username = req.getParameter("username");
        User user = userDAO.get(id_user);
        if (user != null) {
            String uploadPath = getServletContext().getContextPath() + File.separator + "uploads" + File.separator;
            req.setAttribute("upload_path", uploadPath);
            req.setAttribute("user" ,user);
        } else {
            resp.sendRedirect(("get_user?message= Erreur lors de la modification de l'utilisateur "+ username ));
        }
        req.getRequestDispatcher("/WEB-INF/jsp/pages/........jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id_user = Integer.parseInt(req.getParameter("id_user"));
        String username = req.getParameter("username");
        String mot_de_passe = req.getParameter("mot_de_passe");
        String email = req.getParameter("email");
        String contact = req.getParameter("contact");
        String image = req.getPart("image").getSubmittedFileName();

        User old_info_user = userDAO.get(id_user);
        if (image.isEmpty())
            image = old_info_user.getImage();

        User new_info_user = new User(id_user, username, mot_de_passe, email, contact, image);
        if (!old_info_user.getImage().equals(new_info_user.getImage())) {
            String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists())
                uploadDir.mkdir();

            String filename = "";

            for (Part part : req.getParts()) {
                filename = part.getSubmittedFileName();
                part.write(uploadPath + File.separator + filename);
            }
            System.out.println("File uploaded successfully to : " + uploadPath + File.separator + filename);
            if (userDAO.update(new_info_user)) {
                resp.sendRedirect("gestion_tshirt");
            } else {
                req.setAttribute("erreur", "le modification a echoué!");
                resp.sendRedirect("modification_tshirt?idTshirt=" + id_user);
            }
        }
    }
}
