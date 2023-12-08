import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe de tests unitaires pour la classe GestionDateIntervention.
 */
public class GestionDateInterventionTest {

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
     * Teste la gestion d'une date future invalide.
     */
    @Test
    void testGestionDateIntervention() {
        String dateFuture = "2024-12-01";
        String nomFichier = "test_cas_attendu.csv";
        int numeroDeLigne = 6;

        assertThrows(InformationInvalideDansLeFichierEntree.class, () ->
                GestionDateIntervention.gererErreurDate(nomFichier, numeroDeLigne, dateFuture)
        );
    }

    /**
     * Teste la gestion d'un format de date incorrect.
     */
    @Test
    void testGestionDateIntervention4() {

        String nomFichier = "test7.csv";

        assertThrows(InformationInvalideDansLeFichierEntree.class, () ->
                GestionDateIntervention.gererErreurDate(nomFichier, 1, "2020MARS21"));
    }

    /**
     * Teste la gestion d'une date au format incorrect.
     */
    @Test
    void testGestionDateIntervention5() {
        String nomFicher = "test1.csv";

        assertThrows(InformationInvalideDansLeFichierEntree.class, () ->
                GestionDateIntervention.gererErreurDate(nomFicher, 2, "20221206"));
    }

    /**
     * Teste la gestion d'une date au format incorrect.
     */
    @Test
    void testGestionDateIntervention6() {
        String nomFichier = "test_cas_attendu.csv";

        assertThrows(InformationInvalideDansLeFichierEntree.class, () ->
                GestionDateIntervention.gererErreurDate(nomFichier, 2, "13-11-2024"));
    }
}
