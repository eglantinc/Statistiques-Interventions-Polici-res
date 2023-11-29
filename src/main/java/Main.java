import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {


        // Il faut entrer le fichier d'entrée et de sortie en ligne de commande.
       if( args.length < 2 ) {

            throw new ArrayIndexOutOfBoundsException("Erreur : Veuillez spécifier les emplacements des fichiers d'entrée et de sortie.\n" +
                   "Veuillez utiliser la commande suivante dans la ligne de commande :\n" +
                   "java -jar target/inf2050-sprint-1.0-jar-with-dependencies.jar <chemin_fichier_entree> <chemin_fichier_sortie>\n" +
                   "Remplacez <chemin_fichier_entree> par le chemin de votre fichier CSV d'entrée et\n " +
                    "<nom_fichier_sortie> par le nom souhaité pour votre fichier CSV de sortie.");


       }


        String cheminFichierEntree = args[0];
        String cheminFichierSortie = args[1];

         traiterInterventionsPolicieres( cheminFichierEntree, cheminFichierSortie );

    }

    public static void traiterInterventionsPolicieres( String cheminFichierEntree, String cheminFichierSortie )
            throws IOException {

        ArrayList<InterventionPoliciere> interventions = InterventionsPolicieresReader
                .creerListeInterventionsPolicieres (cheminFichierEntree );

        // On crée une liste d'arrondissements triés qui seront comparer à la liste d'objets.
        ArrayList<String> tousLesArrondissements = ListeArrondissementsInterventionsPolicieres
                .remplirListeArrondissements(interventions);

        // On compare la liste des arrondissements du fichier d'entrée avec le fichier Json des arrondissements
        GestionDonneesAvecFichierJson.gererArrondissementsDeMontrealInvalides
                (tousLesArrondissements);

        ArrayList<String> toutesLesInterventions = ListeDescriptionInterventionPoliciere
                .remplirListeInterventionsPolicieres(interventions);

        GestionDonneesAvecFichierJson.gererDescriptionInterventionsInvalides(toutesLesInterventions);

        ArrayList<Arrondissement> listeParcsInfractions = ListeParcsParArrondissement
                .remplirListeParcsParArrondissements( interventions,tousLesArrondissements );

        // Premiere ligne du fichier de sortie a ne pas traiter.
        ecrireStatistiquesInterventionsParArrondissement(cheminFichierSortie, listeParcsInfractions);

    }

    private static void ecrireStatistiquesInterventionsParArrondissement(String cheminFichierSortie, ArrayList<Arrondissement> listeParcsInfractions) {
        String premiereLigne = "Arrondissement, Nombre d'interventions, Nombre de parcs" ;
        InterventionsPolicieresWriter.ecrireFichierSortie (cheminFichierSortie,premiereLigne);

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


