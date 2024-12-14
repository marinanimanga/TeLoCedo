package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import vista.laminas.*;
import javax.swing.*;
import controlador.*;

public class InsertarLibros {
	
	private String titulo;
	private String nick;
	private String categoria;
	private String descripcion;
	private String notas_autor;
	private String portada;
	
	public InsertarLibros(){
		
		//Relacion con Variables del JTextField
		titulo="";
		nick="";
		categoria="";
		descripcion="";
		notas_autor="";
		portada="";
		
		
		try {
		//Abrir la conexion
			Conexion conectar=new Conexion();
			
			
		//Consulta SQL para obtener datos
			
			PreparedStatement ps = conectar.conectar().prepareStatement("INSERT INTO usuarios (titulo, portada, descripcion, categoria, notas_autor) VALUES (?,?,?,?,?)");
			
		//Pasarle los parametros del JTextField
			
			ps.setString(1, titulo);
			ps.setString(2, portada);
			ps.setString(3, descripcion);
			ps.setString(4, categoria);
			ps.setString(5, notas_autor);
			
		//Ejecutar sentencias
			ResultSet miResultado = ps.executeQuery();
			
		//4. Recorrer el resultado
			while(miResultado.next()) {
				System.out.println("Los datos se han introducido correctamente");
			}
			
			ps.close();
			((Connection) conectar).close();
			
		}catch(Exception e) {
		
		System.out.println("No se ha podido conectar a la BBDD");
		
		e.printStackTrace();
		
		}

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNotas_autor() {
		return notas_autor;
	}

	public void setNotas_autor(String notas_autor) {
		this.notas_autor = notas_autor;
	}

	public String getPortada() {
		return portada;
	}

	public void setPortada(String portada) {
		this.portada = portada;
	}

}
