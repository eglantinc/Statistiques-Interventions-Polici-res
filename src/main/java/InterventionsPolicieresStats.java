import java.util.*;
import java.util.stream.Collectors;

/**
 * Cette classe contient des méthodes pour effectuer des statistiques sur les interventions policières.
 *
 *
 * @Author: Eglantine Clervil, Minh Ha, Farah Bouaiche, Suzanne Kamdem
 * @Courriel: clervil.eglantine_anne@courrier.uqam.ca, ha.le_minh@courrier.uqam.ca, bouaiche.farah@courrier.uqam.ca
 * @Code-permanent: CLEE89530109, HAXL19089505, BOUF06379700, KAMS17628009
 * @Groupe: 30
 */
public class InterventionsPolicieresStats {

    /**
     * Cette méthode calcule le nombre d'interventions enregistrées pour un arrondissement spécifié.
     *
     * @param unArrondissement L'objet Arrondissement pour lequel le nombre d'interventions est calculé.
     * @return Le nombre d'interventions enregistrées pour l'arrondissement spécifié.
     */
    public static int calculerNombreInterventions(Arrondissement unArrondissement) {
        ArrayList<String> contientInterventions = unArrondissement.getListeInfractions();
        return contientInterventions.size();
    }

    /**
     * Cette méthode calcule le nombre de parcs enregistrés pour un arrondissement spécifié.
     *
     * @param unArrondissement L'objet Arrondissement pour lequel le nombre de parcs est calculé.
     * @return Le nombre de parcs enregistrés pour l'arrondissement spécifié.
     */
    public static int calculerNombreParcs(Arrondissement unArrondissement) {
        ArrayList<String> contientParcs = unArrondissement.getListeDeParcs();
        return contientParcs.size();
    }
}



