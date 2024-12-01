package Controllers;

import Models.Persona;
import java.sql.SQLException;
import java.util.List;

/**
 * Controlador para manejar operaciones de Persona.
 */
public class PersonaController {

    /**
     * Crea una nueva persona y la guarda en la base de datos.
     *
     * @param tipo                Tipo de la persona.
     * @param identificacion      Identificación de la persona.
     * @param regimenTributario   Régimen tributario de la persona.
     * @param contribuyente       Contribuyente (responsabilidad tributaria).
     * @param nombre              Nombre de la persona.
     * @param direccion           Dirección de la persona.
     * @param telefono            Teléfono de la persona.
     * @param email               Email de la persona.
     * @return La persona creada.
     * @throws SQLException Si ocurre un error de SQL.
     */
    public Persona crearPersona(String tipo, String identificacion, String regimenTributario, String contribuyente,
                                String nombre, String direccion, String telefono, String email) throws SQLException {
        Persona persona = new Persona(0, tipo, identificacion, regimenTributario, contribuyente, nombre, direccion, telefono, email);
        persona.guardar();
        return persona;
    }

    /**
     * Busca una persona por su ID.
     *
     * @param id ID de la persona.
     * @return La persona encontrada o null si no existe.
     * @throws SQLException Si ocurre un error de SQL.
     */
    public Persona buscarPersonaPorId(int id) throws SQLException {
        return Persona.buscarPorId(id);
    }

    /**
     * Actualiza una persona existente.
     *
     * @param idPersonas          ID de la persona a actualizar.
     * @param tipo                Nuevo tipo de la persona.
     * @param identificacion      Nueva identificación.
     * @param regimenTributario   Nuevo régimen tributario.
     * @param contribuyente       Nueva contribuyente.
     * @param nombre              Nuevo nombre.
     * @param direccion           Nueva dirección.
     * @param telefono            Nuevo teléfono.
     * @param email               Nuevo email.
     * @throws SQLException Si ocurre un error de SQL.
     */
    public void actualizarPersona(int idPersonas, String tipo, String identificacion, String regimenTributario, 
                                  String contribuyente, String nombre, String direccion, String telefono, String email) 
                                  throws SQLException {
        Persona persona = Persona.buscarPorId(idPersonas);
        if (persona != null) {
            persona.setTipo(tipo);
            persona.setIdentificacion(identificacion);
            persona.setRegimenTributario(regimenTributario);
            persona.setContribuyente(contribuyente);
            persona.setNombre(nombre);
            persona.setDireccion(direccion);
            persona.setTelefono(telefono);
            persona.setEmail(email);
            persona.actualizar();
        } else {
            throw new SQLException("Persona con ID " + idPersonas + " no encontrada.");
        }
    }

    /**
     * Elimina una persona por su ID.
     *
     * @param idPersonas ID de la persona a eliminar.
     * @throws SQLException Si ocurre un error de SQL.
     */
    public void eliminarPersona(int idPersonas) throws SQLException {
        Persona persona = Persona.buscarPorId(idPersonas);
        if (persona != null) {
            persona.eliminar();
        } else {
            throw new SQLException("Persona con ID " + idPersonas + " no encontrada.");
        }
    }

    /**
     * Obtiene todas las personas de la base de datos.
     *
     * @return Una lista de todas las personas.
     * @throws SQLException Si ocurre un error de SQL.
     */
    public List<Persona> obtenerTodasLasPersonas() throws SQLException {
        return Persona.obtenerTodos();
    }
}
