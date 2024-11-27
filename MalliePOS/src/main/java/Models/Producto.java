/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Kevin
 */
public class Producto {
    private int idProducto;
    private int idCategoria;
    private String referencia;
    private String nombre;
    private String descripcion;
    private int stock;
    private float precio;

    // Constructor
    public Producto(int idProducto, int idCategoria, String referencia, String nombre, String descripcion, int stock, float precio) {
        this.idProducto = idProducto;
        this.idCategoria = idCategoria;
        this.referencia = referencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
    }

    // Getters y Setters
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

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    // Métodos de Operación
    public void guardar() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "INSERT INTO productos (idCategoria, referencia, nombre, descripcion, stock, precio) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, idCategoria);
            pstmt.setString(2, referencia);
            pstmt.setString(3, nombre);
            pstmt.setString(4, descripcion);
            pstmt.setInt(5, stock);
            pstmt.setFloat(6, precio);
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                this.idProducto = rs.getInt(1);
            }
            System.out.println("Producto guardado con ID: " + this.idProducto);
        }
    }

    public static Producto buscarPorId(int id) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM productos WHERE idProducto = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Producto(
                        rs.getInt("idProducto"),
                        rs.getInt("idCategoria"),
                        rs.getString("referencia"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getInt("stock"),
                        rs.getFloat("precio")
                );
            }
        }
        return null;
    }

    public void actualizar() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "UPDATE productos SET idCategoria = ?, referencia = ?, nombre = ?, descripcion = ?, stock = ?, precio = ? WHERE idProducto = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, idCategoria);
            pstmt.setString(2, referencia);
            pstmt.setString(3, nombre);
            pstmt.setString(4, descripcion);
            pstmt.setInt(5, stock);
            pstmt.setFloat(6, precio);
            pstmt.setInt(7, idProducto);
            pstmt.executeUpdate();
            System.out.println("Producto actualizado: " + this.idProducto);
        }
    }

    public void eliminar() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "DELETE FROM productos WHERE idProducto = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, idProducto);
            pstmt.executeUpdate();
            System.out.println("Producto eliminado: " + this.idProducto);
        }
    }

    public static List<Producto> obtenerTodos() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM productos";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                productos.add(new Producto(
                        rs.getInt("idProducto"),
                        rs.getInt("idCategoria"),
                        rs.getString("referencia"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getInt("stock"),
                        rs.getFloat("precio")
                ));
            }
        }
        return productos;
    }
}
