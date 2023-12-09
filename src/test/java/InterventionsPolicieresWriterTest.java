import MockEcritureFichier.MockInterventionsPolicieresWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    public void ecrireFichierSortieCallsFileWriterServiceTest() {
        MockInterventionsPolicieresWriter mockFileWriterService = new MockInterventionsPolicieresWriter();
        InterventionsPolicieresWriter interventionsPolicieresWriter = new InterventionsPolicieresWriter(mockFileWriterService);

        String fichierSortie = "testmock.csv";
        String ligneSaisie = "2023-12-01,14:30,Parc A,Arrondissement X,Description A";
        interventionsPolicieresWriter.ecrireFichierSortie(fichierSortie, ligneSaisie);

        Assertions.assertEquals(fichierSortie, mockFileWriterService.fichierSortie);
    }

    @Test
    public void ecrireFichierSortieCallsFileWriterServiceTest2() {
        MockInterventionsPolicieresWriter mockFileWriterService = new MockInterventionsPolicieresWriter();
        InterventionsPolicieresWriter interventionsPolicieresWriter = new InterventionsPolicieresWriter(mockFileWriterService);

        String fichierSortie = "testmock.csv";
        String ligneSaisie = "2023-12-01,14:30,Parc A,Arrondissement X,Description A";
        interventionsPolicieresWriter.ecrireFichierSortie(fichierSortie, ligneSaisie);

        Assertions.assertEquals(ligneSaisie, mockFileWriterService.ligneSaisie);
    }

    @Test
    public void ecrireFichierSortieCallsFileWriterServiceTest3(){
        MockInterventionsPolicieresWriter mockFileWriterService = new MockInterventionsPolicieresWriter();
        InterventionsPolicieresWriter interventionsPolicieresWriter = new InterventionsPolicieresWriter(mockFileWriterService);

        String fichierSortie = "/nonexistant/testmock.csv";
        String ligneSaisie = "2023-12-01,14:30,Parc A,Arrondissement X,Description A";
        Assertions.assertThrows(RuntimeException.class, () ->
                interventionsPolicieresWriter.ecrireFichierSortie(fichierSortie, ligneSaisie));
    }


}

