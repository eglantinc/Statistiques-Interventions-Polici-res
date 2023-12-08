import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe de tests unitaires pour la classe Traducteur.
 */
public class TraducteurTest {

    private Traducteur traducteur;

    /**
     * Initialise un objet Traducteur avant chaque test.
     */
    @BeforeEach
    void setUp() {
        traducteur = new Traducteur();
        traducteur.setLangueEnCours(Traducteur.ANGLAIS);
    }

    /**
     * Teste la méthode traduire pour un champ manquant.
     *
     * @implNote On appelle la méthode traduire avec une description d'intervention invalide ("Vol").
     *          On vérifie que le message traduit correspond à un message d'erreur attendu.
     */
    @Test
    public void testTraduireChampManquant() {
        String messageTraduit = traducteur.traduire("erreurDescriptionInterventionInvalide", "Vol");
        Assertions.assertEquals("Error! 'Vol' is not recognized as a valid police intervention description.", messageTraduit);
    }
}
