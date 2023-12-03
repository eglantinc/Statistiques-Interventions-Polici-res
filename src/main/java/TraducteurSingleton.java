/**
 * Cette classe est une représentation d'un objet Intervention Policiere qui contient des informations,
 * telles que la date, l'heure, le parc, l'arrondissement et la description.
 *
 * @Author: Eglantine Clervil
 * @Courriel: clervil.eglantine_anne@courrier.uqam.ca
 * @Code-permanent: CLEE89530109
 * @Groupe: 30
 */
public class TraducteurSingleton {
    private static Traducteur instance;

    public static Traducteur getInstance() {
        if (instance == null) {
            instance = new Traducteur();
        }
        return instance;
    }

}
