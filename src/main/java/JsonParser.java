import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Cette classe est une représentation d'un objet Intervention Policiere qui contient des informations,
 * telles que la date, l'heure, le parc, l'arrondissement et la description.
 *
 * @Author: Eglantine Clervil
 * @Courriel: clervil.eglantine_anne@courrier.uqam.ca
 * @Code-permanent: CLEE89530109
 * @Groupe: 30
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
                                                                     String nomArrayJson) throws ParseException  {
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
            TraducteurSingleton.getInstance().traduire("erreurLectureFichier"
                    , cheminFichierJson);
        }
        return informationSurInterventionDansJson;
    }

}







