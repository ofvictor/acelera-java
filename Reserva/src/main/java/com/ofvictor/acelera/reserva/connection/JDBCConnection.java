package com.ofvictor.acelera.reserva.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    private static Connection CONNECTION;
    
    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DATABASE = "reserva";
    private static final String URL = "jdbc:mysql://" + JDBCConnection.HOST + ":" + JDBCConnection.PORT + "/" + JDBCConnection.DATABASE;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "secretapacas";
    
    public static Connection getConnection() {
        try {
            JDBCConnection.CONNECTION = DriverManager.getConnection(
            													 JDBCConnection.URL
            													,JDBCConnection.USERNAME
            													,JDBCConnection.PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return JDBCConnection.CONNECTION;
    }
    
    public static void close() {
        try {
            if ((JDBCConnection.CONNECTION != null) && (!JDBCConnection.CONNECTION.isClosed())) {
                JDBCConnection.CONNECTION.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}