package controlador;

import java.sql.*;

public class Conexion {
	
	private Connection conectado;
	
	public Connection getConectado() {
		return conectado;
	}

	public void setConectado(Connection conectado) {
		this.conectado = conectado;
	}

	public Conexion () {}
	
	public Connection conectar () {
		
		try {
			
			setConectado(DriverManager.getConnection("jdbc:mysql://mysql.ovejaferoz.com:3306/willy", "willyberto", "C0s4sC0mun1st4s"));
			
		} catch (Exception e) {
			System.out.println("No se ha podido conectar a la BBDD.");
			e.getStackTrace();
			
		}
		
		return conectado;
		
	}	

}
