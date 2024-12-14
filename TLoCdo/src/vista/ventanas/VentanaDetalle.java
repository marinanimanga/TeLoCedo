package vista.ventanas;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class VentanaDetalle extends JFrame {
	
	public VentanaDetalle () {
		
		Toolkit mipantalla=Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla=mipantalla.getScreenSize();
	
		int alturaPantalla=tamanoPantalla.height;
		int anchuraPantalla=tamanoPantalla.width;
	
		setTitle ("Detalle del libro");
		setBounds ((anchuraPantalla/4)+150, alturaPantalla/4, anchuraPantalla/3, alturaPantalla/4);
		
	}	
}
