import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de tests unitaires pour la classe InterventionPoliciere.
 */
public class InterventionPoliciereTest {


    /**
     * Teste si deux instances d'InterventionPoliciere ayant le même contenu sont identiques.
     */
    @Test
    public void toStringTest() {

        InterventionPoliciere m1 = new InterventionPoliciere("2023-09-01","20:41","Parc Camille",
                "Ahuntsic-Cartierville","Vente de drogues");
        InterventionPoliciere m2 = new InterventionPoliciere("2023-09-01","20:41","Parc Camille",
                "Ahuntsic-Cartierville","Vente de drogues");
        assertEquals(m1.toString(),m2.toString());
    }

    /**
     * Teste si deux instances d'InterventionPoliciere ayant des contenus différents ne sont pas identiques.
     */
    @Test
    public void toStringTest2() {

        InterventionPoliciere m1 = new InterventionPoliciere("2023-09-01","20:41","Parc Camille",
                "Ahuntsic-Cartierville","Vente de drogues");
        InterventionPoliciere m2 = new InterventionPoliciere("2023-09-02","12:41","Parc Camille",
                "Ahuntsic-Cartierville","Bagarre");
        assertNotEquals (m1.toString(),m2.toString());
    }
}
