package modelo;

import java.sql.*;
import controlador.*;


public class CargaBusqueda {

	Conexion miConexion;
	ResultSet rs;
	
	public CargaBusqueda () {
		
		miConexion=new Conexion();
		
	}
	
	public String ejecutaConsultas() {
		
		InsertarLibros inLib=null;
		
		Connection accesoBBDD=miConexion.conectar();
		
		try {
			
			Statement resBusqueda=accesoBBDD.createStatement();
			
			rs=resBusqueda.executeQuery("SELECT * FROM libros");
			
			
		} catch (Exception e) {
			
		}
		
		return "";
		
	}
	
	
}
