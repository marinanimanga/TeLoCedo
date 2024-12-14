package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JPasswordField;
import javax.swing.JTextField;




public class AutenticarUsuario {
	private JTextField campoNombre;
    private JPasswordField campoPass;

    public AutenticarUsuario(JTextField nick, JPasswordField password) {
    	this.campoNombre = nick;
        this.campoPass = password;
    }
    
    public boolean autenticarUsuario() {
    	boolean autenticado=false;
	try
	{
		// Abrir la conexion
		Conexion miConexion = new Conexion();
		Connection conn=miConexion.conectar();

		// Consulta SQL para obtener datos
		
		String consulta = "SELECT password, salt FROM usuarios WHERE nick =?";
		PreparedStatement ps = conn.prepareStatement(consulta);
		
		
		ps.setString(1, campoNombre.getText());
		
		// Ejecutar sentencias
		ResultSet rs = ps.executeQuery();
		
		//Recorrer el resultado
		if (rs.next()) {
            String passwordHash = rs.getString("password");
            byte[] salt = rs.getBytes("salt");

            // Verificar la contraseña
            autenticado = Authentication.authenticate(campoPass.getPassword(), passwordHash, salt);
            
            
    		System.out.println("Autenticado con éxito.");
        }
		
		Sesion.setNickUsuario(campoNombre);
		
		rs.close();
		ps.close();
		conn.close();

	}catch(Exception e){
		System.out.println("No se ha podido conectar a la BBDD");
		e.printStackTrace();
	}
	return autenticado;
}
}
