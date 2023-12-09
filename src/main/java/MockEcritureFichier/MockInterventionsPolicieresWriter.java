package MockEcritureFichier;

/**
 * La classe MockInterventionsPolicieresWriter est une implémentation de
 * InterventionsPolicieresWriterService utilisée à des fins de test. Elle enregistre
 * les paramètres passés à la méthode ecrireDansFichierSortie pour permettre la vérification
 * des appels lors des tests unitaires.
 *
 * @Author: Eglantine Clervil
 * @Courriel: clervil.eglantine_anne@courrier.uqam.ca
 * @Code-permanent: CLEE89530109
 * @Groupe: 30
 */
public class MockInterventionsPolicieresWriter implements InterventionsPolicieresWriterService {

    /**
     * Le nom du fichier de sortie enregistré lors de l'appel à ecrireDansFichierSortie.
     */
    public String fichierSortie;

    /**
     * La ligne de saisie enregistrée lors de l'appel à ecrireDansFichierSortie.
     */
    public String ligneSaisie;

    /**
     * Enregistre le nom du fichier de sortie et la ligne de saisie lors de l'appel à cette méthode.
     *
     * @param nomFichier Le nom du fichier de sortie dans lequel écrire.
     * @param contenu    Le contenu à écrire dans le fichier.
     */
    @Override
    public void ecrireDansFichierSortie(String nomFichier, String contenu) {
        this.fichierSortie = nomFichier;
        this.ligneSaisie = contenu;
    }
}
