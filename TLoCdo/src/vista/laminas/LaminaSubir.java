package vista.laminas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import controlador.*;
import vista.ventanas.*;

public class LaminaSubir extends JPanel{
	
		JLabel tit=new JLabel ("Título del libro:");
		JLabel cat=new JLabel ("Categoría:");
		JLabel desc=new JLabel("Descripción:");
		JLabel notaut=new JLabel ("Nota del Autor/ra:");
		JLabel blanco=new JLabel (" ");
		JLabel elige=new JLabel ("Selecciona archivo: ");
		
		JTextField titulo=new JTextField (50);
		JTextArea descripcion= new JTextArea(10, 20);
		JTextArea nota_autor=new JTextArea(10, 20);
		JButton subir=new JButton("Subir");
		JButton seleccionar=new JButton("Seleccionar");
		JLabel tagArchivo=new JLabel ("Archivo seleccionado: ");
		JComboBox<String> listaCat;
		
		//Iniciar una variable para guardar el archivo antes de convertirlo
		File archivoSubir;
		
		public LaminaSubir () {
			
			String[] categoria= {"Comedia", "Drama", "Historia", "Miedo", "Intriga", "Periodismo"};
			
			listaCat=new JComboBox<>(categoria);
			
			descripcion.setLineWrap(true);
			nota_autor.setLineWrap(true);
			
			JScrollPane barras=new JScrollPane(descripcion);
			JScrollPane barras2=new JScrollPane(nota_autor);
			
			
			tit.setHorizontalAlignment(JTextField.CENTER);
			cat.setHorizontalAlignment(JTextField.CENTER);
			desc.setHorizontalAlignment(JTextField.CENTER);
			notaut.setHorizontalAlignment(JTextField.CENTER);
			elige.setHorizontalAlignment(JTextField.CENTER);
			tagArchivo.setHorizontalAlignment(JTextField.CENTER);
			blanco.setHorizontalAlignment(JTextField.CENTER);
			
			setLayout (new GridLayout (13, 1));
			add(tit);
			add(titulo);
			add(cat);
			add(listaCat);
			add(desc);
			add(barras);
			add(notaut);
			add(barras2);
			add(elige);
			add(seleccionar);
			add(tagArchivo);
			add(blanco);
			add(subir);
			
			seleccionar.addActionListener(new ActionListener() {
				
				public void actionPerformed (ActionEvent e) {
					
					JFileChooser eligeArchivo=new JFileChooser();
					int result=eligeArchivo.showOpenDialog(null);
					if (result==JFileChooser.APPROVE_OPTION) {
						System.out.println("Se ha guardado el archivo en una variable");
						archivoSubir=eligeArchivo.getSelectedFile();
						blanco.setText(archivoSubir.getName());
						System.out.println("Se obtiene el nombre para mostrarlo");
					}
					
				}
				
			});
			
			subir.addActionListener(new ActionListener() {
				
				public void actionPerformed (ActionEvent e) {
					System.out.println("Comprobación de tipo de archivo");
					if(archivoSubir != null) {

					try {
						System.out.println("Llamada al método para convertir el archivo");
		                byte[] pdfBytes = PDFaTXT.convertPDFToBytes(archivoSubir);
		                InsertarLibros sube=new InsertarLibros(titulo, Sesion.getNickUsuario(), listaCat, descripcion, nota_autor, pdfBytes);
		                System.out.println(pdfBytes);
		                System.out.println("Se procede a subirlo");
		                sube.subirLibros();
		                
		                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(LaminaSubir.this);
				        frame.dispose();
				        
				        
		            } catch (IOException ex) {
		                ex.printStackTrace();
		                System.out.println(ex);
		            }
					
					}
				}
				
			});
			
		}
	
	
}
