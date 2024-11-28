/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Kevin
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/malliedb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexion establecida correctamente.");
            } catch (SQLException e) {
                System.err.println("Error al conectar con la base de datos: " + e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexion cerrada correctamente.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
    }
    
    //funcion main creada para verificar la conexion con la base de datos
    /*
    public static void main(String[] args) {
        try {
            getConnection();
        } catch (Exception e) {
            System.err.println("La prueba de conexion ha fallado: " + e.getMessage());
        } finally {
            closeConnection();
        }
    }
    */
}
