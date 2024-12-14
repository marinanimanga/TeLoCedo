package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;

public class ComprobarNick {
	
	private JTextField nick;
	
	public ComprobarNick(JTextField nick) {
		this.nick=nick;
	}
	
	public int compruebaNick() {
		
		Conexion c = new Conexion();
		Connection conn = c.conectar();
		ResultSet rs;
		int resultado = 3;
		
		String consulta = "SELECT nick FROM usuarios";
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(consulta);
			
			while(rs.next()) {
				String nombre = rs.getString("nick");
				
				if(nombre.equals(nick.getText())) {
					resultado = 1;
					break;
				} 
			}
		conn.close();
		rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}
}
