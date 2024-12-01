package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.DatabaseConnection;

/**
 * Clase DetalleCompras que representa la tabla detalle_compras.
 */
public class DetalleCompras {

    private int idDetalleEntrada;
    private int idProducto;
    private int idCategoria;
    private int idEntrada;
    private int idTercero;
    private int cantidad;
    private float subTotal;
    private float descuento;

    // Constructor vacío
    public DetalleCompras() {
    }

    // Constructor con parámetros
    public DetalleCompras(int idDetalleEntrada, int idProducto, int idCategoria, int idEntrada, int idTercero, int cantidad, float subTotal, float descuento) {
        this.idDetalleEntrada = idDetalleEntrada;
        this.idProducto = idProducto;
        this.idCategoria = idCategoria;
        this.idEntrada = idEntrada;
        this.idTercero = idTercero;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
        this.descuento = descuento;
    }

    // Getters y Setters
    public int getIdDetalleEntrada() {
        return idDetalleEntrada;
    }

    public void setIdDetalleEntrada(int idDetalleEntrada) {
        this.idDetalleEntrada = idDetalleEntrada;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
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
        String query = "INSERT INTO detalle_compras (idProducto, idCategoria, idEntrada, idTercero, Cantidad, SubTotal, Descuento) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, idProducto);
            pstmt.setInt(2, idCategoria);
            pstmt.setInt(3, idEntrada);
            pstmt.setInt(4, idTercero);
            pstmt.setInt(5, cantidad);
            pstmt.setFloat(6, subTotal);
            pstmt.setFloat(7, descuento);
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                this.idDetalleEntrada = rs.getInt(1);
            }
            System.out.println("Detalle de compra guardado con ID: " + this.idDetalleEntrada);
        }
    }

    public static DetalleCompras buscarPorId(int id) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM detalle_compras WHERE idDetalleEntrada = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new DetalleCompras(
                        rs.getInt("idDetalleEntrada"),
                        rs.getInt("idProducto"),
                        rs.getInt("idCategoria"),
                        rs.getInt("idEntrada"),
                        rs.getInt("idTercero"),
                        rs.getInt("Cantidad"),
                        rs.getFloat("SubTotal"),
                        rs.getFloat("Descuento")
                );
            }
        }
        return null;
    }

    public void actualizar() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "UPDATE detalle_compras SET idProducto = ?, idCategoria = ?, idEntrada = ?, idTercero = ?, Cantidad = ?, SubTotal = ?, Descuento = ? WHERE idDetalleEntrada = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, idProducto);
            pstmt.setInt(2, idCategoria);
            pstmt.setInt(3, idEntrada);
            pstmt.setInt(4, idTercero);
            pstmt.setInt(5, cantidad);
            pstmt.setFloat(6, subTotal);
            pstmt.setFloat(7, descuento);
            pstmt.setInt(8, idDetalleEntrada);
            pstmt.executeUpdate();
            System.out.println("Detalle de compra actualizado con ID: " + this.idDetalleEntrada);
        }
    }

    public void eliminar() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "DELETE FROM detalle_compras WHERE idDetalleEntrada = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, idDetalleEntrada);
            pstmt.executeUpdate();
            System.out.println("Detalle de compra eliminado con ID: " + this.idDetalleEntrada);
        }
    }

    public static List<DetalleCompras> obtenerTodos() throws SQLException {
        List<DetalleCompras> detalles = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM detalle_compras";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                detalles.add(new DetalleCompras(
                        rs.getInt("idDetalleEntrada"),
                        rs.getInt("idProducto"),
                        rs.getInt("idCategoria"),
                        rs.getInt("idEntrada"),
                        rs.getInt("idTercero"),
                        rs.getInt("Cantidad"),
                        rs.getFloat("SubTotal"),
                        rs.getFloat("Descuento")
                ));
            }
        }
        return detalles;
    }
}
