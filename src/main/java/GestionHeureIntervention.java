import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class GestionHeureIntervention {

    /**
     * Vérifie si la chaîne de caractères représentant une heure est au format ISO 8601 (HH:MM).
     *
     * @param heureInterventionString La chaîne de caractères représentant l'heure d'intervention.
     * @throws InformationInvalideDansLeFichierEntree Si le format est invalide.
     */
    public static void gererErreurFormatHeure( String nomFichier, int numeroLigne, String heureInterventionString ) {

        try{

            LocalTime.parse(heureInterventionString );

        } catch( DateTimeParseException exception ) {

            throw new InformationInvalideDansLeFichierEntree(TraducteurSingleton.getInstance()
                    .traduire("erreurFormatHeureInvalide", nomFichier, numeroLigne,
                    heureInterventionString ) );

        }
    }

}
