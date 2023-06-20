package com.ops.stock_ops.ops;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static Connection connection;
    private final String url = "jdbc:sqlite:opsbase.db";

    DatabaseConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getInstance() {
        if (connection == null)
            new DatabaseConnection();
        return connection;
    }
}
