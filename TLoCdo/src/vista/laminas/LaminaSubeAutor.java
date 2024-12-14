package vista.laminas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.CompruebaAutor;
import controlador.Conexion;
import controlador.Sesion;
import vista.ventanas.VentanaSubir;
import vista.ventanas.VentanaTerminos;

public class LaminaSubeAutor extends JPanel {

		private JLabel textoSubir;
		private JButton vamos;
		private JLabel busqueda;
		private JLabel buscaCat;
		private JLabel b1;
		private JLabel b2;
		private JLabel b3;
		private JLabel b4;
		private JLabel b5;
		private JLabel b6;
		private JLabel b7;
		private JLabel b8;
		private JLabel noSoyAutor;
		private JButton serAutor;
		private CompruebaAutor lectorSi;
		
		
	public LaminaSubeAutor () {
		
		setLayout(new GridLayout(6,2));
		
		b1=new JLabel(" ");
		b2=new JLabel(" ");
		b3=new JLabel(" ");
		b4=new JLabel(" ");
		b5=new JLabel(" ");
		b6=new JLabel(" ");
		b7=new JLabel(" ");
		b8=new JLabel(" ");
		textoSubir=new JLabel("¿Ya eres autor? Sube tu libro pulsando el botón:");
		vamos=new JButton("Subir Libro");
		noSoyAutor=new JLabel ("¿Quieres convertirte en Autor? Pulsa el botón:");
		serAutor=new JButton ("Quiero ser Autor");
		
		textoSubir.setHorizontalAlignment(JTextField.CENTER);
		noSoyAutor.setHorizontalAlignment(JTextField.CENTER);
		
		lectorSi=new CompruebaAutor();
		
		actualizaBoton();
		
		System.out.println(lectorSi.esAutor(Sesion.getNickUsuario().getText()));
		
		vamos.addActionListener(new ActionListener() {
			
			public void actionPerformed (ActionEvent e) {
							
				VentanaSubir subida=new VentanaSubir();
				
				subida.setVisible(true);
				
			}		
		});
		
		serAutor.addActionListener(new ActionListener() {
			
			public void actionPerformed (ActionEvent e) {
				
				VentanaTerminos sera=new VentanaTerminos();
				LaminaTerminosAutor otra=new LaminaTerminosAutor();
				sera.add(otra);
				
					sera.addWindowListener(new WindowAdapter () {
					
					public void windowClosed (WindowEvent e) {
						
						actualizaBoton();
						
					}
					
				});
				
				sera.setVisible(true);
				
			}
			
		});
					
		add(b1);
		add(b2);
		add(textoSubir);
		add(vamos);
		add(b3);
		add(b4);
		add(noSoyAutor);
		add(serAutor);
		add(b5);
		add(b6);
		add(b7);
		add(b8);

}
	
	private void actualizaBoton() {
		
		if (lectorSi.esAutor(Sesion.getNickUsuario().getText())) {
			vamos.setEnabled(true);	
				
		} else {
			vamos.setEnabled(false);
		}
		
	}
	
}
