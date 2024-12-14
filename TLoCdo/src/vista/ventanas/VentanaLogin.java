package vista.ventanas;

import javax.swing.*;
import java.awt.*;
import vista.laminas.*;

public class VentanaLogin extends JFrame{
	

	public VentanaLogin() {
		
		
		Toolkit mipantalla=Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla=mipantalla.getScreenSize();
		
		int alturaPantalla=tamanoPantalla.height;
		int anchuraPantalla=tamanoPantalla.width;
		
		setBounds (anchuraPantalla/3, alturaPantalla/4, anchuraPantalla/4, alturaPantalla/4);
		setTitle ("Inicio de sesión");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		LaminaLogin vistaLogin=new LaminaLogin();
		add(vistaLogin);
		
	}
	
}