import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Classe de tests unitaires pour la classe ListeParcsParArrondissement.
 */
public class ListeParcsParArrondissementTest {

    /**
     * Teste la méthode remplirListeParcsParArrondissements avec une liste d'interventions vide.
     *
     */
    @Test
    public void remplirListeParcsParArrondissementsAvecListeVideTest() {
        ArrayList<InterventionPoliciere> interventions = new ArrayList<>();
        ArrayList<String> listeArrondissements = new ArrayList<>();
        ArrayList<Arrondissement> resultat = ListeParcsParArrondissement
                .remplirListeParcsParArrondissements(interventions, listeArrondissements);
        assertEquals(0, resultat.size());
    }

    /**
     * Teste la méthode remplirListeParcsParArrondissements avec une liste d'interventions non vide.
     *
     */
    @Test
    public void remplirListeParcsParArrondissementsNonVideTest2() {
        ArrayList<InterventionPoliciere> interventions = new ArrayList<>();
        interventions.add(new InterventionPoliciere("2020-10-12", "14:30", "Parc Oscar", "Montréal-Nord", "Vols qualifiés"));
        interventions.add(new InterventionPoliciere("2023-09-13", "16:45", "Parc Poirier", "Verdun", "Bagarre"));
        interventions.add(new InterventionPoliciere("2021-08-14", "12:00", "Parc de l'Aqueduc", "LaSalle", "Vente de drogues"));
        interventions.add(new InterventionPoliciere("2022-07-15", "10:15", "Parc René-Lévesque", "Lachine", "Vols qualifiés"));
        interventions.add(new InterventionPoliciere("2020-05-16", "18:20", "Parc Henri-Bourassa", "Montréal-Nord", "Port d'arme prohibée"));

        ArrayList<String> listeArrondissements = new ArrayList<>(Arrays.asList("Montréal-Nord", "Verdun", "LaSalle", "Lachine"));

        ArrayList<Arrondissement> resultat = ListeParcsParArrondissement
                .remplirListeParcsParArrondissements(interventions, listeArrondissements);

        assertEquals(listeArrondissements.size(), resultat.size());
    }
}
