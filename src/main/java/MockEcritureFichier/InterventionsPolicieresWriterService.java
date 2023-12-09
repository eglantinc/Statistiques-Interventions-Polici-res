package MockEcritureFichier;

import java.io.IOException;

public interface InterventionsPolicieresWriterService {
    void ecrireDansFichierSortie(String nomFichier, String contenu) throws IOException;
}