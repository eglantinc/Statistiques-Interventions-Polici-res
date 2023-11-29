import java.util.*;
import java.util.HashSet;
import java.util.Set;

public class ListeArrondissementsInterventionsPolicieres {

    private ArrayList<String> listeArrondissements;

    /**
     * Construction de la classe ListeArrondissementsInterventionsPolicieres qui prend 1 paramètre pour initialiser les
     * propriétés de l'objet.
     *
     * @param listeArrondissements La liste des arrondissements qu'il y a eux lieux dans les arrondissements.
     */
    public ListeArrondissementsInterventionsPolicieres( ArrayList<String> listeArrondissements ) {

        this.listeArrondissements = listeArrondissements;
    }

    /**
     * La méthode parcourt la liste d'objets InterventionPoliciere et ajoute tous les arrondissements dans une liste.
     * Ensuite, elle utilise un ensemble (Set) pour éliminer les doublons, puis crée une nouvelle liste triée par ordre
     * alphabétique sans doublons.
     *
     * @param interventions La liste d'objets InterventionPoliciere provenant de la lecture du fichier d'entrée.
     * @return Une liste d'arrondissements sans doublons, triée par ordre alphabétique.
     */
    public static ArrayList<String> remplirListeArrondissements( ArrayList<InterventionPoliciere> interventions ) {

        ArrayList<String> arrondissements = new ArrayList<>();

        for( InterventionPoliciere intervention : interventions ) {

            arrondissements.add( intervention.getArrondissement() ) ;
        }

        Set<String> listeArrondissementsAvecDoublons = new HashSet<>(arrondissements );
        ArrayList<String> listeArrondissementsSansDoublons = new ArrayList<>(listeArrondissementsAvecDoublons );

        Collections.sort( listeArrondissementsSansDoublons );

        return listeArrondissementsSansDoublons;
    }

}
