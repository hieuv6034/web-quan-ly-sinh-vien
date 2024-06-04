package com.quanlysinhvien.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    private static final String hostName = "localhost";
    private static final String dbName = "chuyendecs";
    private static final String userName = "root";
    private static final String password = "123456";

    public static Connection getMySQLConnection() {
        return getMySQLConnection(hostName, dbName, userName, password);
    }

    public static Connection getMySQLConnection(String hostName, String dbName,
                                                String userName, String password) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName + "?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8";

            Connection conn = DriverManager.getConnection(connectionURL, userName,
                    password);
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

        return null;

    }

    public static void main(String[] args) {
        System.out.println(getMySQLConnection());
    }
}
//&useSSL=false