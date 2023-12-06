public class GestionEnTeteFichierEntree {
    public static void gererEnTeteFichierCsv(String ligne, boolean estEnTete) {
        if (estEnTete) {
            // Supprime le caractère de marqueur d'ordre des octets (BOM) '\uFEFF'
            ligne = ligne.replace("\uFEFF", "");
            String[] premiereLigneLu = gererChampVideDansEntete(ligne);

            for (int k = 0; k < InterventionsPolicieresReader.PREMIERE_LIGNE.length; k++) {
                if (!InterventionsPolicieresReader.PREMIERE_LIGNE[k].equals(premiereLigneLu[k])) {
                    throw new InformationInvalideDansLeFichierEntree(TraducteurSingleton.getInstance()
                            .traduire("erreurEnTeteChampInapproprie", premiereLigneLu[k], k+1));
                }
            }
        }
    }

    private static String[] gererChampVideDansEntete(String ligne) {
        String[] premiereLigneLu = ligne.split(",");

        if (premiereLigneLu.length != InterventionsPolicieresReader.PREMIERE_LIGNE.length) {
            throw new ChampVideDansFichierEntree(TraducteurSingleton.getInstance().traduire("erreurNombreChampEnTete"));
        }
        return premiereLigneLu;
    }
}
