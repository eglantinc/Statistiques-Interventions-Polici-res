import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GestionDateInterventionTest {

    /**
     * Teste la méthode {@code gererErreurDateIntervention} avec une date future.
     * Vérifie que la date est valide.
     */
    @Test
    void GestionDateInterventionTest() {
        // Date future
        String dateFuture ="2024-12-01";
        String nomFichier = "test_cas_attendu.csv";
        // Vérifie que la date est valide.
        assertThrows ( InformationInvalideDansLeFichierEntree.class,() -> GestionDateIntervention
                .gererErreurDateIntervention (nomFichier, InterventionsPolicieresReader.numeroDeLigne, dateFuture),"Erreur! La date d'intervention est postérieure à la date actuelle");
    }


    /**
     * Teste la méthode {@code gererErreurDateIntervention} avec une date passée.
     * Vérifie que l'exception {@code InformationInvalideDansLeFichierEntree} n'est pas trouvée, car la date est
     * antérieure à la date actuelle.
     */
    @Test
    void GestionDateInterventionTest2() {
        String nomFichier = "test_cas_attendu2.csv";
        String datePasseValide = "2024-01-01";
        int ligne = 1;
        InformationInvalideDansLeFichierEntree exception = assertThrows(
                InformationInvalideDansLeFichierEntree.class,
                () -> GestionDateIntervention.gererErreurDateIntervention(nomFichier, InterventionsPolicieresReader.numeroDeLigne, datePasseValide) );
    }

    /**
     * On teste que la methode gererErreurFormatDate est fonctionnelle et renvoie un message d'erreur
     * dans le cas ou la date entrée n'est pas en format ISO.
     */
    @Test
    void GestionDateInterventionTest3() {
        String nomFichier = "test5.csv";
        int ligne = 1;
        InformationInvalideDansLeFichierEntree exception =
                assertThrows(InformationInvalideDansLeFichierEntree.class,
                        () -> GestionDateIntervention
                                .gererErreurDateIntervention (nomFichier, InterventionsPolicieresReader.numeroDeLigne, "01/12/2023"));

        assertEquals("Erreur! Le format de date d'intervention '01/12/2023' est invalide. Assurez-vous que la date est au format ISO 8601 (AAAA-MM-JJ).",
                exception.getMessage());
    }
    @Test
    void GestionDateInterventionTest4() {
        String nomFichier = "test7.csv";
        InformationInvalideDansLeFichierEntree exception = assertThrows(
                InformationInvalideDansLeFichierEntree.class,
                () -> GestionDateIntervention.gererErreurDateIntervention(nomFichier, InterventionsPolicieresReader.numeroDeLigne, "2020MARS21") );
    }

    @Test
    void GestionDateInterventionTest5() {
        String nomFicher = "test_cas_attendu.csv";
        InformationInvalideDansLeFichierEntree exception = assertThrows(
                InformationInvalideDansLeFichierEntree.class,
                () -> GestionDateIntervention.gererErreurDateIntervention(nomFicher, InterventionsPolicieresReader.numeroDeLigne, "20221206") );
    }
    @Test
    void GestionDateInterventionTest6() {
        String nomFichier = "test_cas_attendu.csv";
        InformationInvalideDansLeFichierEntree exception = assertThrows(
                InformationInvalideDansLeFichierEntree.class,
                () -> GestionDateIntervention.gererErreurDateIntervention(nomFichier, InterventionsPolicieresReader.numeroDeLigne, "13-11-2024") );
    }
}
