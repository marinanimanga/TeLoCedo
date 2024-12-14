package vista.laminas;

import javax.swing.*;
import java.awt.*;

public class LaminaPrincipal extends JPanel {
	
		public LaminaPrincipal () {
			
			setLayout(new BorderLayout());
			
			LaminaBuscar buscar=new LaminaBuscar();
			add(buscar, BorderLayout.CENTER);
			
			LaminaBusqueda aviso=new LaminaBusqueda();
			
			add(aviso, BorderLayout.SOUTH);
			
			LaminaResultado result=new LaminaResultado();
			JScrollPane scroll=new JScrollPane(result);
			add(scroll, BorderLayout.SOUTH);
	
			LaminaSubeAutor laminaSube=new LaminaSubeAutor();
			
			add(laminaSube, BorderLayout.NORTH);			
			
		}
		
}
