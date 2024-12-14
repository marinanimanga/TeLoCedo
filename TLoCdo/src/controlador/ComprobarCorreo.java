package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;

public class ComprobarCorreo {

	private JTextField mail;

	public ComprobarCorreo(JTextField correo) {
		this.mail = correo;
	}

	public Boolean compruebaCorreo() {

		Conexion c = new Conexion();
		Connection conn = c.conectar();
		ResultSet rss;
		Boolean result = true;

		String consulta = "SELECT correo FROM usuarios";
		try {
			Statement stmt = conn.createStatement();
			rss = stmt.executeQuery(consulta);
			
			while (rss.next()) {
				String correo = rss.getString("correo");
				
				if (correo.equals(mail.getText())) {
					result = false;
				//	break;
				}
			}
				rss.close();
				conn.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
