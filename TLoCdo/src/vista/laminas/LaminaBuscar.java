package vista.laminas;

import javax.swing.*;

import controlador.BuscarLibros;
import controlador.InsertarLibros;
import controlador.Sesion;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;


public class LaminaBuscar extends JPanel {

	private JLabel nomAutor;
	private JLabel apeAutor;
	private JLabel titulo;
	private JTextField buscaNomAutor;
	private JTextField buscaApeAutor;
	private JTextField buscaTitulo;
	private JButton buscar;
	private JLabel busqueda;
	private JLabel buscaCat;
	private JLabel blanco;
	private JLabel blanco2;
	private String[] categoria= {"Todas", "Comedia", "Drama", "Historia", "Miedo", "Intriga", "Policiaco", "Periodismo"};
	private LaminaResultado laminaResultado = new LaminaResultado();
	
	public LaminaBuscar () {
		
		setLayout(new GridLayout(2, 5));
		
		nomAutor=new JLabel("Nombre Autor");
		apeAutor=new JLabel("Apellido Autor");
		titulo=new JLabel("Título");
		buscaNomAutor=new JTextField (16);
		buscaApeAutor=new JTextField (16);
		buscaTitulo=new JTextField (50);
		buscar=new JButton("Buscar");
		busqueda=new JLabel("Filtra tu búsqueda");
		buscaCat=new JLabel("Categoría");
		blanco=new JLabel(" ");
		blanco2=new JLabel(" ");
		
		
		
		final JComboBox<String> listaCategorias=new JComboBox<>(categoria);
		
		nomAutor.setHorizontalAlignment(JTextField.CENTER);
		apeAutor.setHorizontalAlignment(JTextField.CENTER);
		titulo.setHorizontalAlignment(JTextField.CENTER);
		busqueda.setHorizontalAlignment(JTextField.CENTER);
		buscaCat.setHorizontalAlignment(JTextField.CENTER);
		
		buscar.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                BuscarLibros execBusqueda = new BuscarLibros(buscaTitulo,buscaNomAutor,buscaApeAutor,listaCategorias);
                try {
                	System.out.println("hacer busqueda");
                    execBusqueda.buscarLibro(buscaTitulo.getText(), buscaNomAutor.getText(), buscaApeAutor.getText(), listaCategorias);
                    if (laminaResultado != null) {
                        laminaResultado.mostrarResultados(execBusqueda.getListaLibros(), execBusqueda.getIdlibros());
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: LaminaResultado no inicializado");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    System.out.println(e1);
                }
            }
        });

        add(busqueda);
        add(titulo);
        add(buscaTitulo);
        add(buscaCat);
        add(listaCategorias);

        add(nomAutor);
        add(buscaNomAutor);
        add(apeAutor);
        add(buscaApeAutor);
        add(buscar);
        
    }
}
