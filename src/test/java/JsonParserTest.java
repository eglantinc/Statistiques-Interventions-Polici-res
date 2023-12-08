import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Classe de tests unitaires pour la classe JsonParser.
 */
public class JsonParserTest {
    private Traducteur traducteur;

    @BeforeEach
    void setUp() {
        traducteur = TraducteurSingleton.getInstance();
        traducteur.setLangueEnCours(Traducteur.FRANCAIS);
    }

    /**
     * Teste le chargement d'informations depuis un fichier JSON dans une ArrayList.
     * Lève une exception si le fichier JSON ou le nom de l'array est inexistant.
     */
    @Test
    public void chargerInfosFichierJsonDansArrayListTest() {
        assertThrows(RuntimeException.class,
                () -> JsonParser.chargerInfosFichierJsonArrayList("fichiernonexistant.json", "arraynonexistant"));
    }

    /**
     * Teste le chargement d'informations depuis un fichier JSON dans une ArrayList.
     * Lève une exception en cas de faute de frappe dans le nom de l'array JSON.
     */
    @Test
    public void chargerInfosFichierJsonDansArrayListTest2() {
        assertThrows(RuntimeException.class,
                () -> JsonParser.chargerInfosFichierJsonArrayList
                        ("arrondissements.json", "arrondissement"));
    }
}
