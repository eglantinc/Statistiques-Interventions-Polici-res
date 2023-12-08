import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

public class TraducteurTest {

    private Traducteur traducteur;

    @BeforeEach
    void setUp() {
        traducteur = new Traducteur();
        traducteur.setLangueEnCours(Traducteur.ANGLAIS);
    }

    @Test
    public void testTraduireChampManquant() {

        String translatedMessage = traducteur.traduire("erreurDescriptionInterventionInvalide", "Vol");
        Assertions.assertEquals("Error! 'Vol' is not recognized as a valid police intervention description.", translatedMessage);
    }
}
