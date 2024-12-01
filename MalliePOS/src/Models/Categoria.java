package Models;

import utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Categoria {
    private int idCategoria;
    private String NombreCategoria;
    
    //constructor
    public Categoria(int idCategoria, String nombreCategoria) {
        this.idCategoria=idCategoria;
        this.NombreCategoria=nombreCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return NombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.NombreCategoria = nombreCategoria;
    }
    
    //metodos de operacion
    
    //Metodo para guardar una categoria de producto "NUEVA"
    public void guardar() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "INSERT INTO categoria (NombreCategoria) VALUES (?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, NombreCategoria);
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                this.idCategoria = rs.getInt(1);
            }
            System.out.println("Categoria guardada con ID: " + this.idCategoria);
        }
    }
    
    //Prueba Metodo Guardar:
    /*public static void main (String args[]){
        //creacion de objeto
        Categoria nuevaCategoria = new Categoria(1, "pantalon");
        try {
            nuevaCategoria.guardar();
        } catch (SQLException e){
            System.err.println("Error al guardar el Categoria: " + e.getMessage());
        }
    }*/
    
    public static Categoria buscarPorId (int id) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM categoria WHERE idCategoria = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Categoria(
                        rs.getInt("idCategoria"),
                        rs.getString("NombreCategoria")
                );
            }
        }
        return null;
    }
    
    //prueba de buscar por id y metodos getters
    /*
    public static void main (String args[]){
        Categoria categoriaLeida;
        try{
            categoriaLeida= Categoria.buscarPorId(1);
            if(categoriaLeida!=null){
                System.out.println("La categoria ha sido leida");
                System.out.println("Su id es: "+categoriaLeida.getIdCategoria());
                System.out.println("Su nombre es: "+categoriaLeida.getNombreCategoria());
            } else {
                System.out.println("No se ha podido leer la categoria numero:"+1);
            }
        } catch (SQLException e) {
            System.out.println("Error al leer categoria: "+e.getMessage());
        }
    }*/
    
    public void actualizar () throws SQLException{
        Connection connection = DatabaseConnection.getConnection();
        String query = "UPDATE categoria SET NombreCategoria=? WHERE idCategoria=?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)){
            pstmt.setString(1, NombreCategoria);
            pstmt.setInt(2, idCategoria);
            pstmt.executeUpdate();
            System.out.println("se ha actualizado la categoria "+this.idCategoria);
        }
    }
    
    //prueba de actualizacion
    /*
    public static void main (String args[]){
        try{
            Categoria actualizaCategoria = Categoria.buscarPorId(1);
            if (actualizaCategoria!=null){
            actualizaCategoria.setNombreCategoria("Camisa");
            try{
                actualizaCategoria.actualizar();
            } catch (SQLException e) {
                System.err.println("Error al intentar actualizar"+e);
            }
            } else {
                System.out.println("La categoria esta vacia");
            }
        } catch (SQLException e){
            System.out.println("Error al leer la categoria"+e.getMessage());
        }
    }   
    */
    
    public void eliminar() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String query = "DELETE FROM categoria WHERE idCategoria=?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)){
            pstmt.setInt(1, idCategoria);
            pstmt.executeUpdate();
            System.out.println("La categoria ha sido eliminada");
        }
    }
    
    //prueba para eliminar categoria:
    /*
    public static void main(String args[]){
        try{
            Categoria eliminarCategoria = Categoria.buscarPorId(3);
            if (eliminarCategoria!=null){
                try{
                    eliminarCategoria.eliminar();
                } catch (SQLException e){
                    System.err.println("Error al intentar eliminar "+e);
                }
            } else {
                System.out.println("La categoria esta vacia en el id "+3);
            }
        } catch (SQLException e){
            System.err.println("Error al buscar la categoria "+e);
        }
    }
    */
    
    public static List<Categoria> obtenerTodos() throws SQLException {
        List<Categoria> categoria = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM categoria";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                categoria.add(new Categoria(
                        rs.getInt("idCategoria"),
                        rs.getString("NombreCategoria")
                ));
            }
        }
        return categoria;
    }
}
