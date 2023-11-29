import java.nio.file.Path;
import java.nio.file.Paths;

public class GestionChampsVides {

    public static final int NOMBRE_COLONNES = 5;

    private String fichierCSV;
    private String[] premiereLigne;

    public GestionChampsVides(String fichierCSV, String[] premiereLigne) {
        // Pour obtenir seulement le nom du fichier csv
        this.fichierCSV = Paths.get(fichierCSV).getFileName().toString();
        this.premiereLigne = premiereLigne;
    }


    /**
     * Cette méthode vérifie la présence de valeurs dans les colonnes d'une ligne spécifique d'un fichier CSV.
     * Si un champ est vide, elle lance une exception avec des détails sur le fichier, la ligne et le champ manquant.
     *
     * @param colonnes      Tableau de chaînes représentant les valeurs des colonnes de la ligne.
     * @param numeroDeLigne Le numéro de la ligne qu'on vérifie.
     * @throws ChampVideDansFichierEntree Si un champ est vide.
     */
    public void gererChampVide(String[] colonnes, int numeroDeLigne) throws ChampVideDansFichierEntree {
        for (int i = 0; i < colonnes.length; i++) {
            if (colonnes[i].isEmpty()) {
                throw new ChampVideDansFichierEntree(String.format("Erreur dans le fichier '%s' à la ligne %d : " +
                                "Le champ %s est manquant.", fichierCSV, numeroDeLigne, premiereLigne[i]));
            }
        }
    }


    /**
     * Vérifie si le nombre de champs dans le tableau 'colonnes' est conforme
     * au nombre attendu de colonnes (NOMBRE_COLONNES). Si le nombre de colonnes
     * est différent, une exception ArrayIndexOutOfBoundsException est levée
     * avec un message d'erreur indiquant le nombre de colonnes attendu.
     *
     * @param colonnes      Tableau représentant les colonnes à vérifier.
     * @param numeroDeLigne Le numéro de la ligne associée pour inclure dans le message d'erreur.
     * @throws ArrayIndexOutOfBoundsException Si le nombre de colonnes est différent
     *                                        du nombre attendu (NOMBRE_COLONNES).
     */
    public static void compterChampsAttendus(String[] colonnes, int numeroDeLigne){
        // Vérifier si le nombre de champs est inférieur ou supérieur à celui attendu
        if (colonnes.length != NOMBRE_COLONNES) {
            throw new ArrayIndexOutOfBoundsException(String.format("Le nombre de colonnes est, soit en trop, soit en moins : " +
                    "vous devez avoir %d colonnes remplies à la ligne : %d", NOMBRE_COLONNES, numeroDeLigne));
        }
    }


}





