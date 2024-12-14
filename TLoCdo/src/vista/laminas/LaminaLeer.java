package vista.laminas;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import controlador.RecuperarTexto;

public class LaminaLeer extends JPanel {
	

	
	private int id;
	
	public LaminaLeer (int idLibro) {
		
		id=idLibro;
	
		
		
		Toolkit mipantalla=Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla=mipantalla.getScreenSize();
		Dimension tamScroll;
		
		int alturaPantalla=tamanoPantalla.height;
		int anchuraPantalla=tamanoPantalla.width;
		
		tamScroll=new Dimension ((anchuraPantalla/2)-200, alturaPantalla);
		
		//JTextArea pantallaLeer;
		
		
		try {
			//Obtener texto del libro
			JTextArea pantallaLeer = new JTextArea(RecuperarTexto.blobToText(RecuperarTexto.blobToByte(id)));
			JScrollPane lecturaFinal=new JScrollPane(pantallaLeer);
			lecturaFinal.setPreferredSize(tamScroll);
			pantallaLeer.setLineWrap(true);
			pantallaLeer.setEditable(false);
			
			add(lecturaFinal);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
}
