/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.Producto;

import java.sql.SQLException;
import java.util.List;


public class ProductoController {
    /**
     * Crea un nuevo producto y lo guarda en la base de datos.
     *
     * @param idCategoria la categoría del producto
     * @param referencia la referencia del producto
     * @param nombre el nombre del producto
     * @param descripcion una breve descripción del producto
     * @param stock la cantidad disponible
     * @param precio el precio del producto
     * @return el producto creado
     * @throws SQLException en caso de error al guardar el producto
     */
    public Producto crearProducto(int idCategoria, String referencia, String nombre, String descripcion, int stock, float precio) throws SQLException {
        Producto producto = new Producto(0, idCategoria, referencia, nombre, descripcion, stock, precio);
        producto.guardar();
        return producto;
    }

    /**
     * Obtiene un producto por su ID.
     *
     * @param idProducto el ID del producto a buscar
     * @return el producto encontrado o null si no existe
     * @throws SQLException en caso de error al buscar el producto
     */
    public Producto obtenerProductoPorId(int idProducto) throws SQLException {
        return Producto.buscarPorId(idProducto);
    }

    /**
     * Actualiza los datos de un producto existente.
     *
     * @param producto el producto con los datos actualizados
     * @throws SQLException en caso de error al actualizar el producto
     */
    public void actualizarProducto(Producto producto) throws SQLException {
        producto.actualizar();
    }

    /**
     * Elimina un producto por su ID.
     *
     * @param idProducto el ID del producto a eliminar
     * @throws SQLException en caso de error al eliminar el producto
     */
    public void eliminarProducto(int idProducto) throws SQLException {
        Producto producto = Producto.buscarPorId(idProducto);
        if (producto != null) {
            producto.eliminar();
        } else {
            throw new SQLException("El producto con ID " + idProducto + " no existe.");
        }
    }

    /**
     * Obtiene todos los productos de la base de datos.
     *
     * @return una lista de productos
     * @throws SQLException en caso de error al obtener los productos
     */
    public List<Producto> obtenerTodosLosProductos() throws SQLException {
        return Producto.obtenerTodos();
    }
}
