package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.DatabaseConnection;

/**
 * Clase PersonasRol que representa la tabla personas_rol.
 */
public class PersonasRol {

    private int idRol;       // ID del rol (llave foránea)
    private int idPersonas;  // ID de la persona (llave foránea)

    // Constructor vacío
    public PersonasRol() {
    }

    // Constructor con parámetros
    public PersonasRol(int idRol, int idPersonas) {
        this.idRol = idRol;
        this.idPersonas = idPersonas;
    }

    // Getters y Setters
    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getIdPersonas() {
        return idPersonas;
    }

    public void setIdPersonas(int idPersonas) {
        this.idPersonas = idPersonas;
    }

    // Métodos de Operación
    public void guardar() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "INSERT INTO personas_rol (idRol, idPersonas) VALUES (?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, idRol);
            pstmt.setInt(2, idPersonas);
            pstmt.executeUpdate();
            System.out.println("Relación guardada: idRol = " + idRol + ", idPersonas = " + idPersonas);
        }
    }

    public static PersonasRol buscarPorId(int idRol, int idPersonas) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM personas_rol WHERE idRol = ? AND idPersonas = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, idRol);
            pstmt.setInt(2, idPersonas);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new PersonasRol(
                        rs.getInt("idRol"),
                        rs.getInt("idPersonas")
                );
            }
        }
        return null;
    }

    public void actualizar(int nuevoIdRol, int nuevoIdPersonas) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "UPDATE personas_rol SET idRol = ?, idPersonas = ? WHERE idRol = ? AND idPersonas = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, nuevoIdRol);
            pstmt.setInt(2, nuevoIdPersonas);
            pstmt.setInt(3, idRol);
            pstmt.setInt(4, idPersonas);
            pstmt.executeUpdate();

            // Actualizar los atributos actuales
            this.idRol = nuevoIdRol;
            this.idPersonas = nuevoIdPersonas;
            System.out.println("Relación actualizada: idRol = " + idRol + ", idPersonas = " + idPersonas);
        }
    }

    public void eliminar() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "DELETE FROM personas_rol WHERE idRol = ? AND idPersonas = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, idRol);
            pstmt.setInt(2, idPersonas);
            pstmt.executeUpdate();
            System.out.println("Relación eliminada: idRol = " + idRol + ", idPersonas = " + idPersonas);
        }
    }

    public static List<PersonasRol> obtenerTodos() throws SQLException {
        List<PersonasRol> relaciones = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM personas_rol";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                relaciones.add(new PersonasRol(
                        rs.getInt("idRol"),
                        rs.getInt("idPersonas")
                ));
            }
        }
        return relaciones;
    }

}
