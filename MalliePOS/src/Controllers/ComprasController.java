package Controllers;

import Models.Compras;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class ComprasController {

    // Método para guardar una nueva compra
    public void guardarCompra(int idTercero, Date fecha, String numeroFacturaProveedor, String estado, float total, String pago) {
        Compras nuevaCompra = new Compras(0, idTercero, fecha, numeroFacturaProveedor, estado, total, pago);
        try {
            nuevaCompra.guardar();
            System.out.println("Compra guardada exitosamente con ID: " + nuevaCompra.getIdEntrada());
        } catch (SQLException e) {
            System.err.println("Error al guardar la compra: " + e.getMessage());
        }
    }

    // Método para buscar una compra por ID
    public void buscarCompraPorId(int id) {
        try {
            Compras compra = Compras.buscarPorId(id);
            if (compra != null) {
                System.out.println("Compra encontrada:");
                System.out.println("ID Entrada: " + compra.getIdEntrada());
                System.out.println("ID Tercero: " + compra.getIdTercero());
                System.out.println("Fecha: " + compra.getFecha());
                System.out.println("N° Factura Proveedor: " + compra.getNumeroFacturaProveedor());
                System.out.println("Estado: " + compra.getEstado());
                System.out.println("Total: " + compra.getTotal());
                System.out.println("Pago: " + compra.getPago());
            } else {
                System.out.println("No se encontró una compra con el ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar la compra: " + e.getMessage());
        }
    }

    // Método para actualizar una compra
    public void actualizarCompra(int idEntrada, int idTercero, Date fecha, String numeroFacturaProveedor, String estado, float total, String pago) {
        try {
            Compras compra = Compras.buscarPorId(idEntrada);
            if (compra != null) {
                compra.setIdTercero(idTercero);
                compra.setFecha(fecha);
                compra.setNumeroFacturaProveedor(numeroFacturaProveedor);
                compra.setEstado(estado);
                compra.setTotal(total);
                compra.setPago(pago);
                compra.actualizar();
                System.out.println("Compra actualizada exitosamente.");
            } else {
                System.out.println("No se encontró una compra con el ID: " + idEntrada);
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar la compra: " + e.getMessage());
        }
    }

    // Método para eliminar una compra
    public void eliminarCompra(int idEntrada) {
        try {
            Compras compra = Compras.buscarPorId(idEntrada);
            if (compra != null) {
                compra.eliminar();
                System.out.println("Compra eliminada exitosamente.");
            } else {
                System.out.println("No se encontró una compra con el ID: " + idEntrada);
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar la compra: " + e.getMessage());
        }
    }

    // Método para listar todas las compras
    public void listarCompras() {
        try {
            List<Compras> compras = Compras.obtenerTodos();
            if (!compras.isEmpty()) {
                System.out.println("Lista de compras:");
                for (Compras compra : compras) {
                    System.out.println("ID Entrada: " + compra.getIdEntrada() +
                            ", ID Tercero: " + compra.getIdTercero() +
                            ", Fecha: " + compra.getFecha() +
                            ", N° Factura Proveedor: " + compra.getNumeroFacturaProveedor() +
                            ", Estado: " + compra.getEstado() +
                            ", Total: " + compra.getTotal() +
                            ", Pago: " + compra.getPago());
                }
            } else {
                System.out.println("No hay compras registradas.");
            }
        } catch (SQLException e) {
            System.err.println("Error al listar las compras: " + e.getMessage());
        }
    }
}
