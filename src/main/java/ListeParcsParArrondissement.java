import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 /**
 * La classe ListeParcsParArrondissement fournit une méthode pour remplir une liste d'objets Arrondissement
 * avec des informations sur les parcs et les interventions associées à chaque arrondissement.
 *
 * @Author: Eglantine Clervil, Minh Ha, Farah Bouaiche, Suzanne Kamdem
 * @Courriel: clervil.eglantine_anne@courrier.uqam.ca, ha.le_minh@courrier.uqam.ca, bouaiche.farah@courrier.uqam.ca, kamdem_pouomogne.suzanne_leocadie@courrier.uqam.ca
 * @Code-permanent: CLEE89530109, HAXL19089505, BOUF06379700, KAMS17628009
 * @Groupe: 30
 */
public class ListeParcsParArrondissement {

    /**
     * Cette méthode remplit une liste d'objets Arrondissement avec des informations sur les parcs et les
     * interventions associées à chaque arrondissement, à partir d'une liste d'intervention policières et d'une
     * liste d'arrondissements fournie.
     *
     * @param interventions Liste d'objets InterventionPoliciere à traiter.
     * @param listeArrondissements Liste des arrondissements pour lesquels les informations sur les parcs et les
     *                             interventions seront extraites.
     * @return Une liste d'objet Arrondissement contenant les informations sur les parcs et les infractions
     *         à chaque arrondissement.
     */
    public static ArrayList<Arrondissement> remplirListeParcsParArrondissements( ArrayList<InterventionPoliciere> interventions, ArrayList<String> listeArrondissements ) {

        ArrayList<String> listeInfractions = new ArrayList<>();
        ArrayList<String> listeParcs = new ArrayList<>();
        ArrayList<Arrondissement> listeParcParArrond = new ArrayList<>();

        // On parcourt la liste d'objets provenant de la lecture du fichier d'entrée.
        for( String arrondissementUnique : listeArrondissements ) {

            for( InterventionPoliciere interventionPoliciere : interventions ) {

                // Tous les arrondissements des objets InterventionPoliciere sont comparé à la
                // liste d'arrondissements.
                if( interventionPoliciere.getArrondissement().equals(arrondissementUnique ) ) {

                    listeParcs.add( interventionPoliciere.getParc() );
                    listeInfractions.add( interventionPoliciere.getDescription() );
                }
            }
            Set<String> listeParcsSansDoublons = new HashSet<>(listeParcs );
            ArrayList<String> parcsSansDoublons = new ArrayList<>(listeParcsSansDoublons );
            listeParcParArrond.add( new Arrondissement(arrondissementUnique,
                    parcsSansDoublons, listeInfractions) );
            listeInfractions = new ArrayList<>();
            listeParcs = new ArrayList<>();

        }
        return listeParcParArrond;
    }
}












