import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GestionDateInterventionTest {


    @Test

    void testGestionDateIntervention() {
        Traducteur traducteur = TraducteurSingleton.getInstance();
        traducteur.setLangueEnCours(Traducteur.FRANCAIS);

        String dateFuture = "2024-12-01";
        String nomFichier = "test_cas_attendu.csv";
        int numeroDeLigne = InterventionsPolicieresReader.numeroDeLigne;

        assertThrows(InformationInvalideDansLeFichierEntree.class, () ->
                GestionDateIntervention.gererErreurDate(nomFichier, numeroDeLigne, dateFuture)
        );
    }

    @Test
    void testGestionDateIntervention4() {
        Traducteur traducteur = TraducteurSingleton.getInstance();
        traducteur.setLangueEnCours(Traducteur.FRANCAIS);

        String nomFichier = "test7.csv";

        assertThrows(InformationInvalideDansLeFichierEntree.class, () ->
                GestionDateIntervention.gererErreurDate(nomFichier, InterventionsPolicieresReader.numeroDeLigne, "2020MARS21"));
    }

    @Test
    void testGestionDateIntervention5() {
        Traducteur traducteur = TraducteurSingleton.getInstance();
        traducteur.setLangueEnCours(Traducteur.FRANCAIS);

        String nomFicher = "test1.csv";

        assertThrows(InformationInvalideDansLeFichierEntree.class, () ->
                GestionDateIntervention.gererErreurDate(nomFicher, InterventionsPolicieresReader.numeroDeLigne, "20221206"));
    }

    @Test
    void testGestionDateIntervention6() {
        Traducteur traducteur = TraducteurSingleton.getInstance();
        traducteur.setLangueEnCours(Traducteur.FRANCAIS);
        String nomFichier = "test_cas_attendu.csv";

        assertThrows(InformationInvalideDansLeFichierEntree.class, () ->
                GestionDateIntervention.gererErreurDate(nomFichier, InterventionsPolicieresReader.numeroDeLigne, "13-11-2024"));
    }
}
