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

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

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
}
