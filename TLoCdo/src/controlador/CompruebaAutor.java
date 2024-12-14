package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompruebaAutor {
	
	private String nick = Sesion.getNickUsuario().getText();
	private Boolean autorSi;
	private int num;
	
	public CompruebaAutor () {
		
	}
	
	public boolean esAutor (String nick) {
		
		try {
	
			Conexion c = new Conexion();
			Connection conn = c.conectar();
			PreparedStatement ps;
	
	
		ps = conn.prepareStatement("SELECT autor_lector FROM usuarios WHERE nick = ?");
				
		ps.setString(1, nick);
		ResultSet autor=ps.executeQuery();
		
				
		while (autor.next()) {
			
			num=autor.getInt("autor_lector");
			
			if (num==0) {
				
				autorSi=true;
				
			} else {
				
				autorSi=false;
				
			}
		
		}
		
		ps.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
	
	return autorSi;

}

	public Boolean getAutorSi() {
		return autorSi;
	}

	public void setAutorSi(Boolean autorSi) {
		this.autorSi = autorSi;
	}
}
