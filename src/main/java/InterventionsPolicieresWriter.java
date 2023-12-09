import MockEcritureFichier.InterventionsPolicieresWriterService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * La classe InterventionsPolicieresWriter sert à produire un fichier de sortie contenant une nouvelle statistique sur le
 * nombre de parcs par arrondissements où il y a eu des interventions policières.
 *
 * @Author: Eglantine Clervil, Minh Ha, Farah Bouaiche, Suzanne Kamdem
 * @Courriel: clervil.eglantine_anne@courrier.uqam.ca, ha.le_minh@courrier.uqam.ca, bouaiche.farah@courrier.uqam.ca
 * @Code-permanent: CLEE89530109, HAXL19089505, BOUF06379700, KAMS17628009
 * @Groupe: 30
 */
public class InterventionsPolicieresWriter {

    private InterventionsPolicieresWriterService serviceEcritureFichier;

    public InterventionsPolicieresWriter(InterventionsPolicieresWriterService serviceEcritureFichier) {
        this.serviceEcritureFichier = serviceEcritureFichier;
    }

    public InterventionsPolicieresWriter() {
        this.serviceEcritureFichier = null;
    }

    /**
     * Cette méthode écrit une ligne de texte dans un fichier de sortie pour la nouvelle statistique.
     *
     * @param fichierSortie Le chemin du fichier de sortie dans lequel on va produire la nouvelle statistique.
     * @param ligneSaisie   La ligne de texte à écrire dans le fichier de sortie.
     * @throws RuntimeException Si une erreur survient lors de l'écriture dans le fichier de sortie.
     */
    public void ecrireFichierSortie(String fichierSortie, String ligneSaisie) {
        try (FileWriter fichierEcriture = new FileWriter(fichierSortie, true);
             BufferedWriter tamponEcriture = new BufferedWriter(fichierEcriture)) {

            tamponEcriture.write(ligneSaisie);
            tamponEcriture.newLine();

            gererServiceEcriture(fichierSortie, ligneSaisie);

        } catch (IOException e) {
            throw new RuntimeException(TraducteurSingleton.getInstance()
                    .traduire("erreurEcritureDansFichier", fichierSortie));
        }
    }

    private void gererServiceEcriture(String fichierSortie, String ligneSaisie) throws IOException {
        if (serviceEcritureFichier != null) {
            serviceEcritureFichier.ecrireDansFichierSortie(fichierSortie, ligneSaisie);
        }
    }

}
