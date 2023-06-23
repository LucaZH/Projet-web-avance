package com.ops.stock_ops.ops;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Migrations {

    public static String read_schema(String path) {
        try {
            StringBuilder schema = new StringBuilder();
            File file = new File(path);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                schema.append("\n").append(data);
            }
            return schema.toString();
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public static boolean migrate(String url, String path_sql) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(url);
            String schema = read_schema(path_sql);
            PreparedStatement prepare = connection.prepareStatement(schema);
            prepare.executeUpdate();
            prepare.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
