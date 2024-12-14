package vista.ventanas;

import java.awt.Dimension;
import java.awt.Toolkit;
import vista.laminas.*;
import javax.swing.JFrame;


public class VentanaSubir extends JFrame {

	public VentanaSubir () {
		
		Toolkit mipantalla=Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla=mipantalla.getScreenSize();
		
		int alturaPantalla=tamanoPantalla.height;
		int anchuraPantalla=tamanoPantalla.width;
		
		setBounds (anchuraPantalla/3, alturaPantalla/4, anchuraPantalla/4, alturaPantalla/2);
		setTitle ("Subir obras");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		LaminaSubir vistaSubir=new LaminaSubir();
		add(vistaSubir);
	
		
		
	}
	
}
