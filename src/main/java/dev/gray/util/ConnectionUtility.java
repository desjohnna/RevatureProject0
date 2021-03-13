package dev.gray.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {

    private static Connection connection;

    public ConnectionUtility() {
        super();
    }

    public static Connection getConnection() {
//        Creating a connection to my azure database
//        Loading in the driver explicitly, not required but can prevent issues
//        try {
//            Class.forName("org.postgresql");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        String connectionUrl = "jdbc:postgresql://gray-java-azure-training.postgres.database.azure.com:5432/postgres";

//        String connectionUrl = System.getenv("connectionUrl");
        String username = System.getenv("username");
        String password = System.getenv("password");

        try {
            connection = DriverManager.getConnection(connectionUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
