package vista.laminas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controlador.*;
import vista.ventanas.*;

public class LaminaResultado extends JPanel implements MouseListener {

	private static JTable tablaResultado;
    private static DefaultTableModel modeloTabla;
    private int idLibro;
    
    public LaminaResultado() {
        setLayout(new BorderLayout());

        modeloTabla = new DefaultTableModel();
        tablaResultado = new JTable(modeloTabla);

        modeloTabla.addColumn("Título");
        modeloTabla.addColumn("Autor");
        modeloTabla.addColumn("Apellido");
        modeloTabla.addColumn("Categoría");
        modeloTabla.addColumn("Leer");
        
        JScrollPane scrollPane = new JScrollPane(tablaResultado);
        add(scrollPane, BorderLayout.CENTER);
        
       // tablaResultado.getColumnModel().getColumn(4).setCellRenderer(new RenderizarBoton());
    }

    public void mostrarResultados(ArrayList<String> listaLibros, TreeMap<Integer, Integer> idLibros) {
        
			modeloTabla.setRowCount(0);
			System.out.println("Número de resultados encontrados: " + listaLibros.size());
			
		 // Limpiar la tabla antes de agregar nuevos resultados

        for (String libro : listaLibros) {
            String[] partes = libro.split("\n");
            String[] fila = new String[5]; // Añadir un espacio adicional para el botón

            // Obtener título, autor, apellido y categoría de cada libro
            fila[0] = partes[0].split(": ")[1]; // Título
            
            String[] autorApellido = partes[1].split(": ")[1].split(" "); // Autor y apellido
            //condicion ? valorSiCierto : valorSiFalso
            fila[1] = autorApellido.length > 0 ? autorApellido[0] : ""; // Autor
            fila[2] = autorApellido.length > 1 ? autorApellido[1] : ""; // Apellido
            
            fila[3] = partes[2].split(": ")[1]; // Categoría

            // Agregar una fila a la tabla
            modeloTabla.addRow(fila);
        }

        // Agregar un botón "Leer" a cada fila
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            JButton botonLeer = new JButton("Leer");
            final int idLibro = idLibros.get(i); // Obtener el ID del libro

            tablaResultado.getColumnModel().getColumn(4).setCellRenderer(new RenderizarBoton());
           
            // Agregar el botón al modelo de la tabla en la columna 4 (índice 4)
           
            modeloTabla.setValueAt(botonLeer, i, 4);
            add(botonLeer);
        }
        
        tablaResultado.addMouseListener(this);
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		int fila=tablaResultado.rowAtPoint(e.getPoint());
		int columna=tablaResultado.columnAtPoint(e.getPoint());
		
		if (columna==4) {
			setIdLibro(fila);
			VentanaDetalle detalle=new VentanaDetalle();
			LaminaDetalle verDetalle=new LaminaDetalle(idLibro);
			
			detalle.add(verDetalle);
			detalle.setVisible(true);
			
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
}