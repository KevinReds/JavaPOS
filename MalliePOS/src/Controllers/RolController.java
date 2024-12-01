package Controllers;

import Models.Rol;

import java.sql.SQLException;
import java.util.List;

public class RolController {

    // Método para guardar un nuevo rol
    public void guardarRol(String nombreRol) {
        Rol nuevoRol = new Rol(0, nombreRol);
        try {
            nuevoRol.guardar();
            System.out.println("Rol guardado exitosamente con ID: " + nuevoRol.getIdRol());
        } catch (SQLException e) {
            System.err.println("Error al guardar el rol: " + e.getMessage());
        }
    }

    // Método para buscar un rol por ID
    public void buscarRolPorId(int id) {
        try {
            Rol rol = Rol.buscarPorId(id);
            if (rol != null) {
                System.out.println("Rol encontrado:");
                System.out.println("ID: " + rol.getIdRol());
                System.out.println("Nombre: " + rol.getNombreRol());
            } else {
                System.out.println("No se encontró un rol con el ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar el rol: " + e.getMessage());
        }
    }

    // Método para actualizar un rol
    public void actualizarRol(int id, String nuevoNombre) {
        try {
            Rol rol = Rol.buscarPorId(id);
            if (rol != null) {
                rol.setNombreRol(nuevoNombre);
                rol.actualizar();
                System.out.println("Rol actualizado exitosamente.");
            } else {
                System.out.println("No se encontró un rol con el ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar el rol: " + e.getMessage());
        }
    }

    // Método para eliminar un rol
    public void eliminarRol(int id) {
        try {
            Rol rol = Rol.buscarPorId(id);
            if (rol != null) {
                rol.eliminar();
                System.out.println("Rol eliminado exitosamente.");
            } else {
                System.out.println("No se encontró un rol con el ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar el rol: " + e.getMessage());
        }
    }

    // Método para listar todos los roles
    public void listarRoles() {
        try {
            List<Rol> roles = Rol.obtenerTodos();
            if (!roles.isEmpty()) {
                System.out.println("Lista de roles:");
                for (Rol rol : roles) {
                    System.out.println("ID: " + rol.getIdRol() + ", Nombre: " + rol.getNombreRol());
                }
            } else {
                System.out.println("No hay roles disponibles.");
            }
        } catch (SQLException e) {
            System.err.println("Error al listar los roles: " + e.getMessage());
        }
    }
}
