package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection = null;

    private DBConnection() {
    }

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                String connectionString = PropertyUtil.getPropertyString();
                connection = DriverManager.getConnection(connectionString);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }
    }


	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
