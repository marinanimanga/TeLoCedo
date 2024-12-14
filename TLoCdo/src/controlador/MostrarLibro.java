package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

public class MostrarLibro {
	
	private int archivo;
	
	public MostrarLibro(int archivo) {
		this.archivo = archivo;
	}
	
	public String mostrarDatos(int archivo) throws IOException {
		
		String resultado = "";
		String sql = "SELECT titulo, nom_usuario, apellido1, apellido2, descripcion, notas_autor, archivo FROM libros, usuarios WHERE libros.id_usuario = usuarios.id AND libros.id = ?";
		
		Conexion c = new Conexion();
		Connection conn = c.conectar();
		
		PreparedStatement ps = null;
	    ResultSet rs = null;
		
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, archivo);
			
			rs = ps.executeQuery();
			
			
			
			while(rs.next()) {
				resultado = "TÍTULO: \n" + rs.getString("titulo") + "\n"
						+ "\n"
						+ "AUTOR/A: " + rs.getString("nom_usuario") + " " + rs.getString("apellido1") + " " + rs.getString("apellido2") + "\n"
						+ "\n"
						+ "DESCRIPCIÓN: \n" + rs.getString("descripcion") + "\n"
						+ "\n"
						+ "NOTAS DEL AUTOR/A: \n" + rs.getString("notas_autor") + "\n"
						;
			}
			
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
		
	}
	
}
