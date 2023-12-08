import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class InterventionsPolicieresWriterTest {

//    @Test
//    public void testEcrireFichierSortie() throws IOException {
//        // Given
//        InterventionsPolicieresWriter interventionsPolicieresWriter = new InterventionsPolicieresWriter();
//        String fileName = "testOutput.txt";
//        String content = "Test content";
//
//        FileWriter mockedFileWriter = mock(FileWriter.class);
//        BufferedWriter mockedBufferedWriter = mock(BufferedWriter.class);
//
//        doNothing().when(mockedFileWriter).write(anyString());
//        doNothing().when(mockedBufferedWriter).newLine();
//
//        // When
//        interventionsPolicieresWriter.ecrireFichierSortie(fileName, content);
//
//        // Verify that FileWriter and BufferedWriter methods were called with the expected parameters
//        verify(mockedFileWriter).write(content);
//        verify(mockedBufferedWriter).newLine();
//    }

    @Test
    public void testEcrireFichierSortie2() {
            InterventionsPolicieresWriter interventionsPolicieresWriter = new InterventionsPolicieresWriter();
            assertThrows( RuntimeException.class, ( ) ->
                    interventionsPolicieresWriter.ecrireFichierSortie("Desktop/cheminnonexistant", "2023-04-15,00:00,Parc du Mont-Royal,Outremont,Vente de drogues") );
        }
    }



