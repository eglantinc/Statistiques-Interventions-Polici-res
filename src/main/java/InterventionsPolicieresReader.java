import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Cette classe permet de lire des données d'un fichier CSV d'interventions policières dont on a le chemin.
 *
 * @Author: Eglantine Clervil, Minh Ha, Farah Bouaiche, Kamdem Suzanne
 * @Courriel: clervil.eglantine_anne@courrier.uqam.ca, ha.le_minh@courrier.uqam.ca,
 * bouaiche.farah@courrier.uqam.ca, kamdem_pouomogne.suzanne_leocadie@courrier.uqam.ca
 * @Code-permanent: CLEE89530109, HAXL19089505, BOUF06379700, KAMS17628009
 * @Groupe: 30
 */
public class InterventionsPolicieresReader {

    private String cheminFichierSaisi;
    public static int numeroDeLigne = 1;
    public final static String [] PREMIERE_LIGNE = {"Date", "Heure", "Parc", "Arrondissement", "Description"};

    /**
     * Constructeur de la classe InterventionsPolicieresReader.
     *
     * @param cheminFichierSaisi Le chemin du fichier à partir duquel les données d'interventions policières
     *                            seront lues.
     */
    public InterventionsPolicieresReader( String cheminFichierSaisi ) {

        this.cheminFichierSaisi = cheminFichierSaisi;
    }

    /**
     * Récupère le chemin du fichier à lire.
     *
     * @return le chemin du fichier à lire.
     */
    public String getCheminFichierSaisi() {

        return cheminFichierSaisi;
    }

    /**
     * Cette méthode crée une liste d'objets InterventionPoliciere à partir des données lues dans un fichier CSV.
     *
     * @param cheminFichier Le chemin d'accès au fichier CSV contenant les données des interventions policières.
     * @return Une liste d'objets InterventionPoliciere créés à partir des données du fichier.
     * @throws RuntimeException Si une erreur d'entrée/sortie (IOException) survient pendant la lecture du fichier.
     */
    public static ArrayList<InterventionPoliciere> creerListeInterventionsPolicieres( String cheminFichier ) {
        // Récupérer uniquement le nom du fichier
        String nomFichier = Paths.get(cheminFichier).getFileName().toString();


        GestionChampsVides gestionnaireChampsVide = new GestionChampsVides(cheminFichier, PREMIERE_LIGNE);

        ArrayList<InterventionPoliciere> interventions = new ArrayList<>();
        try( BufferedReader lecteur = new BufferedReader(new FileReader(cheminFichier ) ) ) {

            String ligne;

            while( ( ligne = lecteur.readLine()) != null ) {

                if( numeroDeLigne > 1 ) {

                    String[] champs = ligne.split("," );

                    // Tester si la longueur de la chaine est égale a 5
                    GestionChampsVides.compterChampsAttendus(champs,numeroDeLigne);
                    gestionnaireChampsVide.gererChampVide(champs,numeroDeLigne);

                    InterventionPoliciere unObjetInterventionPoliciere = InterventionPoliciere
                            .creerInstanceInterventionPoliciere (champs[0], champs[1], champs[2],
                                    champs[3], champs[4]);

                    interventions.add( unObjetInterventionPoliciere );
                    GestionDateIntervention.gererDateHorsLimite(nomFichier, numeroDeLigne, unObjetInterventionPoliciere
                            .getDate());
                    GestionHeureIntervention.gererErreurFormatHeure (nomFichier, numeroDeLigne, unObjetInterventionPoliciere
                            .getHeure());
                }
                numeroDeLigne++;
            }
        } catch( IOException ex ) {
            throw new RuntimeException(TraducteurSingleton.getInstance().traduire("erreurLectureFichier", cheminFichier) );
        }
        return interventions;
    }


}
