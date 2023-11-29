//import net.sf.json.JSONException;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//public class JsonReaderTest {
//    @Test
//    public void chargerInfosFichierJsonDansArrayListTest () {
//        // Fichier quelconque et nom de l'array quelconque.
//        Throwable exception = assertThrows(IOException.class,
//                () -> JsonParser.chargerInfosFichierJsonArrayList
//                        ("fichiernonexistant.json","arraynonexistant"));
//    }
//
//
//    @Test
//    public void chargerInfosFichierJsonDansArrayListTest2 () {
//        // Faute de frappe dans le nom de l'array json.
//        Throwable exception = assertThrows(IOException.class,
//                () -> JsonParser.chargerInfosFichierJsonArrayList
//                        ("arrondissements.json","arrondissement"));
//    }
//
//    @Test
//    public void chargerInfosFichierJsonDansArrayListTest3 () {
//        // Faute de frappe dans le nom du fichier json.
//        Throwable exception = assertThrows(IOException.class,
//                () -> JsonParser.chargerInfosFichierJsonArrayList
//                        ("arrondissement.json","arrondissements"));
//    }
//
//    @Test
//    public void chargerInfosFichierJsonDansArrayListTest4 () {
//        // Fichier quelconque et nom de l'array valide.
//        Throwable exception = assertThrows(IOException.class,
//                () -> JsonParser.chargerInfosFichierJsonArrayList
//                        ("fichiernonexistant.json","arrondissements"));
//    }
//
//    @Test
//    public void chargerInfosFichierJsonDansArrayListTest5 () {
//        // Nom de fichier valide et nom de l'array quelconque.
//        Throwable exception = assertThrows(IOException.class,
//                () -> JsonParser.chargerInfosFichierJsonArrayList
//                        ("arrondissements.json","arraynonexistant"));
//    }
//
//}
