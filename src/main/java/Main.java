import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        Traducteur traducteur = TraducteurSingleton.getInstance();
        boolean estAnglais = args[0].equals("--english");
        // Si le logiciel est exécuté en anglais, alors, le fichier d'entrée sera à l'index 1,
        // sinon, à l'index 0 de la ligne de commande
        int indexCheminFichiers = estAnglais ? 1 : 0;
        traducteur.setLangueEnCours(estAnglais ? Traducteur.ANGLAIS : Traducteur.FRANCAIS);

        if ((estAnglais && args.length < 3) || (!estAnglais && args.length < 2)) {
            throw new ArrayIndexOutOfBoundsException(traducteur.traduire("erreurNombreParametresInvalides"));
        }

        String cheminFichierEntree = args[indexCheminFichiers];
        String cheminFichierSortie = args[indexCheminFichiers + 1];

        traiterInterventionsPolicieres(cheminFichierEntree, cheminFichierSortie);
    }


    /**
     * Cette méthode traite les interventions policières à partir d'un fichier d'entrée CSV
     * et génère des statistiques qui sont ensuite écrites dans un fichier de sortie CSV.
     *
     * @param cheminFichierEntree Le chemin du fichier CSV d'entrée contenant les données d'interventions policières.
     * @param cheminFichierSortie Le chemin du fichier CSV de sortie où seront écrites les statistiques.
     *
     */
    public static void traiterInterventionsPolicieres(String cheminFichierEntree, String cheminFichierSortie) {
        InterventionsPolicieresReader interventionsPolicieresReader = new InterventionsPolicieresReader(cheminFichierEntree);
        ArrayList<InterventionPoliciere> interventions = interventionsPolicieresReader.lireInterventionsPolicieres();

        ArrayList<String> tousLesArrondissements = ListeArrondissementsInterventionsPolicieres.remplirListeArrondissements(interventions);

        GestionDonneesAvecFichiersJson.gererArrondissementsDeMontrealInvalides(tousLesArrondissements);

        ArrayList<String> toutesLesInterventions = ListeDescriptionInterventionPoliciere.remplirListeInterventionsPolicieres(interventions);

        GestionDonneesAvecFichiersJson.gererDescriptionInterventionsInvalides(toutesLesInterventions);

        ArrayList<Arrondissement> listeParcsInfractions = ListeParcsParArrondissement.remplirListeParcsParArrondissements(interventions, tousLesArrondissements);

        ecrireStatistiquesInterventionsParArrondissement(cheminFichierSortie, listeParcsInfractions);
    }


    /**
     * Cette méthode génère des statistiques sur les interventions policières par arrondissement
     * et écrit ces statistiques dans un fichier de sortie au format CSV.
     *
     * @param cheminFichierSortie    Le chemin du fichier CSV de sortie où seront écrites les statistiques.
     * @param listeParcsInfractions La liste des arrondissements avec les statistiques d'interventions policières.
     *
     */
    private static void ecrireStatistiquesInterventionsParArrondissement(String cheminFichierSortie, ArrayList<Arrondissement> listeParcsInfractions) {
        String enTeteCsv = TraducteurSingleton.getInstance().traduire("enTeteCsv");
        InterventionsPolicieresWriter interventionsPolicieresWriter = new InterventionsPolicieresWriter();
        interventionsPolicieresWriter.ecrireFichierSortie(cheminFichierSortie, enTeteCsv);

        for (Arrondissement uneListeParcsInfractions : listeParcsInfractions) {
            int totalInterventionsParArrondissement = InterventionsPolicieresStats.calculerNombreInterventions(uneListeParcsInfractions);
            int totalParcsParArrondissement = InterventionsPolicieresStats.calculerNombreParcs(uneListeParcsInfractions);
            String ligneEcrite = uneListeParcsInfractions.getNomArrondissement()
                    + " , " + totalInterventionsParArrondissement
                    + " , " + totalParcsParArrondissement;

            interventionsPolicieresWriter.ecrireFichierSortie(cheminFichierSortie, ligneEcrite);
        }
    }
}