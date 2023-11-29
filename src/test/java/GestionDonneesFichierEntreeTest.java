import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GestionDonneesFichierEntreeTest {
    @Test
    public void gererErreurArrondissementTest() {
        ArrayList<String> arrondissements = new ArrayList<>();
        arrondissements.add( "Ahuntsic-Cartierville" );
        arrondissements.add( "LaSalle" );
        // New York n'est pas un arrondissement de Montreal.
        arrondissements.add( "New York" );
        Throwable exception = assertThrows(InformationInvalideDansLeFichierEntree.class,
                () -> GestionDonneesAvecFichierJson.gererArrondissementsDeMontrealInvalides(arrondissements) );
    }

    @Test
    public void gererErreurArrondissementTest2() {
        ArrayList<String> arrondissements = new ArrayList<>();
        // Erreur en raison de la casse.
        arrondissements.add( "ahuntsic-Cartierville" );
        arrondissements.add( "LaSalle" );
        Throwable exception = assertThrows(InformationInvalideDansLeFichierEntree.class,
                () -> GestionDonneesAvecFichierJson.gererArrondissementsDeMontrealInvalides(arrondissements) );
    }

    @Test
    public void gererErreurArrondissementTest3() {
        ArrayList<String> arrondissements = new ArrayList<>();
        // Erreur en raison d'un espace superflu.
        arrondissements.add( "Ahuntsic-Cartierville " );
        arrondissements.add( "LaSalle" );
        Throwable exception = assertThrows(InformationInvalideDansLeFichierEntree.class,
                () -> GestionDonneesAvecFichierJson.gererArrondissementsDeMontrealInvalides(arrondissements) );
    }

    @Test
    public void gererErreurArrondissementTest4() {
        ArrayList<String> arrondissements = new ArrayList<>();
        // Erreur en raison d'un caractère spécial manquant.
        arrondissements.add( "Montreal-Nord" );
        arrondissements.add( "LaSalle" );
        Throwable exception = assertThrows(InformationInvalideDansLeFichierEntree.class,
                () -> GestionDonneesAvecFichierJson.gererArrondissementsDeMontrealInvalides(arrondissements) );
    }

    @Test
    public void gererErreurArrondissementTest5() {
        ArrayList<String> arrondissements = new ArrayList<>();
        // Erreur en raison d'un caractère spécial manquant.
        arrondissements.add( "Montréal Nord" );
        arrondissements.add( "LaSalle" );
        Throwable exception = assertThrows(InformationInvalideDansLeFichierEntree.class,
                () -> GestionDonneesAvecFichierJson.gererArrondissementsDeMontrealInvalides(arrondissements) );
    }

    @Test
    public void gererInterventionsInvalidesTest() {
        ArrayList<String> interventionsPolicieres = new ArrayList<>();
        interventionsPolicieres.add( "Vente de drogues" );
        interventionsPolicieres.add( "Bagarre" );
        // Meurtre n'est pas une intervention valide.
        interventionsPolicieres.add( "Meurtre" );
        Throwable exception = assertThrows(InformationInvalideDansLeFichierEntree.class,
                () -> GestionDonneesAvecFichierJson.
                        gererDescriptionInterventionsInvalides(interventionsPolicieres) );
    }


    @Test
    public void gererInterventionsInvalidesTest2() {
        ArrayList<String> interventionsPolicieres = new ArrayList<>();
        interventionsPolicieres.add( "Vente de drogues" );
        // Erreur en raison de la casse.
        interventionsPolicieres.add( "bagarre" );
        Throwable exception = assertThrows(InformationInvalideDansLeFichierEntree.class,
                () -> GestionDonneesAvecFichierJson
                        .gererDescriptionInterventionsInvalides(interventionsPolicieres) );
    }

    @Test
    public void gererInterventionsInvalidesTest3() {
        ArrayList<String> interventionsPolicieres = new ArrayList<>();
        // Erreur en raison d'un espace superflu.
        interventionsPolicieres.add( "Vente de drogues " );
        interventionsPolicieres.add( "Bagarre" );
        Throwable exception = assertThrows(InformationInvalideDansLeFichierEntree.class,
                () -> GestionDonneesAvecFichierJson
                        .gererDescriptionInterventionsInvalides(interventionsPolicieres) );
    }

    @Test
    public void gererInterventionsInvalidesTest4() {
        ArrayList<String> interventionsPolicieres = new ArrayList<>();
        // Erreur en raison d'un caractère spécial manquant.
        interventionsPolicieres.add( "Manifestation illegale" );
        interventionsPolicieres.add( "Bagarre" );
        Throwable exception = assertThrows(InformationInvalideDansLeFichierEntree.class,
                () -> GestionDonneesAvecFichierJson
                        .gererDescriptionInterventionsInvalides(interventionsPolicieres) );
    }

    @Test
    public void gererInterventionsInvalidesTest5() {
        ArrayList<String> interventionsPolicieres = new ArrayList<>();
        // Erreur en raison d'un caractère spécial manquant.
        interventionsPolicieres.add( "Possession consommation de stupéfiant" );
        interventionsPolicieres.add( "Bagarre" );
        Throwable exception = assertThrows(InformationInvalideDansLeFichierEntree.class,
                () -> GestionDonneesAvecFichierJson
                        .gererDescriptionInterventionsInvalides(interventionsPolicieres) );
    }

}
