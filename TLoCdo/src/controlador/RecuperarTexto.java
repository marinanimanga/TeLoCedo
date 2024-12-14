package controlador;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecuperarTexto {

	private int archivo;
	private byte[] bdata;

	public RecuperarTexto(int archivo) {
		this.archivo = archivo;
	}

	public static byte[] blobToByte(int archivo) throws SQLException {
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    String texto = null; // 
	    byte[] bdata=null;
	    
	    try {
	        Conexion c = new Conexion();
	        Connection conn = c.conectar();
	        
	        String sql = "SELECT archivo FROM libros WHERE id = ?";
	        preparedStatement = conn.prepareStatement(sql);
	        preparedStatement.setInt(1, archivo);
	        
	        resultSet = preparedStatement.executeQuery();
	        
	        // Procesa el resultado
	        if (resultSet.next()) {
	        	
	            Blob blob = resultSet.getBlob("archivo");
	            if (blob != null) {
	                bdata = blob.getBytes(1, (int) blob.length());
	            } else {
	            	throw new SQLException("El campo 'archivo' es nulo para el ID especificado");
	            }
	        }
	    } catch (SQLException e) {
	    	System.out.println("Errores: ");
	        e.printStackTrace();
	    } finally {
	        // Cerrar los recursos JDBC
	        if (resultSet != null) {
	            resultSet.close();
	        }
	        if (preparedStatement != null) {
	            preparedStatement.close();
	        }
	    }
	    
	    return bdata; //Retorna un byte[] 
	}
	
	public static String blobToText(byte[] bdata) throws IOException {
		if (bdata == null) {
	        return "blobData está vacio";
	    }
		InputStream inputStream = new ByteArrayInputStream(bdata);

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

		StringBuilder textoBuilder = new StringBuilder();
		String linea;
		while ((linea = reader.readLine()) != null) {
			textoBuilder.append(linea).append("\n");
		}

		reader.close();

		return textoBuilder.toString(); //retorna un String tras convertir el byte[]
		
		
	}

}