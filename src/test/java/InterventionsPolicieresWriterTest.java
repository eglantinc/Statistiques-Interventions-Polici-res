import org.junit.jupiter.api.Test;

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
}
