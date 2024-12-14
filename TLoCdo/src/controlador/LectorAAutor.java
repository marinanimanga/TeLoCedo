package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class LectorAAutor {
	
	private String nick = Sesion.getNickUsuario().getText();


	public LectorAAutor(String nick) {
		this.nick = nick;

	}

	public void cambiarAutor(String nick) {
		String consulta = "UPDATE usuarios SET autor_lector = 0 WHERE nick = ?";
		
		Conexion c = new Conexion();
		Connection conn = c.conectar();
		
		PreparedStatement ps;
		try {
			
			ps = conn.prepareStatement(consulta);
			ps.setString(1, nick);
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
    
	}
}
