package vista.ventanas;
import java.awt.BorderLayout;
import java.awt.BorderLayout.*;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

import vista.laminas.LaminaBuscar;
import vista.laminas.LaminaPrincipal;

public class VentanaPrincipal extends JFrame {

	public VentanaPrincipal () {
		
		Toolkit mipantalla=Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla=mipantalla.getScreenSize();
		
		int alturaPantalla=tamanoPantalla.height;
		int anchuraPantalla=tamanoPantalla.width;
		
		setTitle ("TLoCedo - Comparte tus libros");
		setBounds (anchuraPantalla/4, 0, anchuraPantalla/2, alturaPantalla);
		
		LaminaPrincipal busca=new LaminaPrincipal();
		add(busca, BorderLayout.NORTH);
		
	}
	
}
