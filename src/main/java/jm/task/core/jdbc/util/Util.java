package jm.task.core.jdbc.util;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;


public class Util {
    // реализуйте настройку соеденения с БД
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306";
    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch(SQLException | ClassNotFoundException ex) {
            System.out.println("Driver could not be registered");
        }
    return connection;
    }
}
