import MockEcritureFichier.InterventionsPolicieresWriterService;
import MockEcritureFichier.MockInterventionsPolicieresWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/**
 * Classe de tests unitaires pour la classe InterventionsPolicieresWriter.
 */
public class InterventionsPolicieresWriterTest {

    /**
     * Teste l'écriture d'un fichier de sortie avec un chemin de fichier inexistant.
     */
    @Test
    public void testEcrireFichierSortie2() {
        InterventionsPolicieresWriter interventionsPolicieresWriter = new InterventionsPolicieresWriter();
        assertThrows(RuntimeException.class, () ->
                interventionsPolicieresWriter.ecrireFichierSortie("Desktop/cheminnonexistant", "2023-04-15,00:00,Parc du Mont-Royal,Outremont,Vente de drogues"));
    }

    /**
     * Cas de test pour vérifier que la méthode ecrireFichierSortie appelle correctement le service de FileWriter.
     * Il s'assure que le nom du fichier passé à la méthode correspond au fichier de sortie attendu dans le mock.
     */
    @Test
    public void ecrireFichierSortieCallsFileWriterServiceTest() {
        MockInterventionsPolicieresWriter mockFileWriterService = new MockInterventionsPolicieresWriter();
        InterventionsPolicieresWriter interventionsPolicieresWriter = new InterventionsPolicieresWriter(mockFileWriterService);

        String fichierSortie = "testmock.csv";
        String ligneSaisie = "2023-12-01,14:30,Parc A,Arrondissement X,Description A";
        interventionsPolicieresWriter.ecrireFichierSortie(fichierSortie, ligneSaisie);

        Assertions.assertEquals(fichierSortie, mockFileWriterService.fichierSortie);
    }


    /**
     * Cas de test pour vérifier que la méthode ecrireFichierSortie appelle correctement le service de FileWriter.
     * Il s'assure que la ligne de saisie passée à la méthode correspond à la ligne de saisie attendue dans le mock.
     */
    @Test
    public void ecrireFichierSortieCallsFileWriterServiceTest2() {
        MockInterventionsPolicieresWriter mockFileWriterService = new MockInterventionsPolicieresWriter();
        InterventionsPolicieresWriter interventionsPolicieresWriter = new InterventionsPolicieresWriter(mockFileWriterService);

        String fichierSortie = "testmock.csv";
        String ligneSaisie = "2023-12-01,14:30,Parc A,Arrondissement X,Description A";
        interventionsPolicieresWriter.ecrireFichierSortie(fichierSortie, ligneSaisie);

        Assertions.assertEquals(ligneSaisie, mockFileWriterService.ligneSaisie);
    }

    /**
     * Cas de test pour vérifier que la méthode ecrireFichierSortie lance une RuntimeException
     * lorsqu'elle tente d'écrire dans un fichier inexistant.
     */
    @Test
    public void ecrireFichierSortieCallsFileWriterServiceTest3(){
        MockInterventionsPolicieresWriter mockFileWriterService = new MockInterventionsPolicieresWriter();
        InterventionsPolicieresWriter interventionsPolicieresWriter = new InterventionsPolicieresWriter(mockFileWriterService);

        String fichierSortie = "/nonexistant/testmock.csv";
        String ligneSaisie = "2023-12-01,14:30,Parc A,Arrondissement X,Description A";
        Assertions.assertThrows(RuntimeException.class, () ->
                interventionsPolicieresWriter.ecrireFichierSortie(fichierSortie, ligneSaisie));
    }


    /**
     * Cas de test pour vérifier que la méthode ecrireFichierSortie lance une RuntimeException
     * lorsqu'elle tente d'écrire sans spécifier de fichier.
     */
    @Test
    public void ecrireFichierSortieCallsFileWriterServiceTest4() {
        MockInterventionsPolicieresWriter mockFileWriterService = new MockInterventionsPolicieresWriter();
        InterventionsPolicieresWriter interventionsPolicieresWriter = new InterventionsPolicieresWriter(mockFileWriterService);

        Assertions.assertThrows(RuntimeException.class, () ->
                interventionsPolicieresWriter.ecrireFichierSortie(mockFileWriterService.fichierSortie, mockFileWriterService.ligneSaisie));
    }


    /**
     * Cas de test pour vérifier que la méthode ecrireFichierSortie appelle correctement
     * la méthode ecrireDansFichierSortie du service de FileWriter.
     * Il utilise Mockito pour vérifier que le service est appelé avec les bons paramètres.
     *
     * @throws IOException si une erreur d'entrée/sortie survient
     */
    @Test
    public void testEcrireFichierSortie_CallsEcrireDansFichierSortie() throws IOException {
        InterventionsPolicieresWriterService interventionsPolicieresWriterService = mock(InterventionsPolicieresWriterService.class);

        InterventionsPolicieresWriter interventionsPolicieresWriter = new InterventionsPolicieresWriter(interventionsPolicieresWriterService);

        String fichierSortie = "testmock.csv";
        String ligneSaisie = "2023-12-01,14:30,Parc A,Arrondissement X,Description A";
        interventionsPolicieresWriter.ecrireFichierSortie(fichierSortie, ligneSaisie);

        verify(interventionsPolicieresWriterService, times(1))
                .ecrireDansFichierSortie(fichierSortie, ligneSaisie);
    }


}

