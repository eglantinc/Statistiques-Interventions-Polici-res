import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Cette classe fournit des méthodes pour lire des données à partir d'un fichier JSON
 * et les charger dans une structure de données ArrayList.
 * Elle utilise la bibliothèque JSON-lib (net.sf.json) pour la manipulation des données JSON.
 */
public class JsonParser {
    /**
     * Charge les informations d'un fichier JSON spécifié dans une ArrayList.
     *
     * @param cheminFichierJson   Le nom du fichier JSON à lire.
     * @param nomArrayJson Le nom du tableau JSON dans le fichier à extraire.
     * @return Une ArrayList contenant les éléments du tableau JSON spécifié.
     * @throws IOException En cas d'erreur lors de la lecture du fichier JSON.
     */
    public static ArrayList<String> chargerInfosFichierJsonArrayList(String cheminFichierJson,
                                                                     String nomArrayJson) throws IOException {
        ArrayList<String> informationSurInterventionDansJson = new ArrayList<>();

        try {
            String jsonText = DiskFile.loadFileIntoString(cheminFichierJson);

            JSONParser parser = new JSONParser();
            JSONObject objetJson = (JSONObject) parser.parse(jsonText);

            JSONArray arrayInformationsValidesFichierJson = (JSONArray) objetJson.get(nomArrayJson);

            for (Object objetJava : arrayInformationsValidesFichierJson) {
                informationSurInterventionDansJson.add((String) objetJava);
            }

        } catch (IOException e) {
            throw new IOException(String.format("Erreur lors de la lecture du fichier '%s'. "
                    + "Assurez-vous que le fichier existe et est accessible. "
                    + "Vérifiez les autorisations du fichier et réessayez.", cheminFichierJson));
        } catch (ParseException e) {
            throw new RuntimeException("Une exception s'est produite lors de la manipulation JSON. "
                    + "Vérifier bien que le nom de l'array JSON est valide.");
        }

        return informationSurInterventionDansJson;
    }

}







