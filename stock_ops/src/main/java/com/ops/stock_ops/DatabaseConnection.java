package com.ops.stock_ops;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static Connection connection;

    DatabaseConnection(String url) {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getInstance(String url) {
        if (connection == null)
            new DatabaseConnection(url);
        return connection;
    }
}
