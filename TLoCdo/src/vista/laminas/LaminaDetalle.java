package vista.laminas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import controlador.MostrarLibro;
import controlador.RecuperarTexto;
import vista.ventanas.VentanaLeer;

public class LaminaDetalle extends JPanel{
	
	    int id;
	
	public LaminaDetalle (int idLibro) {
		
		id=idLibro+1;
		
		setLayout(new BorderLayout());
		
		MostrarLibro verDet=new MostrarLibro(id);
	/*	try {
			verDet.mostrarDatos(idLibro);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		String datosLibro="";
		try {
			datosLibro = verDet.mostrarDatos(id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JTextArea detLibro=new JTextArea(datosLibro);
		detLibro.setEditable(false);
		
		JButton leer=new JButton("Leer");
		JButton volver=new JButton("Volver");
		
		//MostrarLibro verDetalles=new MostrarLibro(idLibro);
		
		JScrollPane scrollPa = new JScrollPane(detLibro);
        
		
		JPanel panelBotones=new JPanel(new FlowLayout());
		
		volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar la VentanaTerminos
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(LaminaDetalle.this);
                frame.dispose();
            }
        });
		
		leer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// RecuperarTexto txt=new RecuperarTexto(id);
            	
            	VentanaLeer libroCom=new VentanaLeer();
            	LaminaLeer libroLec=new LaminaLeer(id);
            	
            	libroCom.add(libroLec);
            	libroCom.setVisible(true);
            	
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(LaminaDetalle.this);
                frame.dispose();
            }
        });
		
		panelBotones.add(volver);
		panelBotones.add(leer);
		
		add(scrollPa, BorderLayout.CENTER);
		add(panelBotones, BorderLayout.SOUTH);
		
	}

}
