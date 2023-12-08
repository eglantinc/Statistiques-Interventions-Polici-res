import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GestionEnTeteFichierEntreeTest {

    private Traducteur traducteur;
    @BeforeEach
    void setUp() {
        traducteur = TraducteurSingleton.getInstance();
        traducteur.setLangueEnCours(Traducteur.FRANCAIS);
    }

    @Test
    public void gererEnTeteFichierEntreeTest() {
        String enTete ="Date, Heure, Parc, Arrondissement";

        assertThrows(ChampVideDansFichierEntree.class,
                () -> GestionEnTeteFichierEntree.gererEnTeteFichierCsv(enTete, true, "test1,csv"));
    }

}
