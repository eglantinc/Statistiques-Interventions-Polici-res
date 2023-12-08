
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class JsonParserTest {
    private Traducteur traducteur;

    @BeforeEach
    void setUp() {
        traducteur = TraducteurSingleton.getInstance();
        traducteur.setLangueEnCours(Traducteur.FRANCAIS);
    }

    @Test
    public void chargerInfosFichierJsonDansArrayListTest() {
        // Fichier quelconque et nom de l'array quelconque.
        assertThrows(RuntimeException.class,
                () -> JsonParser.chargerInfosFichierJsonArrayList("fichiernonexistant.json", "arraynonexistant"));
    }


    @Test
    public void chargerInfosFichierJsonDansArrayListTest2() {
        // Faute de frappe dans le nom de l'array json.
        assertThrows(RuntimeException.class,
                () -> JsonParser.chargerInfosFichierJsonArrayList
                        ("arrondissements.json", "arrondissement"));
    }
}