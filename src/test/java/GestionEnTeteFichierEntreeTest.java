import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Classe de tests unitaires pour la classe GestionEnTeteFichierEntree.
 */
public class GestionEnTeteFichierEntreeTest {

    private Traducteur traducteur;

    /**
     * Initialisation avant chaque test.
     */
    @BeforeEach
    void setUp() {
        traducteur = TraducteurSingleton.getInstance();
        traducteur.setLangueEnCours(Traducteur.FRANCAIS);
    }

    /**
     * Teste la gestion de l'en-tête du fichier d'entrée.
     */
    @Test
    public void gererEnTeteFichierEntreeTest() {
        String enTete = "Date, Heure, Parc, Arrondissement";

        assertThrows(ChampVideDansFichierEntree.class,
                () -> GestionEnTeteFichierEntree.gererEnTeteFichierCsv(enTete, true, "test1,csv"));
    }
}
