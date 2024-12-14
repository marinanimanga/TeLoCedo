package vista.laminas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controlador.AutenticarUsuario;

import controlador.ComprobarNick;
import controlador.CompruebaAutor;
import controlador.Sesion;
import vista.ventanas.*;

public class LaminaLogin extends JPanel{
	
	private JTextField campoNombre;
	private JPasswordField campoPass;
		
		public LaminaLogin () {
			
			//Creación de los items
			
			JLabel introNombre=new JLabel("Inserta tu Nick:");
			JLabel introPass=new JLabel("Introduce tu contraseña:");
			JLabel noUser=new JLabel("Si aún no formas parte de nuestra comunidad, regístrate.");
			JLabel blanco=new JLabel("");
			
			campoNombre=new JTextField(16);
			campoPass=new JPasswordField(16);
			
			
			final JButton botonAcceso=new JButton ("Acceder");
			JButton botonRegistro=new JButton ("Registrarme");
			
			introNombre.setHorizontalAlignment(JTextField.CENTER);
			introPass.setHorizontalAlignment(JTextField.CENTER);
			noUser.setHorizontalAlignment(JTextField.CENTER);
			
		
			
			//Ubbicación de los items en sus espacios
			
			setLayout (new GridLayout (8, 1));
			add(introNombre);
			add(campoNombre);
			add(introPass);
			add(campoPass);
			add(botonAcceso);
			add(blanco);
			add(noUser);
			add(botonRegistro);
			
		
		
		botonAcceso.addActionListener(new ActionListener () {
			
			public void actionPerformed (ActionEvent e) {
				
				ComprobarNick comproNombre=new ComprobarNick(campoNombre);
				if (comproNombre.compruebaNick()==3) {
					
					JOptionPane.showMessageDialog(botonAcceso, "El usuario no aparece en nuestra Base de Datos. Prueba de nuevo o regístrate.");
					
				} 
				
				AutenticarUsuario validaUser=new AutenticarUsuario(campoNombre, campoPass);
			
				validaUser.autenticarUsuario();
				
								
				if (validaUser.autenticarUsuario()) {
				VentanaPrincipal miApp=new VentanaPrincipal();
				miApp.setVisible(true);
				miApp.setResizable(false);
				miApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				// Cerrar la VentanaTerminos
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(LaminaLogin.this);
		        frame.dispose();
	
				// CerrarVentana cerrar=new CerrarVentana(t); 
				
				}
			}
		});
		
		botonRegistro.addActionListener(new ActionListener () {
			
			public void actionPerformed (ActionEvent e) {
				
				VentanaRegistro ventanaReg=new VentanaRegistro();
				ventanaReg.setVisible(true);
				
			}
			
		});
		
		}
}
