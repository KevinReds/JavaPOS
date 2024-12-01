package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.DatabaseConnection;

/**
 * Clase Rol que representa la entidad rol en la base de datos.
 */
public class Rol {

    private int idRol; // Identificador único del rol
    private String nombreRol; // Nombre del rol

    // Constructor vacío
    public Rol() {
    }

    // Constructor con parámetros
    public Rol(int idRol, String nombreRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
    }

    // Getters y Setters
    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    // Métodos de Operación
    public void guardar() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "INSERT INTO rol (NombreRol) VALUES (?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, nombreRol);
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                this.idRol = rs.getInt(1); // Obtener el ID generado
            }
            System.out.println("Rol guardado con ID: " + this.idRol);
        }
    }
    
    //prueba de Guardar para rol
    /*
    public static void main (String args[]){
    Rol nuevoRol = new Rol(1, "Proveedor");
    try {
        nuevoRol.guardar();
      } catch (SQLException e) {
        System.err.println("Error al guardar el producto: " + e.getMessage());
      }
    }*/
    

    public static Rol buscarPorId(int id) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM rol WHERE idRol = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Rol(
                        rs.getInt("idRol"),
                        rs.getString("NombreRol")
                );
            }
        }
        return null;
    }
    

    public void actualizar() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "UPDATE rol SET NombreRol = ? WHERE idRol = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, nombreRol);
            pstmt.setInt(2, idRol);
            pstmt.executeUpdate();
            System.out.println("Rol actualizado: " + this.idRol);
        }
    }

    public void eliminar() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "DELETE FROM rol WHERE idRol = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, idRol);
            pstmt.executeUpdate();
            System.out.println("Rol eliminado: " + this.idRol);
        }
    }

    public static List<Rol> obtenerTodos() throws SQLException {
        List<Rol> roles = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM rol";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                roles.add(new Rol(
                        rs.getInt("idRol"),
                        rs.getString("NombreRol")
                ));
            }
        }
        return roles;
    }

}