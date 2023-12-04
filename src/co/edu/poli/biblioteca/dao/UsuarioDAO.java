package co.edu.poli.biblioteca.dao;

import co.edu.poli.biblioteca.model.Libro;
import co.edu.poli.biblioteca.model.Usuario;
import co.edu.poli.biblioteca.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
	 public List<Usuario> getUsuariosFromDatabase() {
	        List<Usuario> usuarios = new ArrayList<>();
	        Connection connection = DatabaseConnection.getConnection();

	        if (connection != null) {
	            try {
	                String query = "SELECT nombre FROM usuario"; // Ajusta el nombre de la tabla según tu base de datos
	                PreparedStatement statement = connection.prepareStatement(query);
	                ResultSet resultSet = statement.executeQuery();

	                while (resultSet.next()) {
	                    String nombre = resultSet.getString("nombre");
	                    Usuario usuario = new Usuario(nombre);
	                    usuarios.add(usuario);
	                }

	                resultSet.close();
	                statement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return usuarios;
	    }
	 public List<Libro> getLibrosFromDatabase() {
	        List<Libro> libros = new ArrayList<>();
	        Connection connection = DatabaseConnection.getConnection();

	        if (connection != null) {
	            try {
	                String query = "SELECT titulo, autor, categoria FROM libro"; 
	                PreparedStatement statement = connection.prepareStatement(query);
	                ResultSet resultSet = statement.executeQuery();

	                while (resultSet.next()) {
	                    String titulo = resultSet.getString("titulo");
	                    String autor = resultSet.getString("autor");
	                    String categoria = resultSet.getString("categoria");
	                    Libro libro = new Libro(titulo, autor, categoria);
	                    libros.add(libro);
	                }

	                resultSet.close();
	                statement.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return libros;
	    }

	
}