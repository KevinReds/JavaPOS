package Controllers;

import Models.PersonasRol;

import java.sql.SQLException;
import java.util.List;

/**
 * Controlador para manejar la lógica de PersonasRol.
 */
public class PersonasRolController {

    /**
     * Método para guardar una nueva relación entre persona y rol.
     *
     * @param idRol       ID del rol.
     * @param idPersonas  ID de la persona.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void guardarRelacion(int idRol, int idPersonas) throws SQLException {
        PersonasRol personasRol = new PersonasRol(idRol, idPersonas);
        personasRol.guardar();
    }

    /**
     * Método para buscar una relación específica por ID de rol y persona.
     *
     * @param idRol       ID del rol.
     * @param idPersonas  ID de la persona.
     * @return Una instancia de PersonasRol si se encuentra, o null si no.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public PersonasRol buscarRelacion(int idRol, int idPersonas) throws SQLException {
        return PersonasRol.buscarPorId(idRol, idPersonas);
    }

    /**
     * Método para actualizar una relación existente.
     *
     * @param idRol          ID actual del rol.
     * @param idPersonas     ID actual de la persona.
     * @param nuevoIdRol     Nuevo ID del rol.
     * @param nuevoIdPersonas Nuevo ID de la persona.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void actualizarRelacion(int idRol, int idPersonas, int nuevoIdRol, int nuevoIdPersonas) throws SQLException {
        PersonasRol personasRol = new PersonasRol(idRol, idPersonas);
        personasRol.actualizar(nuevoIdRol, nuevoIdPersonas);
    }

    /**
     * Método para eliminar una relación específica.
     *
     * @param idRol       ID del rol.
     * @param idPersonas  ID de la persona.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void eliminarRelacion(int idRol, int idPersonas) throws SQLException {
        PersonasRol personasRol = new PersonasRol(idRol, idPersonas);
        personasRol.eliminar();
    }

    /**
     * Método para obtener todas las relaciones de la tabla personas_rol.
     *
     * @return Una lista de todas las relaciones entre personas y roles.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public List<PersonasRol> obtenerTodasLasRelaciones() throws SQLException {
        return PersonasRol.obtenerTodos();
    }
}