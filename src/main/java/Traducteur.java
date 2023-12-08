import java.util.Locale;
import java.util.ResourceBundle;

/**
 * La classe Traducteur fournit des fonctionnalités de
 * traduction de messages en fonction de la langue choisie.
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

    public void setLangueEnCours(Locale langueEnCours) {
        this.langueEnCours = langueEnCours;
    }

    /**
     * La méthode traduire de la classe Traducteur permet de traduire un message en utilisant une clé spécifiée
     * et les arguments fournis.
     *
     * @param cle  La clé du message à traduire.
     * @param args Les arguments à substituer dans le message.
     * @return Le message traduit.
     */
    public String traduire(String cle, Object... args) {
        ResourceBundle messagesRessource = ResourceBundle.getBundle("message", langueEnCours);
        String message = messagesRessource.getString(cle);

        // Substitue les arguments dans le message (s'il y en a) et retourne le résultat
        return String.format(message, args);
    }
}





