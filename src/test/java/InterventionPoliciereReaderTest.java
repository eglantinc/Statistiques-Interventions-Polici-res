import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/**
 * Classe de tests unitaires pour la classe InterventionPoliciereReader.
 */
public class InterventionPoliciereReaderTest {

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
     * Teste la lecture des interventions policières à partir d'un fichier mock.
     *
     * @throws IOException si une erreur d'entrée/sortie survient lors de la lecture du fichier
     */
    @Test
    public void lireInterventionsPolicieresTest() throws IOException {
        BufferedReader mockedBufferedReader = mock(BufferedReader.class);
        InterventionsPolicieresReader interventionsPolicieresReaderMock = new InterventionsPolicieresReader("src/test/resources/testmock.csv");

        when(mockedBufferedReader.readLine())
                .thenReturn("Date,Heure,Parc,Arrondissement,Description")
                .thenReturn("2023-12-01,14:30,Parc A,Arrondissement X,Description A")
                .thenReturn("2023-12-02,09:45,Parc B,Arrondissement Y,Description B")
                .thenReturn("2023-12-03,18:00,Parc C,Arrondissement Z,Description C")
                .thenReturn(null);

        ArrayList<InterventionPoliciere> result = interventionsPolicieresReaderMock.lireInterventionsPolicieres();

        assertEquals(3, result.size());
        assertEquals("2023-12-01", result.get(0).getDate());
        assertEquals("14:30", result.get(0).getHeure());
    }

    /**
     * Teste la gestion d'une exception lors de la lecture d'un fichier inexistant.
     */
    @Test
    public void lireInterventionPoliciereTest2() {
        InterventionsPolicieresReader interventionsPolicieresReader = new InterventionsPolicieresReader("cheminFichierInexistant");
        assertThrows(RuntimeException.class, interventionsPolicieresReader::lireInterventionsPolicieres);
    }
}
