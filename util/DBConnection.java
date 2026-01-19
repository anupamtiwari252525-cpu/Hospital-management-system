package com.jdbcconnectivity.HospitalManagement.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/hospital_management_db";

    private static final String USER = "root";      // change if needed
    private static final String PASSWORD = "Anupam@9642";  // change if needed

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("Database Connection Failed!", e);
        }
    }
}
