import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class InterventionsPolicieresWriter {

    /**
     * Cette méthode sert à produire un fichier de sortie où qu'il y aura une nouvelle statistique sur le nombre de
     * parcs par arrondissements où il y a eu des interventions policières.
     *
     * @param fichierSortie Le chemin du fichier de sortie dans lequel on va produire la nouvelle statistique.
     * @param ligneSaisie La ligne de texte à écrire dans le fichier de sortie.
     */
    public static void ecrireFichierSortie(String fichierSortie, String ligneSaisie) {
        try (FileWriter fichierEcriture = new FileWriter(fichierSortie, true);
             BufferedWriter tamponEcriture = new BufferedWriter(fichierEcriture)) {

            tamponEcriture.write(ligneSaisie);
            tamponEcriture.newLine();

        } catch (IOException e) {
            throw new RuntimeException(TraducteurSingleton.getInstance()
                    .traduire("erreurEcritureDansFichier", fichierSortie), e);
        }
    }
}
