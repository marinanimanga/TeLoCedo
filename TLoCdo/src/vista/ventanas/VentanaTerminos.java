package vista.ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javax.swing.JFrame;

import vista.laminas.*;

public class VentanaTerminos extends JFrame {
	
	public VentanaTerminos () {
		
		Toolkit mipantalla=Toolkit.getDefaultToolkit();
		Dimension tamanoPantalla=mipantalla.getScreenSize();
		
		int alturaPantalla=tamanoPantalla.height;
		int anchuraPantalla=tamanoPantalla.width;
		
		setBounds (anchuraPantalla/4, alturaPantalla/6, (anchuraPantalla/2)+40, alturaPantalla-200);
		setTitle ("Términos y Condiciones");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}

}


