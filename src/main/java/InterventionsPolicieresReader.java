import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * La classe InterventionsPolicieresReader est responsable de la lecture des interventions policières à partir d'un fichier CSV.
 * @Author: Eglantine Clervil
 * @Courriel: clervil.eglantine_anne@courrier.uqam.ca
 * @Code-permanent: CLEE89530109
 * @Groupe: 30
 */
public class InterventionsPolicieresReader {

    /**
     * Chemin du fichier d'entrée.
     */
    public String cheminFichierSaisi;

    /**
     * Numéro de la ligne actuellement traitée.
     */
    private int numeroDeLigne = 1;

    /**
     * Première ligne attendue dans le fichier CSV.
     */
    public static final String[] PREMIERE_LIGNE = {"Date", "Heure", "Parc", "Arrondissement", "Description"};

    /**
     * Constructeur de la classe InterventionsPolicieresReader.
     *
     * @param cheminFichierSaisi Le chemin du fichier d'entrée.
     */
    public InterventionsPolicieresReader(String cheminFichierSaisi) {
        this.cheminFichierSaisi = cheminFichierSaisi;
    }

    /**
     * Extrait le nom du fichier à partir du chemin complet.
     *
     * @return Le nom du fichier.
     */
    private String getNomFichier() {
        return Paths.get(cheminFichierSaisi).getFileName().toString();
    }

    /**
     * Lit les interventions policières à partir du fichier CSV.
     *
     * @return Une liste d'objets InterventionPoliciere.
     */
    public ArrayList<InterventionPoliciere> lireInterventionsPolicieres() {
        ArrayList<InterventionPoliciere> interventions = new ArrayList<>();

        try (BufferedReader lecteur = new BufferedReader(new FileReader(cheminFichierSaisi))) {
            traiterFichierCsv(lecteur, interventions);
        } catch (IOException ex) {
            throw new RuntimeException(TraducteurSingleton.getInstance().traduire("erreurLectureFichier", cheminFichierSaisi));
        }

        return interventions;
    }

    /**
     * Traite le fichier CSV ligne par ligne.
     *
     * @param lecteur       Le lecteur de fichier.
     * @param interventions La liste des interventions policières.
     * @throws IOException En cas d'erreur lors de la lecture du fichier.
     */
    private void traiterFichierCsv(BufferedReader lecteur, ArrayList<InterventionPoliciere> interventions) throws IOException {
        String ligne;
        boolean estEntete = true;

        while ((ligne = lecteur.readLine()) != null) {
            GestionEnTeteFichierEntree.gererEnTeteFichierCsv(ligne, estEntete, getNomFichier());
            estEntete = false;

            if (numeroDeLigne > 1) {
                String[] champs = ligne.split(",");
                traiterInterventionPoliciere(champs, interventions);
            }
            numeroDeLigne++;
        }
    }

    /**
     * Traite les champs d'une ligne pour créer une InterventionPoliciere et les ajouter à la liste.
     *
     * @param champs         Les champs d'une ligne.
     * @param interventions La liste des interventions policières.
     */
    private void traiterInterventionPoliciere(String[] champs, ArrayList<InterventionPoliciere> interventions) {
        GestionChampsVides gestionnaireChampsVide = new GestionChampsVides(cheminFichierSaisi, PREMIERE_LIGNE);
        gererChampsVidesFichierEntree(champs, gestionnaireChampsVide);

        InterventionPoliciere unObjetInterventionPoliciere = creerObjetInterventionPoliciere(champs);
        gererErreursTemporelles(getNomFichier(), unObjetInterventionPoliciere);

        interventions.add(unObjetInterventionPoliciere);
    }

    /**
     * Gère les erreurs temporelles (date et heure) d'une intervention policière.
     *
     * @param nomFichier                   Le nom du fichier.
     * @param unObjetInterventionPoliciere L'objet InterventionPoliciere.
     */
    private void gererErreursTemporelles(String nomFichier, InterventionPoliciere unObjetInterventionPoliciere) {
        GestionDateIntervention.gererErreurDate(nomFichier, numeroDeLigne, unObjetInterventionPoliciere.getDate());
        GestionHeureIntervention.gererErreurFormatHeure(nomFichier, numeroDeLigne, unObjetInterventionPoliciere.getHeure());
    }

    /**
     * Gère les champs vides d'une ligne du fichier d'entrée.
     *
     * @param champs                 Les champs d'une ligne.
     * @param gestionnaireChampsVide Le gestionnaire de champs vides.
     */
    private void gererChampsVidesFichierEntree(String[] champs, GestionChampsVides gestionnaireChampsVide) {
        GestionChampsVides.compterChampsAttendus(champs, numeroDeLigne);
        gestionnaireChampsVide.gererChampVide(champs, numeroDeLigne);
    }

    /**
     * Crée un objet InterventionPoliciere à partir des champs d'une ligne.
     *
     * @param champs Les champs d'une ligne.
     * @return L'objet InterventionPoliciere.
     */
    private InterventionPoliciere creerObjetInterventionPoliciere(String[] champs) {
        return InterventionPoliciere.creerInstanceInterventionPoliciere(champs[0], champs[1], champs[2], champs[3], champs[4]);
    }
}
