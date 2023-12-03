package com.mycompany.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/CarWow";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "12345678";

    private static Connection connection;

    private DatabaseConnector() {
        // Private constructor to prevent instantiation
    }

    public static Connection getInstance() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (connection == null) {
            try {
                connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }
}
