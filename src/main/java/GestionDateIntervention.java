import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * La classe GestionDateIntervention fournit des méthodes pour gérer la validation
 * de la date d'intervention dans le format ISO 8601 (AAAA-MM-JJ) et assure qu'elle
 * est antérieure à la date actuelle
 *
 * @Author: Eglantine Clervil
 * @Courriel: clervil.eglantine_anne@courrier.uqam.ca
 * @Code-permanent: CLEE89530109
 * @Groupe: 30
 *
 */
public class GestionDateIntervention {


    /**
     * Vérifie que la date de l'intervention est valide, qu'elle est antérieure à la date actuelle
     * et qu'elle suit le format ISO 8601 (AAAA-MM-JJ).
     *
     * @param nomFichier Le nom du fichier contenant les informations.
     * @param compteurLigne La ligne où se trouve l'erreur.
     * @param dateInterventionString La chaîne de caractères représentant la date d'intervention.
     * @throws InformationInvalideDansLeFichierEntree Si la date est invalide ou postérieure à la date actuelle.
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
     * @param nomDuFichier Le nom du fichier contenant les informations.
     * @param compteurDeLigne La ligne où se trouve l'erreur.
     * @param dateInterventionString La chaîne de caractères représentant la date.
     * @throws InformationInvalideDansLeFichierEntree Si le format de la date est invalide.
     */
    private static void gererErreurFormatDate(String nomDuFichier, int compteurDeLigne,
                                              String dateInterventionString) {

        try {
            // Tente de parser la chaîne en une LocalDate au format ISO 8601
            LocalDate.parse(dateInterventionString);

        } catch (DateTimeParseException exception) {
            // Lance une exception si le format de la date est invalide
            throw new InformationInvalideDansLeFichierEntree(TraducteurSingleton
                    .getInstance().traduire("erreurFormatDateInvalide",
                            nomDuFichier, compteurDeLigne, dateInterventionString));
        }
    }

}
