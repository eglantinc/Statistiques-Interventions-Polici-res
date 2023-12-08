import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de tests unitaires pour la classe InterventionsPolicieresStats.
 */
public class InterventionsPolicieresStatsTest {

    /**
     * Teste le calcul du nombre d'interventions pour un arrondissement avec des parcs et des interventions.
     */
    @Test
    public void calculerNombreInterventionsTest() {
        ArrayList<String> listeParcs = new ArrayList<>();
        listeParcs.add("Parc Camille");
        listeParcs.add("Parc de la Merci");
        listeParcs.add("Parc Prieur");

        ArrayList<String> listeInterventions = new ArrayList<>();
        listeInterventions.add("Vente de drogues");
        listeInterventions.add("Bagarre");
        listeInterventions.add("Manifestation illégale");

        Arrondissement arrondissement = new Arrondissement("Ahuntsic-Cartierville", listeParcs, listeInterventions);

        Assertions.assertEquals(
                3,
                InterventionsPolicieresStats.calculerNombreInterventions(arrondissement));
    }

    /**
     * Teste le calcul du nombre d'interventions pour un arrondissement sans interventions.
     */
    @Test
    public void calculerNombreInterventionsTest2() {
        ArrayList<String> listeParcs = new ArrayList<>();
        listeParcs.add("Parc Camille");
        listeParcs.add("Parc de la Merci");
        listeParcs.add("Parc Prieur");

        ArrayList<String> listeInterventions = new ArrayList<>();

        Arrondissement arrondissement = new Arrondissement("Ahuntsic-Cartierville", listeParcs, listeInterventions);

        Assertions.assertEquals(
                0,
                InterventionsPolicieresStats.calculerNombreInterventions(arrondissement));
    }

    /**
     * Teste le calcul du nombre de parcs pour un arrondissement avec des parcs et des interventions.
     */
    @Test
    public void testCalculerNombreParcs() {
        ArrayList<String> listeParcs = new ArrayList<>();
        listeParcs.add("Parc Camille");
        listeParcs.add("Parc de la Merci");

        ArrayList<String> listeInterventions = new ArrayList<>();
        listeInterventions.add("Vente de drogues");
        listeInterventions.add("Bagarre");
        listeInterventions.add("Manifestation illégale");

        Arrondissement arrondissement = new Arrondissement("Ahuntsic-Cartierville", listeParcs, listeInterventions);

        Assertions.assertEquals(
                2,
                InterventionsPolicieresStats.calculerNombreParcs(arrondissement));
    }

    /**
     * Teste le calcul du nombre de parcs pour un arrondissement sans parcs.
     */
    @Test
    public void testCalculerNombreParcs1() {
        ArrayList<String> listeParcs = new ArrayList<>();

        ArrayList<String> listeInterventions = new ArrayList<>();
        listeInterventions.add("Vente de drogues");
        listeInterventions.add("Bagarre");
        listeInterventions.add("Manifestation illégale");

        Arrondissement arrondissement = new Arrondissement("Ahuntsic-Cartierville", listeParcs, listeInterventions);

        Assertions.assertEquals(
                0,
                InterventionsPolicieresStats.calculerNombreParcs(arrondissement));
    }
}
