import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


/**
 * Cette classe contient des tests unitaires pour la classe InterventionsPolicieresReader.
 *
 * @Author: Bouaiche Farah
 * @Courriel:
 * @Code-permanent: BOUF06379700
 * @Groupe:
 */
public class InterventionsPolicieresReaderTest {

    /**
     * On traite le cas ou le chemin du fichier d'entrée n'existe pas.
     */
    @Test
    public void InterventionsPolicieresReaderTest3() {
        String cheminFichierInput = "FichierInexistant.csv";

        // Vérifie que la méthode génère une exception de type RuntimeException lorsqu'elle tente de lire
        // un fichier inexistant.
        RuntimeException exception = assertThrows(RuntimeException.class, () -> InterventionsPolicieresReader
                .creerListeInterventionsPolicieres (cheminFichierInput));

    }
}








