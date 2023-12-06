import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GestionHeureInterventionTest {

    private Traducteur traducteur;

    @BeforeEach
    void setUp() {
        traducteur = TraducteurSingleton.getInstance();
        traducteur.setLangueEnCours(Traducteur.FRANCAIS);
    }

    @Test
    void GestionHeureInterventionTest( ) {
        String nomFichier = "nomFichier";
        int ligne = 2;
        // Format nul, une exception devrait être levée.
        assertThrows( RuntimeException.class, ( ) ->
                GestionHeureIntervention.gererErreurFormatHeure(nomFichier,  ligne, null ) );
    }

    @Test
    void GestionHeureInterventionTest2( ) {
        String nomFichier = "nomFichier";
        int ligne = 2;
        // Heure en dehors de la plage valide (24:00)
        String heure = "25:30";
        InformationInvalideDansLeFichierEntree exception = assertThrows(
                InformationInvalideDansLeFichierEntree.class,
                ( ) -> GestionHeureIntervention.gererErreurFormatHeure(nomFichier, ligne, heure));
    }
    @Test
    void GestionHeureInterventionTest3( ){
        String nomFichier = "nomFichier";
        int ligne = 2;
        // Heure invalide (format incorrect)
        String heure = "12-30";
        InformationInvalideDansLeFichierEntree exception = assertThrows(
                InformationInvalideDansLeFichierEntree.class,
                () -> GestionHeureIntervention.gererErreurFormatHeure(nomFichier, ligne, heure));
    }

}
