import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 /**
 * La classe ListeDescriptionInterventionPoliciere représente une liste d'interventions policières
 * avec des méthodes pour récupérer la liste d'interventions et créer une liste de descriptions d'infractions.
 *
 * @Author: Eglantine Clervil, Minh Ha, Farah Bouaiche, Suzanne Kamdem
 * @Courriel: clervil.eglantine_anne@courrier.uqam.ca, ha.le_minh@courrier.uqam.ca, bouaiche.farah@courrier.uqam.ca, kamdem_pouomogne.suzanne_leocadie@courrier.uqam.ca
 * @Code-permanent: CLEE89530109, HAXL19089505, BOUF06379700, KAMS17628009
 * @Groupe: 30
 */

public class ListeDescriptionInterventionPoliciere {

    private ArrayList<String> listeInterventions;

    /**
     * Construction de la classe ListeInterventionsPolicieres qui prend 1 paramètre pour initialiser les propriétés
     * de l'objet.
     *
     * @param listeInterventions La liste des interventions qu'il y a eux lieux dans les arrondissements.
     */
    public ListeDescriptionInterventionPoliciere(ArrayList<String> listeInterventions ) {

        this.listeInterventions = listeInterventions;
    }

    /**
     * Récupère la liste d'interventions.
     *
     * @return La liste d'interventions.
     */
    public ArrayList<String> getListeInterventions() {

        return listeInterventions;
    }

    /**
     * Cette methode remplirListeInterventions() permet de récupérer la liste d'objets provenant de la lecture du
     * fichier d'entrée, créer une liste d'interventions provenant des interventions de cette liste afin de
     * rechercher les infractions identiques. Elle prend en paramètre la liste d'objets InterventionPoliciere et
     * le fichier de sortie.
     *
     * @param interventions La liste d'objets InterventionPoliciere à partir de laquelle on a extrait les
     *                      descriptions d'infractions.
     * @return              Une liste de descriptions d'infractions sans doublons, triée par ordre alphabétique.
     */
    public static ArrayList<String> remplirListeInterventionsPolicieres( ArrayList<InterventionPoliciere>
                                                                                 interventions ) {
        Set<String> listeDescriptionAvecDoublons = getListeInfractionsAvecDoublons(interventions);
        ArrayList<String> listeDescriptionSansDoublons = new ArrayList<>(listeDescriptionAvecDoublons);
        Collections.sort(listeDescriptionSansDoublons);
        // On retourne une liste d'infractions triée par ordre alphabétique et sans doublons.
        return listeDescriptionSansDoublons;
    }

    private static Set<String> getListeInfractionsAvecDoublons(ArrayList<InterventionPoliciere> interventions) {
        ArrayList<String> listeInterventionsNonTrieesAvecDoublons = new ArrayList<>();

        // On parcourt la liste d'objets provenant de la lecture du fichier d'entrée.
        for ( InterventionPoliciere interventionPoliciere : interventions) {

            listeInterventionsNonTrieesAvecDoublons.add( interventionPoliciere.getDescription() ) ;
        }
        // On enlève les doublons dans la liste
        return new HashSet<>(listeInterventionsNonTrieesAvecDoublons);
    }

}


