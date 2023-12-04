import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class GestionDateIntervention {


    /**
     * Vérifie que la date de l'intervention est valide, qu'elle est postérieure à la date actuelle
     * et qu'elle suit le format ISO 8601 (AAAA-MM-JJ).
     *
     * @param compteurLigne la ligne où se trouve l'erreur
     * @param dateInterventionString La chaîne de caractères représentant la date d'intervention.
     * @throws InformationInvalideDansLeFichierEntree Si la date est invalide ou antérieure à la date actuelle.
     */
    public static void gererDateHorsLimite(String nomFichier, int compteurLigne, String dateInterventionString)
            throws InformationInvalideDansLeFichierEntree {

        LocalDate dateCourante = LocalDate.now();

        if( dateInterventionString != null ) {

            gererErreurFormatDate(nomFichier, compteurLigne, dateInterventionString);

            if( (LocalDate.parse(dateInterventionString).isAfter(dateCourante ) ) ) {

                throw new InformationInvalideDansLeFichierEntree(
                        TraducteurSingleton.getInstance().traduire(("erreurDateHorsLimite"), nomFichier,
                                compteurLigne, dateInterventionString));
            }
        }
    }

    /**
     * Vérifie si la chaîne de caractères représentant une date est au format ISO 8601 (AAAA-MM-JJ).
     *
     * @param dateInterventionString La chaîne de caractères représentant la date.
     * @throws InformationInvalideDansLeFichierEntree Si le format est invalide.
     */
    private static void gererErreurFormatDate( String nomDuFichier, int compteurDeLigne,
                                               String dateInterventionString ) {

        try{

            LocalDate.parse(dateInterventionString );

        } catch( DateTimeParseException exception ) {

            throw new InformationInvalideDansLeFichierEntree(TraducteurSingleton
                    .getInstance().traduire("erreurFormatDateInvalide",
                    nomDuFichier, compteurDeLigne, dateInterventionString));

        }
    }
}
