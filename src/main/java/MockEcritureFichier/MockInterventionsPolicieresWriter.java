package MockEcritureFichier;

public class MockInterventionsPolicieresWriter implements InterventionsPolicieresWriterService {
    public String fichierSortie;
    public String ligneSaisie;

    @Override
    public void ecrireDansFichierSortie(String nomFichier, String contenu) {
        this.fichierSortie = nomFichier;
        this.ligneSaisie = contenu;
    }
    }

