package com.ops.stock_ops.client;

import java.sql.Connection;
import java.sql.DriverManager;

public class ClientDatabaseConnection {
    private static Connection connection;

    ClientDatabaseConnection(String path) {
        String url = "jdbc:sqlite:" + path;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getInstance(String path) {
        if (connection == null)
            new ClientDatabaseConnection(path);
        return connection;
    }
}
