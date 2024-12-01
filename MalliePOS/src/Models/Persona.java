package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.DatabaseConnection;

/**
 * Clase Persona que representa la tabla personas.
 */
public class Persona {

    private int idPersonas;
    private String tipo;
    private String identificacion;
    private String regimenTributario;
    private String contribuyente;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;

    // Constructor vacío
    public Persona() {
    }

    // Constructor con parámetros
    public Persona(int idPersonas, String tipo, String identificacion, String regimenTributario,
                   String contribuyente, String nombre, String direccion, String telefono, String email) {
        this.idPersonas = idPersonas;
        this.tipo = tipo;
        this.identificacion = identificacion;
        this.regimenTributario = regimenTributario;
        this.contribuyente = contribuyente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    // Getters y Setters
    public int getIdPersonas() {
        return idPersonas;
    }

    public void setIdPersonas(int idPersonas) {
        this.idPersonas = idPersonas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getRegimenTributario() {
        return regimenTributario;
    }

    public void setRegimenTributario(String regimenTributario) {
        this.regimenTributario = regimenTributario;
    }

    public String getContribuyente() {
        return contribuyente;
    }

    public void setContribuyente(String contribuyente) {
        this.contribuyente = contribuyente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Métodos de Operación
    public void guardar() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "INSERT INTO personas (Tipo, Identificacion, RegimenTributario, Contribuyente, Nombre, Direccion, Telefono, Email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, tipo);
            pstmt.setString(2, identificacion);
            pstmt.setString(3, regimenTributario);
            pstmt.setString(4, contribuyente);
            pstmt.setString(5, nombre);
            pstmt.setString(6, direccion);
            pstmt.setString(7, telefono);
            pstmt.setString(8, email);
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                this.idPersonas = rs.getInt(1);
            }
            System.out.println("Persona guardada con ID: " + this.idPersonas);
        }
    }

    public static Persona buscarPorId(int id) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM personas WHERE idPersonas = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Persona(
                        rs.getInt("idPersonas"),
                        rs.getString("Tipo"),
                        rs.getString("Identificacion"),
                        rs.getString("RegimenTributario"),
                        rs.getString("Contribuyente"),
                        rs.getString("Nombre"),
                        rs.getString("Direccion"),
                        rs.getString("Telefono"),
                        rs.getString("Email")
                );
            }
        }
        return null;
    }

    public void actualizar() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "UPDATE personas SET Tipo = ?, Identificacion = ?, RegimenTributario = ?, Contribuyente = ?, Nombre = ?, Direccion = ?, Telefono = ?, Email = ? WHERE idPersonas = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, tipo);
            pstmt.setString(2, identificacion);
            pstmt.setString(3, regimenTributario);
            pstmt.setString(4, contribuyente);
            pstmt.setString(5, nombre);
            pstmt.setString(6, direccion);
            pstmt.setString(7, telefono);
            pstmt.setString(8, email);
            pstmt.setInt(9, idPersonas);
            pstmt.executeUpdate();
            System.out.println("Persona actualizada con ID: " + this.idPersonas);
        }
    }

    public void eliminar() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "DELETE FROM personas WHERE idPersonas = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, idPersonas);
            pstmt.executeUpdate();
            System.out.println("Persona eliminada con ID: " + this.idPersonas);
        }
    }

    public static List<Persona> obtenerTodos() throws SQLException {
        List<Persona> personas = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM personas";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                personas.add(new Persona(
                        rs.getInt("idPersonas"),
                        rs.getString("Tipo"),
                        rs.getString("Identificacion"),
                        rs.getString("RegimenTributario"),
                        rs.getString("Contribuyente"),
                        rs.getString("Nombre"),
                        rs.getString("Direccion"),
                        rs.getString("Telefono"),
                        rs.getString("Email")
                ));
            }
        }
        return personas;
    }

    // Método toString para facilitar la depuración
    @Override
    public String toString() {
        return "Persona{" +
                "idPersonas=" + idPersonas +
                ", tipo='" + tipo + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", regimenTributario='" + regimenTributario + '\'' +
                ", contribuyente='" + contribuyente + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
