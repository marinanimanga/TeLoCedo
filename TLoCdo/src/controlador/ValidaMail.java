package controlador;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValidaMail {
    
	private static final String EMAIL_PATTERN = 
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" 
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static boolean validate (final String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}

