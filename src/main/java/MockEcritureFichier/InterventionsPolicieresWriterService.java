/**
 * L'interface {@code InterventionsPolicieresWriterService} définit la méthode pour écrire dans un fichier de sortie.
 * Cette interface doit être implémentée par des services qui fournissent des fonctionnalités
 * d'écriture dans un fichier pour les interventions policières
 *
 * @Author: Eglantine Clervil
 * @Courriel: clervil.eglantine_anne@courrier.uqam.ca
 * @Code-permanent: CLEE89530109
 * @Groupe: 30
 *
 */
package MockEcritureFichier;

import java.io.IOException;

public interface InterventionsPolicieresWriterService {

    /**
     * Écrit le contenu spécifié dans le fichier de sortie avec le nom spécifié.
     *
     * @param nomFichier le nom du fichier de sortie dans lequel écrire
     * @param contenu le contenu à écrire dans le fichier
     * @throws IOException si une erreur d'entrée/sortie survient lors de l'écriture dans le fichier
     */
    void ecrireDansFichierSortie(String nomFichier, String contenu) throws IOException;
}
