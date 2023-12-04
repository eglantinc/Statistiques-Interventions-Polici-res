/**
 * La classe TraducteurSingleton représente un singleton permettant d'obtenir une instance unique
 * de la classe Traducteur pour la traduction de messages.
 *
 * @Author: Eglantine Clervil
 * @Courriel: clervil.eglantine_anne@courrier.uqam.ca
 * @Code-permanent: CLEE89530109
 * @Groupe: 30
 */
public class TraducteurSingleton {
    private static Traducteur instance;

    /**
     * Obtient l'instance unique de la classe Traducteur. Si aucune instance n'existe,
     * une nouvelle instance est créée.
     *
     * @return L'instance unique de la classe Traducteur.
     */
    public static Traducteur getInstance() {
        if (instance == null) {
            instance = new Traducteur();
        }
        return instance;
    }

}
