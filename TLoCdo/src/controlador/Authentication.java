package controlador;



public class Authentication {
    // Función para autenticar la contraseña
    public static boolean authenticate(char[] password, String hashedPassword, byte[] salt) {
        String hashedAttempt = PasswordHashing.hashPassword(password, salt);
        return hashedPassword.equals(hashedAttempt);
    }
}
