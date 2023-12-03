import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Cette classe est une représentation d'un objet Intervention Policiere qui contient des informations,
 * telles que la date, l'heure, le parc, l'arrondissement et la description.
 *
 * @Author: Eglantine Clervil
 * @Courriel: clervil.eglantine_anne@courrier.uqam.ca
 * @Code-permanent: CLEE89530109
 * @Groupe: 30
 */

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





