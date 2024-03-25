package com.hexaware.util;


public class PropertyUtil {

    private PropertyUtil() {
    }

    public static String getPropertyString() {
        
        String connectionString;
		String hostname;
		String dbname;
		String username;
		String password;
		String port;
		hostname="localhost";
		dbname="Java_coding_challange";
		username="root";
		password="20kn1a4456";
		port="3306";

		connectionString = "jdbc:mysql://" + hostname + ":" + port + "/" + dbname +
		        "?user=" + username + "&password=" + password;
        return connectionString;
    }
}
