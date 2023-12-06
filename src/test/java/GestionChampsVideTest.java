import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

public class GestionChampsVideTest {
    private Traducteur traducteur;

    @BeforeEach
    void setUp() {
        traducteur = TraducteurSingleton.getInstance();
        traducteur.setLangueEnCours(Traducteur.FRANCAIS);
    }

    @Test
    public void GestionChampsVideTest1(){
        String[] colonnes ={"2020-11-12", "Parc Henri-Bourassa", "Montréal-Nord", "Bagarre"};
        String[] ligne = InterventionsPolicieresReader.PREMIERE_LIGNE;
        int i = InterventionsPolicieresReader.numeroDeLigne;

        Throwable exception = assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> GestionChampsVides.compterChampsAttendus(colonnes,i));
    }
}
