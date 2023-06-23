package com.ops.stock_ops;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(value = "")
public class IndexServlet extends HttpServlet {

    public IndexServlet() {
        super();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "jdbc:sqlite:" + getServletContext().getRealPath("") + "opsbase.db";
        Connection connection = DatabaseConnection.getInstance(path);
        req.setAttribute("connection", connection);
        this.getServletContext().getRequestDispatcher("/jsp/pages/index.jsp").forward(req, resp);
    }
}
