/**
 * Cette classe fournit des méthodes pour gérer l'en-tête d'un fichier CSV, en particulier pour vérifier si
 * l'en-tête est approprié et s'il y a des champs vides dans celui-ci.
 *
 *
 * @Author: Eglantine Clervil
 * @Courriel: clervil.eglantine_anne@courrier.uqam.ca
 * @Code-permanent: CLEE89530109
 * @Groupe: 30
 */
public class GestionEnTeteFichierEntree {

    /**
     * Gère l'en-tête du fichier CSV en vérifiant s'il est approprié. Si l'en-tête est incorrect, une exception
     * est lancée avec un message d'erreur détaillé.
     *
     * @param ligne      La ligne de l'en-tête du fichier CSV.
     * @param estEnTete  Indique si la ligne est une en-tête.
     * @param nomFichier Le nom du fichier CSV.
     * @throws InformationInvalideDansLeFichierEntree Si un champ de l'en-tête est inapproprié.
     */
    public static void gererEnTeteFichierCsv(String ligne, boolean estEnTete, String nomFichier) {
        if (estEnTete) {
            // Supprime le caractère de marqueur d'ordre des octets (BOM) '\uFEFF'
            ligne = ligne.replace("\uFEFF", "");
            String[] premiereLigneLu = gererNombreChampEntete(nomFichier, ligne);

            for (int k = 0; k < InterventionsPolicieresReader.PREMIERE_LIGNE.length; k++) {
                if (!InterventionsPolicieresReader.PREMIERE_LIGNE[k].equals(premiereLigneLu[k])) {
                    throw new InformationInvalideDansLeFichierEntree(TraducteurSingleton.getInstance()
                            .traduire("erreurEnTeteChampInapproprie", nomFichier, premiereLigneLu[k], k + 1));
                }
            }
        }
    }

    /**
     * Gère les champs vides dans l'en-tête du fichier CSV.
     *
     * @param ligne La ligne de l'en-tête du fichier CSV.
     * @return Un tableau de chaînes représentant les champs de l'en-tête.
     * @throws ChampVideDansFichierEntree Si un champ de l'en-tête est vide.
     */
    private static String[] gererNombreChampEntete(String nomFichier, String ligne) {
        String[] premiereLigneLu = ligne.split(",");

        if (premiereLigneLu.length != InterventionsPolicieresReader.PREMIERE_LIGNE.length) {
            throw new ChampVideDansFichierEntree(TraducteurSingleton.getInstance().traduire("erreurNombreChampEnTete", nomFichier));
        }
        return premiereLigneLu;
    }
}
