import java.time.LocalTime;
import java.time.format.DateTimeParseException;


public class GestionHeureIntervention {

    /**
     * Vérifie si la chaîne de caractères représentant une heure est au format ISO 8601 (HH:MM).
     *
     * @param nomFichier Le nom du fichier contenant les informations.
     * @param numeroLigne Le numéro de la ligne où se trouve l'erreur.
     * @param heureInterventionString La chaîne de caractères représentant l'heure d'intervention.
     * @throws InformationInvalideDansLeFichierEntree Si le format de l'heure est invalide.
     */
    public static void gererErreurFormatHeure(String nomFichier, int numeroLigne, String heureInterventionString) {

        try {
            LocalTime.parse(heureInterventionString);

        } catch (DateTimeParseException exception) {
            throw new InformationInvalideDansLeFichierEntree(TraducteurSingleton.getInstance()
                    .traduire("erreurFormatHeureInvalide", nomFichier, numeroLigne,
                            heureInterventionString));
        }
    }


}
