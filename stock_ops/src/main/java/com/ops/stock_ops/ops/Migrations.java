package com.ops.stock_ops.ops;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Migrations {

    public static String[] read_schema(String path) {
        try {
            StringBuilder schema = new StringBuilder();
            File file = new File(path);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                schema.append("\n").append(data);
            }
            return schema.toString().split(";");
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
            return new String[0];
        }
    }

    public static Connection migrate(String url, String path_sql) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection(url);
            String[] schemas = read_schema(path_sql);

            Statement prepare = connection.createStatement();

            for (String schema : schemas) {
                prepare.addBatch(schema);
            }
            prepare.executeBatch();
            prepare.close();
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
