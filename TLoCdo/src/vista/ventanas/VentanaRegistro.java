package vista.ventanas;

import javax.swing.*;

import vista.laminas.LaminaRegistro;

import java.awt.*;
import java.awt.event.*;

public class VentanaRegistro extends JFrame{
	
	
		public VentanaRegistro() {
			
			
			Toolkit mipantalla=Toolkit.getDefaultToolkit();
			Dimension tamanoPantalla=mipantalla.getScreenSize();
			
			int alturaPantalla=tamanoPantalla.height;
			int anchuraPantalla=tamanoPantalla.width;
			
			setBounds (anchuraPantalla/3, alturaPantalla/4, anchuraPantalla/4, alturaPantalla/2);
			setTitle ("Registro");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			LaminaRegistro vistaRegistro=new LaminaRegistro();
			add(vistaRegistro);
		
			
		}
		
	}
