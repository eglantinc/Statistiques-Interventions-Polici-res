import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class InterventionPoliciereTest {

    private Traducteur traducteur;

    @BeforeEach
    void setUp() {
        traducteur = TraducteurSingleton.getInstance();
        traducteur.setLangueEnCours(Traducteur.FRANCAIS);
    }

    // Permet de tester si 2 objets ont le meme contenu.
    @Test
    public void InterventionPoliciereTestInstancesIdentiques() {

        InterventionPoliciere m1 = new InterventionPoliciere("2023-09-01","20:41","Parc Camille",
                "Ahuntsic-Cartierville","Vente de drogues");
        InterventionPoliciere m2 = new InterventionPoliciere("2023-09-01","20:41","Parc Camille",
                "Ahuntsic-Cartierville","Vente de drogues");
        assertEquals(m1.toString(),m2.toString());
    }

    @Test
    public void InterventionPoliciereTestContenuInstancesNonIdentiques() {

        InterventionPoliciere m1 = new InterventionPoliciere("2023-09-01","20:41","Parc Camille",
                "Ahuntsic-Cartierville","Vente de drogues");
        InterventionPoliciere m2 = new InterventionPoliciere("2023-09-02","12:41","Parc Camille",
                "Ahuntsic-Cartierville","Bagarre");
        assertNotEquals (m1.toString(),m2.toString());
    }
}
