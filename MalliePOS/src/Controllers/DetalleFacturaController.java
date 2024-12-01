package Controllers;

import Models.DetalleFactura;

import java.sql.SQLException;
import java.util.List;

public class DetalleFacturaController {

    // Método para guardar un nuevo detalle de factura
    public String guardarDetalleFactura(DetalleFactura detalleFactura) {
        try {
            detalleFactura.guardar();
            return "DetalleFactura guardado exitosamente con ID: " + detalleFactura.getIdDetalleFactura();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al guardar el detalle de factura: " + e.getMessage();
        }
    }

    // Método para buscar un detalle de factura por su ID
    public DetalleFactura buscarDetallePorId(int id) {
        try {
            DetalleFactura detalle = DetalleFactura.buscarPorId(id);
            if (detalle != null) {
                return detalle;
            } else {
                System.out.println("DetalleFactura con ID " + id + " no encontrado.");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para actualizar un detalle de factura
    public String actualizarDetalleFactura(DetalleFactura detalleFactura) {
        try {
            detalleFactura.actualizar();
            return "DetalleFactura actualizado exitosamente con ID: " + detalleFactura.getIdDetalleFactura();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al actualizar el detalle de factura: " + e.getMessage();
        }
    }

    // Método para eliminar un detalle de factura
    public String eliminarDetalleFactura(int idDetalleFactura) {
        try {
            DetalleFactura detalleFactura = new DetalleFactura();
            detalleFactura.setIdDetalleFactura(idDetalleFactura);
            detalleFactura.eliminar();
            return "DetalleFactura eliminado exitosamente con ID: " + idDetalleFactura;
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al eliminar el detalle de factura: " + e.getMessage();
        }
    }

    // Método para obtener todos los detalles de factura
    public List<DetalleFactura> obtenerTodosLosDetalles() {
        try {
            return DetalleFactura.obtenerTodos();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
