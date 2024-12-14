package controlador;

import controlador.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.DriverManager;
import java.sql.ResultSet;
import vista.laminas.*;

public class InsertarLibros {
	
	private JTextField titulo;
	private JTextField nick = Sesion.getNickUsuario();
	private JComboBox<String> categoria;
	private JTextArea descripcion;
	private JTextArea nota_autor;
	private byte[] pdfBytes;
	
	
	

	public InsertarLibros(JTextField titulo, JTextField nick, JComboBox<String> 
	categoria, JTextArea descripcion, JTextArea nota_autor, byte[] pdfBytes){
		
		//Relacion con Variables del JTextField
		this.titulo=titulo;
		this.nick=nick;
		this.categoria=categoria;
		this.descripcion=descripcion;
		this.nota_autor=nota_autor;
		this.pdfBytes = pdfBytes;
		
	}
		
	public void subirLibros () {
		
try {
		//Abrir la conexion
			Conexion miConexion = new Conexion();
			Connection conn=miConexion.conectar();
			
		//Consulta SQL para obtener datos
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO libros (titulo, "
					+ "descripcion, categoria, notas_autor, id_usuario, archivo) VALUES (?,?,?,?,?,?)");
			
		//Pasarle los parametros del JTextField
			ps.setString(1, titulo.getText());
		//	ps.setString(2, portada.getText());
			ps.setString(2, descripcion.getText());
			ps.setString(3, categoria.getSelectedItem().toString());
			ps.setString(4, nota_autor.getText());
			ps.setBytes(6, pdfBytes);
			
			
			PreparedStatement idUser = conn.prepareStatement("SELECT id FROM usuarios WHERE nick = ?");
			idUser.setString(1, nick.getText());
			ResultSet ides = idUser.executeQuery();
			
			while(ides.next()) {
				ps.setInt(5, ides.getInt(1));
			}
			
		//Ejecutar sentencias
			int miResultado = ps.executeUpdate();
			
		//4. Recorrer el resultado
			if (miResultado>0) {
				System.out.println("Los datos se han introducido correctamente.");
			}
			
			ps.close();
			conn.close();
			
	}catch(Exception e) {
		
		e.printStackTrace();
		System.out.println(e);
		
		}

	}

}

