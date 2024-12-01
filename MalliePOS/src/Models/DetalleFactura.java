package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.DatabaseConnection;

/**
 * Clase DetalleFactura que representa la tabla detalle_factura.
 */
public class DetalleFactura {

    private int idDetalleFactura;
    private int idProducto;
    private int idCategoria;
    private int idFactura;
    private int idTercero;
    private int cantidad;
    private float precioUnitario;
    private float subtotal;
    private float descuento;

    // Constructor vacío
    public DetalleFactura() {
    }

    // Constructor con parámetros
    public DetalleFactura(int idDetalleFactura, int idProducto, int idCategoria, int idFactura, int idTercero, int cantidad, float precioUnitario, float subtotal, float descuento) {
        this.idDetalleFactura = idDetalleFactura;
        this.idProducto = idProducto;
        this.idCategoria = idCategoria;
        this.idFactura = idFactura;
        this.idTercero = idTercero;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
        this.descuento = descuento;
    }

    // Getters y Setters
    public int getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(int idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    // Métodos de Operación
    public void guardar() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "INSERT INTO detalle_factura (idProducto, idCategoria, idFactura, idTercero, Cantidad, PrecioUnitario, Subtotal, Descuento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, idProducto);
            pstmt.setInt(2, idCategoria);
            pstmt.setInt(3, idFactura);
            pstmt.setInt(4, idTercero);
            pstmt.setInt(5, cantidad);
            pstmt.setFloat(6, precioUnitario);
            pstmt.setFloat(7, subtotal);
            pstmt.setFloat(8, descuento);
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                this.idDetalleFactura = rs.getInt(1);
            }
            System.out.println("DetalleFactura guardado con ID: " + this.idDetalleFactura);
        }
    }

    public static DetalleFactura buscarPorId(int id) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM detalle_factura WHERE idDetalleFactura = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new DetalleFactura(
                        rs.getInt("idDetalleFactura"),
                        rs.getInt("idProducto"),
                        rs.getInt("idCategoria"),
                        rs.getInt("idFactura"),
                        rs.getInt("idTercero"),
                        rs.getInt("Cantidad"),
                        rs.getFloat("PrecioUnitario"),
                        rs.getFloat("Subtotal"),
                        rs.getFloat("Descuento")
                );
            }
        }
        return null;
    }

    public void actualizar() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "UPDATE detalle_factura SET idProducto = ?, idCategoria = ?, idFactura = ?, idTercero = ?, Cantidad = ?, PrecioUnitario = ?, Subtotal = ?, Descuento = ? WHERE idDetalleFactura = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, idProducto);
            pstmt.setInt(2, idCategoria);
            pstmt.setInt(3, idFactura);
            pstmt.setInt(4, idTercero);
            pstmt.setInt(5, cantidad);
            pstmt.setFloat(6, precioUnitario);
            pstmt.setFloat(7, subtotal);
            pstmt.setFloat(8, descuento);
            pstmt.setInt(9, idDetalleFactura);
            pstmt.executeUpdate();
            System.out.println("DetalleFactura actualizado con ID: " + this.idDetalleFactura);
        }
    }

    public void eliminar() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "DELETE FROM detalle_factura WHERE idDetalleFactura = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, idDetalleFactura);
            pstmt.executeUpdate();
            System.out.println("DetalleFactura eliminado con ID: " + this.idDetalleFactura);
        }
    }

    public static List<DetalleFactura> obtenerTodos() throws SQLException {
        List<DetalleFactura> detalles = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM detalle_factura";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                detalles.add(new DetalleFactura(
                        rs.getInt("idDetalleFactura"),
                        rs.getInt("idProducto"),
                        rs.getInt("idCategoria"),
                        rs.getInt("idFactura"),
                        rs.getInt("idTercero"),
                        rs.getInt("Cantidad"),
                        rs.getFloat("PrecioUnitario"),
                        rs.getFloat("Subtotal"),
                        rs.getFloat("Descuento")
                ));
            }
        }
        return detalles;
    }
}
