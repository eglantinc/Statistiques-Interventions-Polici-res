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

        // Si le logiciel est exécuté en français
        if (args.length < 2) {
            throw new ArrayIndexOutOfBoundsException(traducteur.traduire("erreurNombreParametresInvalides"));
        }

        // Si le logiciel est exécuté en anglais
        if (estAnglais && args.length < 3) {
            throw new ArrayIndexOutOfBoundsException(traducteur.traduire("erreurNombreParametresInvalides"));
        }

        String cheminFichierEntree = args[indexCheminFichiers];
        String cheminFichierSortie = args[indexCheminFichiers + 1];


        traiterInterventionsPolicieres(cheminFichierEntree, cheminFichierSortie);
    }


    public static void traiterInterventionsPolicieres( String cheminFichierEntree, String cheminFichierSortie )
            throws IOException, ParseException {

        ArrayList<InterventionPoliciere> interventions = InterventionsPolicieresReader
                .creerListeInterventionsPolicieres (cheminFichierEntree );

        // On crée une liste d'arrondissements triés qui seront comparer à la liste d'objets.
        ArrayList<String> tousLesArrondissements = ListeArrondissementsInterventionsPolicieres
                .remplirListeArrondissements(interventions);

        // On compare la liste des arrondissements du fichier d'entrée avec le fichier Json des arrondissements
        GestionDonneesAvecFichiersJson.gererArrondissementsDeMontrealInvalides
                (tousLesArrondissements);

        ArrayList<String> toutesLesInterventions = ListeDescriptionInterventionPoliciere
                .remplirListeInterventionsPolicieres(interventions);

        GestionDonneesAvecFichiersJson.gererDescriptionInterventionsInvalides(toutesLesInterventions);

        ArrayList<Arrondissement> listeParcsInfractions = ListeParcsParArrondissement
                .remplirListeParcsParArrondissements( interventions,tousLesArrondissements );

        // Premiere ligne du fichier de sortie à ne pas traiter.
        ecrireStatistiquesInterventionsParArrondissement(cheminFichierSortie, listeParcsInfractions);

    }

    private static void ecrireStatistiquesInterventionsParArrondissement(String cheminFichierSortie, ArrayList<Arrondissement> listeParcsInfractions) {
        //String premiereLigne = "Arrondissement, Nombre d'interventions, Nombre de parcs" ;
        String enTeteCsv = TraducteurSingleton.getInstance().traduire("enTeteCsv");
        InterventionsPolicieresWriter.ecrireFichierSortie (cheminFichierSortie, enTeteCsv);

        // On calcule le nombre de parcs et d'infractions selon un arrondissement donné et on affiche dans
        // le fichier de sortie
        for( Arrondissement uneListeParcsInfractions : listeParcsInfractions) {

            int totalInterventionsParArrondissement = InterventionsPolicieresStats
                    .calculerNombreInterventions(uneListeParcsInfractions );

            int totalParcsParArrondissement = InterventionsPolicieresStats
                    .calculerNombreParcs(uneListeParcsInfractions );

            String ligneEcrite = uneListeParcsInfractions.getNomArrondissement()
                    + " , " + totalInterventionsParArrondissement
                    + " , " + totalParcsParArrondissement;

            InterventionsPolicieresWriter
                    .ecrireFichierSortie (cheminFichierSortie,ligneEcrite );
        }
    }

}


