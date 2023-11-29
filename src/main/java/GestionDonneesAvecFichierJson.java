import java.io.IOException;
import java.util.ArrayList;

public class GestionDonneesAvecFichierJson {

    /**
     * Cette méthode vérifie si les arrondissements fournis dans un fichier d'entrée sont valides en les comparant à
     * une liste d'arrondissements de Montréal préalablement chargées à partir d'un fichier JSON. En cas
     * d'arrondissement invalide, on lance une exception avec un message d'erreur détaillé.
     *
     * @param arrondissementsDuFichierEntree Liste des arrondissements provenant du fichier d'entrée à valider.
     * @throws IOException En cas d'erreur lors du chargement des informations depuis le fichier JSON.
     * @throws InformationInvalideDansLeFichierEntree Si un arrondissement dans le fichier d'entrée n'est pas valide.
     */
    public static void gererArrondissementsDeMontrealInvalides( ArrayList<String> arrondissementsDuFichierEntree )
            throws IOException {

        ArrayList<String> arrondissementsDeMontreal = JsonParser
                .chargerInfosFichierJsonArrayList ("fichiers_json/arrondissements.json",
                            "arrondissements" );

        for( String arrondissement: arrondissementsDuFichierEntree ) {

            if( !arrondissementsDeMontreal.contains(arrondissement) ) {

                throw new InformationInvalideDansLeFichierEntree(String.format("Erreur! '%s' n'est pas reconnu comme un arrondissement de Montreal.",arrondissement));
            }

        }
    }

    /**
     * Cette méthode vérifie si les interventions fournies dans un fichier d'entrées sont valides en les comparant à
     * une liste d'interventions policières considérées valides qui a été préalablement chargée à partir d'un fichier
     * JSON.
     *
     * @param descriptionsDansFichierEntree Liste des interventions provenant du fichier d'entrée à valider.
     * @throws IOException En cas d'erreur lors du chargement des informations depuis le fichier JSON.
     * @throws InformationInvalideDansLeFichierEntree Si une intervention dans le fichier d'entrée n'est pas valide.
     */
    public static void gererDescriptionInterventionsInvalides(ArrayList<String> descriptionsDansFichierEntree) throws IOException {

        ArrayList<String> descriptionsInterventionsConsidereesValides = JsonParser
                .chargerInfosFichierJsonArrayList ("fichiers_json/intervention_policiere.json",
                        "intervention_policiere" );

        for( String uneDescription : descriptionsDansFichierEntree) {

            if( !descriptionsInterventionsConsidereesValides.contains(uneDescription) ) {

                throw new InformationInvalideDansLeFichierEntree(
                       String.format("Erreur! '%s' n'est pas reconnu comme une description d'intervention policière valide.", uneDescription));
            }

        }
    }



}


