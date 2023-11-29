import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ListeParcsParArrondissementTest {

    @Test
    public void testRemplirListeParcsParArrondissementsAvecListeVideTest1() {

        // Creation d'une liste vide d'objets de type InterventionsPoliciere.

        ArrayList<InterventionPoliciere> interventions = new ArrayList<>();

        // Création d'une liste vide String pour tester le cas ou l'arrondissement est vide.
        ArrayList<String> listeArrondissements = new ArrayList<>();

        // Appelle de la methode remplirListeParcsParArrondissements pour remplir par une liste vide puis stocker
        // dans le résultat.
        ArrayList<Arrondissement> resultat = ListeParcsParArrondissement
                .remplirListeParcsParArrondissements( interventions, listeArrondissements );
        // On teste avec assertEquals si la taille de la liste est nulle.
        assertEquals( 0, resultat.size() );
    }

    @Test
    public void testRemplirListeParcsParArrondissementsNonVideTest2() {

        //Création des Instances de classe InterventionPoliciere.
        ArrayList<InterventionPoliciere> interventions = new ArrayList<>();

        interventions.add( new InterventionPoliciere( "2020-10-12", "14:30",
                "Parc Oscar", "Montréal-Nord", "Vols qualifiés" ) );

        interventions.add( new InterventionPoliciere( "2023-09-13", "16:45",
                "Parc Poirier", "Verdun", "Bagarre" ) );

        interventions.add( new InterventionPoliciere( "2021-08-14", "12:00",
                "Parc de l'Aqueduc", "LaSalle", "Vente de drogues" ) );

        interventions.add( new InterventionPoliciere( "2022-07-15", "10:15",
                "Parc René-Lévesque", "Lachine", "Vols qualifiés" ) );

        interventions.add( new InterventionPoliciere( "2020-05-16", "18:20",
                "Parc Henri-Bourassa", "Montréal-Nord", "Port d'arme prohibée" ) );

        // Création de la liste d'arrondissements avec quatre valeurs.

        ArrayList<String> listeArrondissements = new ArrayList<>
                ( Arrays.asList( "Montréal-Nord", "Verdun", "LaSalle", "Lachine" ) );

        // Vérifier que la liste n'est pas vide.
        ArrayList<Arrondissement> resultat = ListeParcsParArrondissement
                .remplirListeParcsParArrondissements( interventions, listeArrondissements );

        assertEquals( listeArrondissements.size(), resultat.size() );
    }
}
