package dev.gray.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {

    private static Connection connection;

    private ConnectionUtility() {
        super();
    }

    public static Connection getConnection() {
//        Loading in the driver explicitly, not required but can prevent issues
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        String connectionUrl = "jdbc:postgresql://gray-java-azure-training.postgres.database.azure.com:5432/postgres";

        String connectionUrl = System.getenv("connectionUrl");
        String username = System.getenv("username");
        String password = System.getenv("password");

        try {
            connection = DriverManager.getConnection(connectionUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

//    public static Connection getHardcodedConnection() throws SQLException {
//
//        try {
//            Class.forName("postgres.database.azure.com");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        if(connection == null || connection.isClosed()) {
//            String connectionUrl = "jdbc:postgresql://gray-java-azure-training.postgres.database.azure.com:5432/postgres";
//            String username = "desjohnna@gray-java-azure-training";
//            String password = "Deonna7745";
//
//            // create a connection
//            connection = DriverManager.getConnection(connectionUrl, username, password);
//        }
//        return connection;
//    }




}
