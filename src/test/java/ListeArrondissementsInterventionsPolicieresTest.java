import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de tests unitaires pour la classe ListeArrondissementsInterventionsPolicieres.
 */
public class ListeArrondissementsInterventionsPolicieresTest {

    /**
     * Teste la méthode remplirListeArrondissements avec des données valides.
     * Ajoute deux interventions policières avec des arrondissements différents.
     * Vérifie que la liste résultante contient deux arrondissements distincts.
     */
    @Test
    public void ListeArrondissementsInterventionsPolicieresTest1() {
        ArrayList<InterventionPoliciere> interventions = new ArrayList<>();
        interventions.add(new InterventionPoliciere("2023-08-26", "23:11", "Parc Brook", "Pierrefonds-Roxboro", "Vente de drogues"));
        interventions.add(new InterventionPoliciere("2023-09-12", "13:11", "Parc Carignan", "Lachine", "Bagarre"));

        ArrayList<String> liste = ListeArrondissementsInterventionsPolicieres.remplirListeArrondissements(interventions);

        assertEquals(2, liste.size());
    }

    /**
     * Teste la méthode remplirListeArrondissements avec une liste d'interventions diverses.
     * Vérifie que la liste résultante contient uniquement les arrondissements uniques des interventions.
     */
    @Test
    public void ListeArrondissementsInterventionsPolicieresTest2() {
        ArrayList<InterventionPoliciere> interventions = new ArrayList<>();
        interventions.add(new InterventionPoliciere("2020-11-12", "14:30", "Parc Henri-Bourassa", "Montréal-Nord", "Bagarre"));
        interventions.add(new InterventionPoliciere("2022-11-13", "16:45", "Parc Poirier", "Verdun", "Port d'arme prohibée"));
        interventions.add(new InterventionPoliciere("2021-11-14", "12:00", "Parc René-Lévesque", "Lachine", "Vente de drogues"));

        ArrayList<String> resultat = ListeArrondissementsInterventionsPolicieres.remplirListeArrondissements(interventions);

        ArrayList<String> attendu = new ArrayList<>(Arrays.asList("Lachine", "Montréal-Nord", "Verdun"));

        assertEquals(attendu, resultat);
    }

    /**
     * Teste la méthode remplirListeArrondissements avec une liste d'interventions variées.
     * Vérifie que la liste résultante contient uniquement les arrondissements uniques des interventions.
     */
    @Test
    public void ListeArrondissementsInterventionsPolicieresTest3() {
        ArrayList<InterventionPoliciere> interventions = new ArrayList<>();
        interventions.add(new InterventionPoliciere("2020-11-12", "14:30", "Parc Henri-Bourassa", "Montréal-Nord", "Consommation d'alcool"));
        interventions.add(new InterventionPoliciere("2022-11-13", "16:45", "Parc Poirier", "Montréal-Nord", "Bagarre"));
        interventions.add(new InterventionPoliciere("2021-11-14", "12:00", "Parc Parc René-Lévesque", "Lachine", "Vol"));

        ArrayList<String> resultat = ListeArrondissementsInterventionsPolicieres.remplirListeArrondissements(interventions);

        ArrayList<String> attendu = new ArrayList<>(Arrays.asList("Lachine", "Montréal-Nord"));

        assertEquals(attendu, resultat);
    }

    /**
     * Teste la méthode remplirListeArrondissements avec une liste d'interventions du même arrondissement.
     * Vérifie que la liste résultante contient uniquement l'arrondissement unique des interventions.
     */
    @Test
    public void ListeArrondissementsInterventionsPolicieresTest4() {
        ArrayList<InterventionPoliciere> interventions = new ArrayList<>();
        interventions.add(new InterventionPoliciere("2020-11-12", "14:30", "Parc Henri-Bourassa", "Montréal-Nord", "Bagarre"));
        interventions.add(new InterventionPoliciere("2022-11-13", "16:45", "Parc Poirier", "Montréal-Nord", "Bagarre"));
        interventions.add(new InterventionPoliciere("2021-11-14", "12:00", "Parc Parc René-Lévesque", "Montréal-Nord", "Bagarre"));

        ArrayList<String> resultat = ListeArrondissementsInterventionsPolicieres.remplirListeArrondissements(interventions);

        assertFalse(resultat.contains("Ahuntsic-Cartierville"));
        assertTrue(resultat.contains("Montréal-Nord"));
        assertNotEquals(2, resultat.size());
    }

    /**
     * Teste la méthode remplirListeArrondissements avec des données valides.
     * Ajoute deux interventions policières avec des arrondissements différents.
     * Vérifie que la liste résultante contient l'arrondissement spécifié.
     */
    @Test
    public void ListeArrondissementsInterventionsPolicieresTest5() {
        ArrayList<InterventionPoliciere> interventions = new ArrayList<>();
        interventions.add(new InterventionPoliciere("2023-08-26", "23:11", "Parc Brook", "Pierrefonds-Roxboro", "Vente de drogues"));
        interventions.add(new InterventionPoliciere("2023-09-12", "13:11", "Parc Carignan", "Lachine", "Bagarre"));

        ArrayList<String> liste = ListeArrondissementsInterventionsPolicieres.remplirListeArrondissements(interventions);

        assertTrue(liste.contains("Pierrefonds-Roxboro"));
    }
}
