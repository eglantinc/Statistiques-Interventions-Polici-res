/**
 * Cette classe est une représentation d'un objet Intervention Policiere qui contient des informations,
 * telles que la date, l'heure, le parc, l'arrondissement et la description.
 *
 * @Author: Eglantine Clervil, Minh Ha, Farah Bouaiche, Suzanne Kamdem
 * @Courriel: clervil.eglantine_anne@courrier.uqam.ca, ha.le_minh@courrier.uqam.ca, bouaiche.farah@courrier.uqam.ca, kamdem_pouomogne.suzanne_leocadie@courrier.uqam.ca
 * @Code-permanent: CLEE89530109, HAXL19089505, BOUF06379700, KAMS17628009
 * @Groupe: 30
 */
public class InterventionPoliciere {

    /**
     * Ces champs de classe représentent les caractéristiques essentielles d'une intervention policière :
     * - 'date' : La date de l'intervention policière.
     * - 'heure' : L'heure de l'intervention policière.
     * - 'parc' : Le nom du parc où s'est déroulé l'intervention.
     * - 'arrondissement' : L'arrondissement où s'est déroulé l'intervention.
     * - 'description' : La description de l'intervention.
     */
    private String date;
    private String heure;
    private String parc;
    private String arrondissement;
    private String description;

    /**
     * Constructeur de la classe InterventionPoliciere qui prend 5 paramètres pour
     * initialiser les propriétés de l'objet.
     *
     * @param date           La date de l'intervention.
     * @param heure          L'heure de l'intervention.
     * @param parc           Le parc où s'est déroulé l'intervention.
     * @param arrondissement L'arrondissement où s'est déroulé l'intervention.
     * @param description    La description de l'intervention.
     */
    public InterventionPoliciere(String date, String heure, String parc, String arrondissement, String description) {
        this.date = date;
        this.heure = heure;
        this.parc = parc;
        this.arrondissement = arrondissement;
        this.description = description;
    }

    /**
     * Récupère la date de l'intervention.
     *
     * @return La date de l'intervention.
     */
    public String getDate() {
        return date;
    }

    /**
     * Récupère l'heure de l'intervention.
     *
     * @return L'heure de l'intervention.
     */
    public String getHeure() {
        return heure;
    }

    /**
     * Récupère le parc où s'est déroulé l'intervention.
     *
     * @return Le parc où s'est déroulé l'intervention.
     */
    public String getParc() {
        return parc;
    }

    /**
     * Récupère l'arrondissement où s'est déroulé l'intervention.
     *
     * @return L'arrondissement où s'est déroulé l'intervention.
     */
    public String getArrondissement() {
        return arrondissement;
    }

    /**
     * Récupère la description de l'intervention.
     *
     * @return description de l'intervention.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Cette méthode creerUneInterventionPoliciere() permet de créer
     * une instance de l'objet InterventionPoliciere
     */
    public static InterventionPoliciere creerInstanceInterventionPoliciere(String date, String heure, String parc,
                                                                           String arrondissement, String description) {
        return new InterventionPoliciere(date, heure, parc, arrondissement, description);
    }

    @Override
    public String toString() {
        return "InterventionPoliciere{" +
                "date='" + date + '\'' +
                ", heure='" + heure + '\'' +
                ", parc='" + parc + '\'' +
                ", arrondissement='" + arrondissement + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
