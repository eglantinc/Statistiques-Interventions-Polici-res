import java.util.Locale;
import java.util.ResourceBundle;

public class Traducteur {
    private Locale langueEnCours;
    public static final Locale ANGLAIS = Locale.ENGLISH;
    public static final Locale FRANCAIS = Locale.FRENCH;


    public Locale getLangueEnCours() {
        return langueEnCours;
    }

    public void setLangueEnCours(Locale langueEnCours) {
        this.langueEnCours = langueEnCours;
    }


    public String traduire(String cle, Object... args) {
        ResourceBundle messagesRessource = ResourceBundle.getBundle("message", langueEnCours);
        String message = messagesRessource.getString(cle);

        return String.format(message, args);
    }



}





