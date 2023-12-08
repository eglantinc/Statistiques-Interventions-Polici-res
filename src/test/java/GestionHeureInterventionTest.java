import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe de tests unitaires pour la classe GestionHeureIntervention.
 */
public class GestionHeureInterventionTest {

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
     * Teste la gestion d'une heure d'intervention nulle.
     */
    @Test
    void gererErreurFormatHeureTest() {
        String nomFichier = "nomFichier";
        int ligne = 2;
        // Format null, une exception devrait être levée.
        assertThrows(RuntimeException.class, () ->
                GestionHeureIntervention.gererErreurFormatHeure(nomFichier, ligne, null));
    }

    /**
     * Teste la gestion d'une heure d'intervention en dehors de la plage valide.
     */
    @Test
    void gererErreurFormatHeureTest2() {
        String nomFichier = "nomFichier";
        int ligne = 2;
        // Heure en dehors de la plage valide (24:00)
        String heure = "25:30";
        InformationInvalideDansLeFichierEntree exception = assertThrows(
                InformationInvalideDansLeFichierEntree.class,
                () -> GestionHeureIntervention.gererErreurFormatHeure(nomFichier, ligne, heure));
    }

    /**
     * Teste la gestion d'une heure d'intervention invalide (format incorrect).
     */
    @Test
    void gererErreurFormatHeureTest3() {
        String nomFichier = "nomFichier";
        int ligne = 2;
        // Heure invalide (format incorrect)
        String heure = "12-30";
        InformationInvalideDansLeFichierEntree exception = assertThrows(
                InformationInvalideDansLeFichierEntree.class,
                () -> GestionHeureIntervention.gererErreurFormatHeure(nomFichier, ligne, heure));
    }
}
