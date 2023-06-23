package com.ops.stock_ops.ops;

import java.sql.Connection;
import java.sql.DriverManager;

public class OpsDatabaseConnection {
    private static Connection connection;
    private final String url = "jdbc:sqlite:/mnt/d/Project/Projet-web-avance/stock_ops/opsbase.db";

    OpsDatabaseConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getInstance() {
        if (connection == null)
            new OpsDatabaseConnection();
        return connection;
    }
}
