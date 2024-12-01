package Controllers;

import Models.DetalleCompras;
import java.sql.SQLException;
import java.util.List;

public class DetalleComprasController {

    // Método para crear un nuevo detalle de compra
    public void crearDetalleCompra(int idProducto, int idCategoria, int idEntrada, int idTercero, int cantidad, float subTotal, float descuento) {
        DetalleCompras detalle = new DetalleCompras();
        detalle.setIdProducto(idProducto);
        detalle.setIdCategoria(idCategoria);
        detalle.setIdEntrada(idEntrada);
        detalle.setIdTercero(idTercero);
        detalle.setCantidad(cantidad);
        detalle.setSubTotal(subTotal);
        detalle.setDescuento(descuento);

        try {
            detalle.guardar();
        } catch (SQLException e) {
            System.err.println("Error al guardar el detalle de compra: " + e.getMessage());
        }
    }

    // Método para buscar un detalle de compra por su ID
    public DetalleCompras obtenerDetalleCompraPorId(int idDetalleEntrada) {
        try {
            return DetalleCompras.buscarPorId(idDetalleEntrada);
        } catch (SQLException e) {
            System.err.println("Error al buscar el detalle de compra: " + e.getMessage());
            return null;
        }
    }

    // Método para actualizar un detalle de compra
    public void actualizarDetalleCompra(int idDetalleEntrada, int idProducto, int idCategoria, int idEntrada, int idTercero, int cantidad, float subTotal, float descuento) {
        try {
            DetalleCompras detalle = DetalleCompras.buscarPorId(idDetalleEntrada);
            if (detalle != null) {
                detalle.setIdProducto(idProducto);
                detalle.setIdCategoria(idCategoria);
                detalle.setIdEntrada(idEntrada);
                detalle.setIdTercero(idTercero);
                detalle.setCantidad(cantidad);
                detalle.setSubTotal(subTotal);
                detalle.setDescuento(descuento);
                detalle.actualizar();
            } else {
                System.err.println("Detalle de compra no encontrado con ID: " + idDetalleEntrada);
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar el detalle de compra: " + e.getMessage());
        }
    }

    // Método para eliminar un detalle de compra
    public void eliminarDetalleCompra(int idDetalleEntrada) {
        try {
            DetalleCompras detalle = DetalleCompras.buscarPorId(idDetalleEntrada);
            if (detalle != null) {
                detalle.eliminar();
            } else {
                System.err.println("Detalle de compra no encontrado con ID: " + idDetalleEntrada);
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar el detalle de compra: " + e.getMessage());
        }
    }

    // Método para obtener todos los detalles de compra
    public List<DetalleCompras> obtenerTodosLosDetallesDeCompra() {
        try {
            return DetalleCompras.obtenerTodos();
        } catch (SQLException e) {
            System.err.println("Error al obtener los detalles de compra: " + e.getMessage());
            return null;
        }
    }
}
