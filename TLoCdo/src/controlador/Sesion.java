package controlador;

import javax.swing.JTextField;

public class Sesion {
	private static JTextField nickUsuario;

    public static JTextField getNickUsuario() {
        return nickUsuario;
    }

    public static void setNickUsuario(JTextField nick) {
        Sesion.nickUsuario = nick;
    }
}
