/**
 * Cette classe représente une exception spécifique indiquant la présence d'un champ vide dans un fichier d'entrée.
 * Elle étend la classe RuntimeException.
 *
 *
 * @Author: Eglantine Clervil
 * @Courriel: clervil.eglantine_anne@courrier.uqam.ca
 * @Code-permanent: CLEE89530109
 * @Groupe: 30
 */
public class ChampVideDansFichierEntree extends RuntimeException{

    /**
     * Constructeur de la classe ChampVideDansFichierEntree.
     *
     * @param message Le message d'erreur associé à l'exception.
     */
    public ChampVideDansFichierEntree(String message) {
        super(message);
    }
}
