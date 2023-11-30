import java.util.Locale;
import java.util.ResourceBundle;

public class TraducteurFrancaisToAnglais {

    private static final Locale LANGUE_DE_TRADUCTION = Locale.ENGLISH;

    public static String traduireAnglaisEnFrancais(String cleFichierProperties, Object... args) {
        ResourceBundle messagesRessourceFrancais = ResourceBundle.getBundle("message", LANGUE_DE_TRADUCTION);
        String message = messagesRessourceFrancais.getString(cleFichierProperties);

        return String.format(message, args);
    }
}





