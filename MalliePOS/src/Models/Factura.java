package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.DatabaseConnection;

/**
 * Clase Factura que representa la tabla factura.
 */
public class Factura {

    private int idFactura;
    private int idTercero;
    private Date fecha;
    private float total;

    // Constructor vacío
    public Factura() {
    }

    // Constructor con parámetros
    public Factura(int idFactura, int idTercero, Date fecha, float total) {
        this.idFactura = idFactura;
        this.idTercero = idTercero;
        this.fecha = fecha;
        this.total = total;
    }

    // Getters y Setters
    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdTercero() {
        return idTercero;
    }

    public void setIdTercero(int idTercero) {
        this.idTercero = idTercero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    // Métodos de Operación
    public void guardar() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "INSERT INTO factura (idTercero, Fecha, Total) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, idTercero);
            pstmt.setDate(2, fecha);
            pstmt.setFloat(3, total);
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                this.idFactura = rs.getInt(1);
            }
            System.out.println("Factura guardada con ID: " + this.idFactura);
        }
    }

    public static Factura buscarPorId(int id) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM factura WHERE idFactura = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Factura(
                        rs.getInt("idFactura"),
                        rs.getInt("idTercero"),
                        rs.getDate("Fecha"),
                        rs.getFloat("Total")
                );
            }
        }
        return null;
    }

    public void actualizar() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "UPDATE factura SET idTercero = ?, Fecha = ?, Total = ? WHERE idFactura = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, idTercero);
            pstmt.setDate(2, fecha);
            pstmt.setFloat(3, total);
            pstmt.setInt(4, idFactura);
            pstmt.executeUpdate();
            System.out.println("Factura actualizada con ID: " + this.idFactura);
        }
    }

    public void eliminar() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "DELETE FROM factura WHERE idFactura = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, idFactura);
            pstmt.executeUpdate();
            System.out.println("Factura eliminada con ID: " + this.idFactura);
        }
    }

    public static List<Factura> obtenerTodos() throws SQLException {
        List<Factura> facturas = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM factura";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                facturas.add(new Factura(
                        rs.getInt("idFactura"),
                        rs.getInt("idTercero"),
                        rs.getDate("Fecha"),
                        rs.getFloat("Total")
                ));
            }
        }
        return facturas;
    }

    // Método toString para facilitar la depuración
    @Override
    public String toString() {
        return "Factura{" +
                "idFactura=" + idFactura +
                ", idTercero=" + idTercero +
                ", fecha=" + fecha +
                ", total=" + total +
                '}';
    }
}
