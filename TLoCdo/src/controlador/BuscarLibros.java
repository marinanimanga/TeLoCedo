package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import vista.laminas.*;

public class BuscarLibros {
	
	private Connection conexion;
	private JTextField titulo;
	private JTextField nomUsuario;
	private JTextField apellido1;
	//private JTextField apellido2;
	private JComboBox<String> categoria;
	private JTextArea descripcion;
	private JTextArea nota_autor;
	private byte[] pdfBytes;
	private JTextArea resultados;
	private TreeMap<Integer,Integer> idlibros;
	private ArrayList<String> listaLibros;
	private int avance;
	
	public BuscarLibros () {};
	
	public BuscarLibros(JTextField titulo, JTextField nom_usuario, JTextField apellido1, JComboBox<String> categoria){
		
		this.titulo = titulo;
		this.nomUsuario = nom_usuario;
		this.apellido1 = apellido1; 
		//this.apellido2 = apellido2;
		this.categoria = categoria;
		
	}
		
	public String buscarLibro(String titulo, String nom_usuario, String apellido1, JComboBox<String> categoria) throws SQLException {
		
		String resultado ="";
		listaLibros = new ArrayList<>();
        String cat = this.categoria.getSelectedItem().toString();
        idlibros = new TreeMap<>();
		Conexion c = new Conexion();
		Connection conn = c.conectar();
		
		StringBuilder sqlBuilder = new StringBuilder("SELECT U.nom_usuario, U.apellido1, L.id, L.titulo, L.categoria"
		        + " FROM usuarios AS U"
		        + " INNER JOIN libros AS L ON L.id_usuario = U.id"
		        + " WHERE 1=1");
		
		if (this.nomUsuario != null && !this.nomUsuario.getText().isEmpty()) {
		    sqlBuilder.append(" AND U.nom_usuario LIKE ?");
		}
		if (this.apellido1 != null && !this.apellido1.getText().isEmpty()) {
		    sqlBuilder.append(" AND U.apellido1 LIKE ?");
		}
		if (this.titulo != null && !this.titulo.getText().isEmpty()) {
		    sqlBuilder.append(" AND L.titulo LIKE ?");
		}
		if (this.categoria != null && !this.categoria.getSelectedItem().toString().isEmpty()) {
		    if (this.categoria.getSelectedItem().toString().equals("Todas")) {
		    	// No agregar ninguna restricción de categoría en este caso
		    } else {
		        sqlBuilder.append(" AND L.categoria = ?"); 
		    }
		}
		
		PreparedStatement ps = conn.prepareStatement(sqlBuilder.toString());

		int parameterIndex = 1;
		
		if (this.nomUsuario != null && !this.nomUsuario.getText().isEmpty()) {
		    ps.setString(parameterIndex++, "%" + this.nomUsuario.getText() + "%");
		}
		if (this.apellido1 != null && !this.apellido1.getText().isEmpty()) {
		    ps.setString(parameterIndex++, "%" + this.apellido1.getText() + "%");
		}
		if (this.titulo != null && !this.titulo.getText().isEmpty()) {
		    ps.setString(parameterIndex++, "%" + this.titulo.getText() + "%");
		}
		if (this.categoria != null && !this.categoria.getSelectedItem().toString().isEmpty() && !this.categoria.getSelectedItem().toString().equals("Todas")) {
		    ps.setString(parameterIndex++, cat);
		}
		
		
		ResultSet rs = ps.executeQuery();
		
		int avance = 0;
		
		while(rs.next()) {
			
			resultado = "Título: "+ rs.getString("titulo") + "\nAutor y Apellido: " + rs.getString("nom_usuario") + " " + rs.getString("apellido1") + "\nCategoría: " + rs.getString("categoria") + "\n";
			listaLibros.add(resultado);
			int idlibro = rs.getInt("id");
			idlibros.put(avance,idlibro);
			System.out.println(resultado);
			avance++;
		}
		return resultado;
}

	public TreeMap<Integer, Integer> getIdlibros() {
		return idlibros;
	}

	public void setIdlibros(TreeMap<Integer, Integer> idlibros) {
		this.idlibros = idlibros;
	}

	public ArrayList<String> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(ArrayList<String> listaLibros) {
		this.listaLibros = listaLibros;
	}

	public int getAvance() {
		return avance;
	}

	public void setAvance(int avance) {
		this.avance = avance;
	}
}
