package controlador;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderizarBoton extends DefaultTableCellRenderer {

    public RenderizarBoton() {
    	setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Si el valor es un JButton, lo retorna
        if (value instanceof Component) {
            return (Component) value;
        }
        return this;
    }
}