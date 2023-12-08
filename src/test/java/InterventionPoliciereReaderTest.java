import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class InterventionPoliciereReaderTest {

    private Traducteur traducteur;

    @BeforeEach
    void setUp() {
        traducteur = TraducteurSingleton.getInstance();
        traducteur.setLangueEnCours(Traducteur.FRANCAIS);
    }

    // TODO: À bien valider
    @Test
    public void lireInterventionsPolicieresTest() throws IOException {
        // Given
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

    }

    @Test
    public void lireInterventionPoliciereTest2() {
        InterventionsPolicieresReader interventionsPolicieresReader = new InterventionsPolicieresReader("cheminFichierInexistant");
        assertThrows( RuntimeException.class, ( ) ->
                interventionsPolicieresReader.lireInterventionsPolicieres() );
    }
}



