import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class GestionDateIntervention {

    /**
     * Vérifie que la date de l'intervention est valide, qu'elle est postérieure à la date actuelle
     * et qu'elle suit le format ISO 8601 (AAAA-MM-JJ).
     *
     * @param compteurLigne la ligne où se trouve l'erreur
     * @param dateIntervention La chaîne de caractères représentant la date d'intervention.
     * @throws InformationInvalideDansLeFichierEntree Si la date est invalide ou antérieure à la date actuelle.
     */
    public static void gererErreurDateIntervention(String nomFichier, int compteurLigne, String dateIntervention )
            throws InformationInvalideDansLeFichierEntree {

        LocalDate dateCourante = LocalDate.now();

        if( dateIntervention != null ) {

            gererErreurFormatDate( dateIntervention );

            if( (LocalDate.parse(dateIntervention).isAfter(dateCourante ) ) ) {

                throw new InformationInvalideDansLeFichierEntree(
                        String.format("Erreur dans le fichier '%s' à la ligne %d, " +
                                "La date d'intervention: '%s' est postérieure à la date actuelle." ,
                                nomFichier, compteurLigne, dateIntervention));
            }
        }
    }

    /**
     * Vérifie si la chaîne de caractères représentant une date est au format ISO 8601 (AAAA-MM-JJ).
     *
     * @param dateInterventionString La chaîne de caractères représentant la date.
     * @throws InformationInvalideDansLeFichierEntree Si le format est invalide.
     */
    private static void gererErreurFormatDate( String dateInterventionString )
            throws InformationInvalideDansLeFichierEntree {

        try{

            LocalDate.parse(dateInterventionString );

        } catch( DateTimeParseException exception ) {

            throw new InformationInvalideDansLeFichierEntree( "Erreur! Le format de date d'intervention '"
                    + dateInterventionString
                    + "' est invalide. Assurez-vous que la date est au format ISO 8601 (AAAA-MM-JJ)." );

        }
    }
}
