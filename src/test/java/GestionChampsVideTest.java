import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

public class GestionChampsVideTest {
    private Traducteur traducteur;

    @BeforeEach
    void setUp() {
        traducteur = TraducteurSingleton.getInstance();
        traducteur.setLangueEnCours(Traducteur.FRANCAIS);
    }

    @Test
    public void GestionChampsVideTest1(){
        String[] colonnes ={"2020-11-12", "Parc Henri-Bourassa", "Montréal-Nord", "Bagarre"};

        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> GestionChampsVides.compterChampsAttendus(colonnes,2));
    }

    @Test
    public void GestionChampsVideTest2(){
        String[] colonnes ={"2020-11-12", "20:20", "Parc Henri-Bourassa", "Bagarre"};
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> GestionChampsVides.compterChampsAttendus(colonnes,2));


    }

    @Test
    public void GestionChampVideTest2() {
        String [] premiereLigne = {"Date", "Heure", "Parc", "Arrondissement", "Description"};
        GestionChampsVides gestionChampsVides = new GestionChampsVides("test1.csv", premiereLigne);
        String[] colonnes ={"2020-11-12", "20:20", "Parc Henri-Bourassa", "", "Bagarre"};
        assertThrows(ChampVideDansFichierEntree.class, () -> gestionChampsVides.gererChampVide(colonnes, 1));

    }
}
