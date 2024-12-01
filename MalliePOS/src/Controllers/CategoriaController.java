package Controllers;

import Models.Categoria;

import java.sql.SQLException;
import java.util.List;

public class CategoriaController {

    // Método para guardar una nueva categoría
    public void guardarCategoria(String nombreCategoria) {
        Categoria nuevaCategoria = new Categoria(0, nombreCategoria);
        try {
            nuevaCategoria.guardar();
            System.out.println("Categoría guardada exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al guardar la categoría: " + e.getMessage());
        }
    }

    // Método para buscar una categoría por su ID
    public void buscarCategoriaPorId(int id) {
        try {
            Categoria categoria = Categoria.buscarPorId(id);
            if (categoria != null) {
                System.out.println("Categoría encontrada:");
                System.out.println("ID: " + categoria.getIdCategoria());
                System.out.println("Nombre: " + categoria.getNombreCategoria());
            } else {
                System.out.println("No se encontró una categoría con el ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar la categoría: " + e.getMessage());
        }
    }

    // Método para actualizar una categoría
    public void actualizarCategoria(int id, String nuevoNombre) {
        try {
            Categoria categoria = Categoria.buscarPorId(id);
            if (categoria != null) {
                categoria.setNombreCategoria(nuevoNombre);
                categoria.actualizar();
                System.out.println("Categoría actualizada exitosamente.");
            } else {
                System.out.println("No se encontró una categoría con el ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar la categoría: " + e.getMessage());
        }
    }

    // Método para eliminar una categoría
    public void eliminarCategoria(int id) {
        try {
            Categoria categoria = Categoria.buscarPorId(id);
            if (categoria != null) {
                categoria.eliminar();
                System.out.println("Categoría eliminada exitosamente.");
            } else {
                System.out.println("No se encontró una categoría con el ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar la categoría: " + e.getMessage());
        }
    }

    // Método para obtener todas las categorías
    public void listarCategorias() {
        try {
            List<Categoria> categorias = Categoria.obtenerTodos();
            if (!categorias.isEmpty()) {
                System.out.println("Lista de categorías:");
                for (Categoria categoria : categorias) {
                    System.out.println("ID: " + categoria.getIdCategoria() + ", Nombre: " + categoria.getNombreCategoria());
                }
            } else {
                System.out.println("No hay categorías disponibles.");
            }
        } catch (SQLException e) {
            System.err.println("Error al listar las categorías: " + e.getMessage());
        }
    }
}
