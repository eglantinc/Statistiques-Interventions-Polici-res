import java.util.*;
import java.util.HashSet;
import java.util.Set;

/**
 * La classe ListeArrondissementsInterventionsPolicieres fournit une méthode pour extraire et trier
 * les arrondissements à partir d'une liste d'objets InterventionPoliciere.
 *
 * @Author: Eglantine Clervil, Minh Ha, Farah Bouaiche, Suzanne Kamdem
 * @Courriel: clervil.eglantine_anne@courrier.uqam.ca, ha.le_minh@courrier.uqam.ca, bouaiche.farah@courrier.uqam.ca, kamdem_pouomogne.suzanne_leocadie@courrier.uqam.ca
 * @Code-permanent: CLEE89530109, HAXL19089505, BOUF06379700, KAMS17628009
 * @Groupe: 30
 */

public class ListeArrondissementsInterventionsPolicieres {

    /**
     * La méthode parcourt la liste d'objets InterventionPoliciere et ajoute tous les arrondissements dans une liste.
     * Ensuite, elle utilise un ensemble (Set) pour éliminer les doublons, puis crée une nouvelle liste triée par ordre
     * alphabétique sans doublons.
     *
     * @param interventions La liste d'objets InterventionPoliciere provenant de la lecture du fichier d'entrée.
     * @return Une liste d'arrondissements sans doublons, triée par ordre alphabétique.
     */
    public static ArrayList<String> remplirListeArrondissements(ArrayList<InterventionPoliciere> interventions) {

        ArrayList<String> arrondissements = new ArrayList<>();

        for (InterventionPoliciere intervention : interventions) {
            arrondissements.add(intervention.getArrondissement());
        }

        Set<String> listeArrondissementsAvecDoublons = new HashSet<>(arrondissements);
        ArrayList<String> listeArrondissementsSansDoublons = new ArrayList<>(listeArrondissementsAvecDoublons);

        Collections.sort(listeArrondissementsSansDoublons);

        return listeArrondissementsSansDoublons;
    }
}