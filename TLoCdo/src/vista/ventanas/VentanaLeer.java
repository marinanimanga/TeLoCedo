package vista.ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import vista.laminas.LaminaPrincipal;

public class VentanaLeer extends JFrame{
	
	public VentanaLeer () {
		
			Toolkit mipantalla=Toolkit.getDefaultToolkit();
			Dimension tamanoPantalla=mipantalla.getScreenSize();
		
			int alturaPantalla=tamanoPantalla.height;
			int anchuraPantalla=tamanoPantalla.width;
		
			setTitle ("Tu lectura de hoy");
			setBounds (anchuraPantalla/4, 0, anchuraPantalla/2, alturaPantalla);
			
	}

}
