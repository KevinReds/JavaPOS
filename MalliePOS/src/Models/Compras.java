package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.DatabaseConnection;

/**
 * Clase Compras que representa la tabla compras.
 */
public class Compras {

    private int idEntrada;
    private int idTercero;
    private Date fecha;
    private String numeroFacturaProveedor;
    private String estado;
    private float total;
    private String pago;

    // Constructor vacío
    public Compras() {
    }

    // Constructor con parámetros
    public Compras(int idEntrada, int idTercero, Date fecha, String numeroFacturaProveedor, String estado, float total, String pago) {
        this.idEntrada = idEntrada;
        this.idTercero = idTercero;
        this.fecha = fecha;
        this.numeroFacturaProveedor = numeroFacturaProveedor;
        this.estado = estado;
        this.total = total;
        this.pago = pago;
    }

    // Getters y Setters
    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
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

    public String getNumeroFacturaProveedor() {
        return numeroFacturaProveedor;
    }

    public void setNumeroFacturaProveedor(String numeroFacturaProveedor) {
        this.numeroFacturaProveedor = numeroFacturaProveedor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    // Métodos de Operación
    public void guardar() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "INSERT INTO compras (idTercero, Fecha, N°FactProveedor, Estado, Total, Pago) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, idTercero);
            pstmt.setDate(2, fecha);
            pstmt.setString(3, numeroFacturaProveedor);
            pstmt.setString(4, estado);
            pstmt.setFloat(5, total);
            pstmt.setString(6, pago);
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                this.idEntrada = rs.getInt(1);
            }
            System.out.println("Compra guardada con ID: " + this.idEntrada);
        }
    }

    public static Compras buscarPorId(int id) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM compras WHERE idEntrada = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Compras(
                        rs.getInt("idEntrada"),
                        rs.getInt("idTercero"),
                        rs.getDate("Fecha"),
                        rs.getString("N°FactProveedor"),
                        rs.getString("Estado"),
                        rs.getFloat("Total"),
                        rs.getString("Pago")
                );
            }
        }
        return null;
    }

    public void actualizar() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "UPDATE compras SET idTercero = ?, Fecha = ?, N°FactProveedor = ?, Estado = ?, Total = ?, Pago = ? WHERE idEntrada = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, idTercero);
            pstmt.setDate(2, fecha);
            pstmt.setString(3, numeroFacturaProveedor);
            pstmt.setString(4, estado);
            pstmt.setFloat(5, total);
            pstmt.setString(6, pago);
            pstmt.setInt(7, idEntrada);
            pstmt.executeUpdate();
            System.out.println("Compra actualizada con ID: " + this.idEntrada);
        }
    }

    public void eliminar() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "DELETE FROM compras WHERE idEntrada = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, idEntrada);
            pstmt.executeUpdate();
            System.out.println("Compra eliminada con ID: " + this.idEntrada);
        }
    }

    public static List<Compras> obtenerTodos() throws SQLException {
        List<Compras> compras = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM compras";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                compras.add(new Compras(
                        rs.getInt("idEntrada"),
                        rs.getInt("idTercero"),
                        rs.getDate("Fecha"),
                        rs.getString("N°FactProveedor"),
                        rs.getString("Estado"),
                        rs.getFloat("Total"),
                        rs.getString("Pago")
                ));
            }
        }
        return compras;
    }
}
