package Controllers;

import Models.Factura;
import java.sql.SQLException;
import java.util.List;

/**
 * Controlador para manejar operaciones de Factura.
 */
public class FacturaController {

    /**
     * Crea una nueva factura y la guarda en la base de datos.
     *
     * @param idTercero  ID del tercero asociado a la factura.
     * @param fecha      Fecha de la factura.
     * @param total      Total de la factura.
     * @return La factura creada.
     * @throws SQLException Si ocurre un error de SQL.
     */
    public Factura crearFactura(int idTercero, java.sql.Date fecha, float total) throws SQLException {
        Factura factura = new Factura(0, idTercero, fecha, total);
        factura.guardar();
        return factura;
    }

    /**
     * Busca una factura por su ID.
     *
     * @param id ID de la factura.
     * @return La factura encontrada o null si no existe.
     * @throws SQLException Si ocurre un error de SQL.
     */
    public Factura buscarFacturaPorId(int id) throws SQLException {
        return Factura.buscarPorId(id);
    }

    /**
     * Actualiza una factura existente.
     *
     * @param idFactura  ID de la factura a actualizar.
     * @param idTercero  Nuevo ID del tercero.
     * @param fecha      Nueva fecha de la factura.
     * @param total      Nuevo total de la factura.
     * @throws SQLException Si ocurre un error de SQL.
     */
    public void actualizarFactura(int idFactura, int idTercero, java.sql.Date fecha, float total) throws SQLException {
        Factura factura = Factura.buscarPorId(idFactura);
        if (factura != null) {
            factura.setIdTercero(idTercero);
            factura.setFecha(fecha);
            factura.setTotal(total);
            factura.actualizar();
        } else {
            throw new SQLException("Factura con ID " + idFactura + " no encontrada.");
        }
    }

    /**
     * Elimina una factura por su ID.
     *
     * @param idFactura ID de la factura a eliminar.
     * @throws SQLException Si ocurre un error de SQL.
     */
    public void eliminarFactura(int idFactura) throws SQLException {
        Factura factura = Factura.buscarPorId(idFactura);
        if (factura != null) {
            factura.eliminar();
        } else {
            throw new SQLException("Factura con ID " + idFactura + " no encontrada.");
        }
    }

    /**
     * Obtiene todas las facturas de la base de datos.
     *
     * @return Una lista de todas las facturas.
     * @throws SQLException Si ocurre un error de SQL.
     */
    public List<Factura> obtenerTodasLasFacturas() throws SQLException {
        return Factura.obtenerTodos();
    }
}