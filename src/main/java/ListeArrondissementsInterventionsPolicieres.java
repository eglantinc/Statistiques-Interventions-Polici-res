import java.util.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Cette classe est une représentation d'un objet Intervention Policiere qui contient des informations,
 * telles que la date, l'heure, le parc, l'arrondissement et la description.
 *
 * @Author: Eglantine Clervil, Minh Ha, Farah Bouaiche, Suzanne Kamdem
 * @Courriel: clervil.eglantine_anne@courrier.uqam.ca, ha.le_minh@courrier.uqam.ca, bouaiche.farah@courrier.uqam.ca, kamdem_pouomogne.suzanne_leocadie@courrier.uqam.ca
 * @Code-permanent: CLEE89530109, HAXL19089505, BOUF06379700, KAMS17628009
 * @Groupe: 30
 */

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
