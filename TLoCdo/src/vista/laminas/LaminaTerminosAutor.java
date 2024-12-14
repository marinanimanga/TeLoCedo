package vista.laminas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controlador.LectorAAutor;
import controlador.Sesion;



public class LaminaTerminosAutor extends JPanel {

	private JButton quieroSer;
	private String textoTerminos;
	private JTextArea terminos;
	private JCheckBox aceptando;
	
	public LaminaTerminosAutor () {
		
		Toolkit mipantalla=Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla=mipantalla.getScreenSize();
		
		int alturaPantalla=tamanoPantalla.height;
		int anchuraPantalla=tamanoPantalla.width;
		
		quieroSer=new JButton ("Ser Autor");
		
		 quieroSer.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Cerrar la VentanaTerminos
	                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(LaminaTerminosAutor.this);
	                frame.dispose();
	            }
	        });
		
		textoTerminos="Al acceder y utilizar la Plataforma, aceptas cumplir con estos Términos.\n"
				+ "\n"
				+ "Si no estás de acuerdo con alguna parte de estos Términos, te recomendamos que no utilices la Plataforma.\n"
				+ "\n"
				+ "2. Usuarios\n"
				+ "La Plataforma está diseñada para dos tipos de usuarios:\n"
				+ "	2.1. Lectores\n"
				+ "		Los lectores son aquellos usuarios que acceden a la Plataforma para disfrutar de las obras literarias\ndisponibles. Al utilizar la Plataforma, los lectores aceptan lo siguiente:\n"
				+ "\n"
				+ "		Utilizar las obras literarias exclusivamente dentro de la Plataforma y no difundirlas a terceros\nsin el consentimiento expreso del autor.\n"
				+ "		Respetar los derechos de autor y de la propiedad intelectual de las obras que lean.\n"
				+ "		No realizar actividades ilegales o que infrinjan los derechos de otros usuarios o autores.\n"
				+ "	\n"
				+ "	\n"
				+ "	2.2. Autores\n"
				+ "		Los autores son aquellos usuarios que suben sus propias obras literarias a la Plataforma.\nAl utilizar la Plataforma, los autores aceptan lo siguiente:\n"
				+ "		\n"
				+ "		Ser los legítimos dueños de los derechos de autor y de difusión de las obras que suban.\n"
				+ "		Permitir que los lectores accedan y lean sus obras dentro de la Plataforma.\n"
				+ "		No subir contenido ilegal o que infrinja los derechos de terceros.\n"
				+ "	\n"
				+ "\n"
				+ "3. Tratamiento de Datos Personales\n"
				+ "	La Plataforma recopila y procesa datos personales de los usuarios.\n"
				+ "	Al utilizar la Plataforma, aceptas nuestro Aviso de Privacidad, que describe cómo tratamos tus datos personales.\nLos datos recopilados se utilizarán exclusivamente dentro de la Plataforma y no se compartirán con terceros sin tu consentimiento.\n"
				+ "\n"
				+ "4. Modificaciones y Actualizaciones\n"
				+ "	Nos reservamos el derecho de modificar o actualizar estos Términos en cualquier momento.\nTe recomendamos revisar regularmente esta sección para estar al tanto de cualquier cambio.\n"
				+ "\n"
				+ "5. Contacto\n"
				+ "	Si tienes alguna pregunta o inquietud sobre estos Términos, puedes ponerte en contacto con nosotros\na través de los datos proporcionados en la Plataforma.";
		
		terminos=new JTextArea(textoTerminos);
		
		terminos.setSize(anchuraPantalla/2, alturaPantalla/2);
					
		terminos.setEditable(false);
		terminos.setLineWrap(true);
		
		aceptando=new JCheckBox ("Acepto ser autor.");
		
		quieroSer.setEnabled(false);
		
		aceptando.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (aceptando.isSelected()) {
					quieroSer.setEnabled(true);	
				} else {
					quieroSer.setEnabled(false);
				}
				
			}
			
		});
		
		quieroSer.addActionListener(new ActionListener () {
			
			public void actionPerformed (ActionEvent e) {
				
				LectorAAutor cambio=new LectorAAutor(Sesion.getNickUsuario().getText());
				cambio.cambiarAutor(Sesion.getNickUsuario().getText());
				
				JOptionPane.showMessageDialog(null, "¡Genial! Ahora ya puedes subir tus textos.");
				
			}
		});
		
		add(terminos);
		add(aceptando);
		add (quieroSer);
		
		}	
}
