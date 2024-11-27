/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sena.malliepos;

import Models.Producto;

import java.sql.SQLException;

import GUI.Bienvenida;

public class MalliePOS {

    public static void main(String[] args) {
        Bienvenida bienvenida = new Bienvenida();
        bienvenida.setVisible(true);
        /*     try {
            // Crear y guardar un producto
            Producto nuevoProducto = new Producto(1, 1, "REF123", "Camiseta", "Camiseta azul", 50, 50000);
            nuevoProducto.guardar();

            // Buscar un producto por ID
            Producto productoEncontrado = Producto.buscarPorId(nuevoProducto.getIdProducto());
            if (productoEncontrado != null) {
                System.out.println("Producto encontrado: " + productoEncontrado.getNombre());
            }

            // Actualizar un producto
            productoEncontrado.setNombre("Camiseta Actualizada");
            productoEncontrado.actualizar();

            // Obtener todos los productos
            Producto.obtenerTodos().forEach(producto -> System.out.println(producto.getNombre()));

            // Eliminar el producto
            productoEncontrado.eliminar();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
