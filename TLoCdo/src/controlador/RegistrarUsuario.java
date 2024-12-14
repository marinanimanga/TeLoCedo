package controlador;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import vista.laminas.*;

import java.sql.*;

public class RegistrarUsuario {

	private JTextField nick;
	private JTextField nom_usuario;
	private JTextField ape1;
	private JTextField ape2;
	private JTextField correo;
	private JPasswordField password;
	private JRadioButton autor;

	public RegistrarUsuario(JTextField nick, JTextField nom_usuario, JTextField ape1, JTextField ape2,
			JTextField correo, JPasswordField password, JRadioButton autor) {

		this.nick = nick;
		this.nom_usuario = nom_usuario;
		this.ape1 = ape1;
		this.ape2 = ape2;
		this.correo = correo;
		this.password = password;
		this.autor = autor;

	}

	public void registrarUsuario() {
		
		try(Connection conn = new Conexion().conectar()) {
			conn.setAutoCommit(false);

			// Crear una salt para este usuario y guardarla en BBDD
			byte[] salt = PasswordHashing.generateSalt();

			// Consulta SQL para obtener datos

			String consulta = "INSERT INTO usuarios (nom_usuario, apellido1, apellido2, nick, password, correo, salt, autor_lector) VALUES (?,?,?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(consulta);

			// Pasarle los parámetros del JTextField
			ps.setString(1, nom_usuario.getText());
			ps.setString(2, ape1.getText());
			ps.setString(3, ape2.getText());
			ps.setString(4, nick.getText());
			// Codificar la contraseña
			String codificada = PasswordHashing.hashPassword(password.getPassword(), salt);
			System.out.println("La contraseña ha sido codificada correctamente.");
			// Guardar la contraseña codificada en la BBDD
			ps.setString(5, codificada);
			ps.setString(6, correo.getText());
			if (autor.isSelected()) {
				ps.setInt(8, 0);
			} else {
				ps.setInt(8, 1);

			}

			ps.setBytes(7, salt);

			// Ejecutar la consulta
			int filasInsertadas = ps.executeUpdate();

			if (filasInsertadas > 0) {
				System.out.println("Los datos se han introducido correctamente");
				conn.commit();
			} else {
				System.out.println("No se ha podido insertar el usuario");
			}
			
			ps.close();
			

		} catch (SQLIntegrityConstraintViolationException e) {
			String errorMessage = e.getMessage();
			if (errorMessage.contains("nick")) {
				JOptionPane.showMessageDialog(null,
						"El nick está duplicado en nuestra base de datos. Por favor, introduce otro.");
			} else if (errorMessage.contains("correo")) {
				JOptionPane.showMessageDialog(null,
						"El correo está duplicado en nuestra base de datos. Por favor, introduce otro.");
			} else {
				JOptionPane.showMessageDialog(null, "Sigue estando duplicado. Por favor, inténtalo de nuevo");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
