import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ListeArrondissementsInterventionsPolicieresTest {
    @Test
    public void ListeArrondissementsInterventionsPolicieresTest1() {
        // On créé une instance de classe

        ArrayList<InterventionPoliciere> interventions = new ArrayList<>();
        interventions.add(new InterventionPoliciere("2023-08-26", "23:11", "Parc Brook", "Pierrefonds-Roxboro", "Vente de drogues"));
        interventions.add(new InterventionPoliciere("2023-09-12","13:11","Parc Carignan","Lachine","Bagarre"));

        // on appele la méthode qui ajoute des éléments à l'objet InterventionsPolicieres
        ArrayList<String> liste = ListeArrondissementsInterventionsPolicieres.remplirListeArrondissements(interventions);

        // On utilise des assertions pour vérifier le contenu
        assertEquals(2, liste.size());
    }

    @Test
    public void ListeArrondissementsInterventionsPolicieresTest2() {
        // On crée une liste d'objets InterventionPoliciere incluant nos données

        ArrayList<InterventionPoliciere> interventions = new ArrayList<>();
        interventions.add(new InterventionPoliciere("2020-11-12", "14:30", "Parc Henri-Bourassa", "Montréal-Nord", "Bagarre"));
        interventions.add(new InterventionPoliciere("2022-11-13", "16:45", "Parc Poirier ", "Verdun", "Port d'arme prohibée"));
        interventions.add(new InterventionPoliciere("2021-11-14", "12:00", "Parc René-Lévesque", "Lachine", "Vente de drogues"));

        ArrayList<String> resultat = ListeArrondissementsInterventionsPolicieres.remplirListeArrondissements(interventions);

        // Vérification du résultat
        ArrayList<String> attendu = new ArrayList<>(Arrays.asList("Lachine","Montréal-Nord","Verdun"));

        assertEquals(attendu, resultat);
        assertEquals(3, resultat.size());
    }

    @Test
    public void ListeInterventionsPolicieresTest3(){
        // On crée une liste d'objets InterventionPoliciere incluant nos données

        ArrayList<InterventionPoliciere> interventions = new ArrayList<>();
        interventions.add(new InterventionPoliciere("2020-11-12", "14:30", "Parc Henri-Bourassa", "Montréal-Nord", "Consommation d'alcool"));
        interventions.add(new InterventionPoliciere("2022-11-13", "16:45", "Parc Poirier ", "Montréal-Nord", "Bagarre"));
        interventions.add(new InterventionPoliciere("2021-11-14", "12:00", "Parc Parc René-Lévesque", "Lachine", "Vol"));


        ArrayList<String> resultat1 = ListeArrondissementsInterventionsPolicieres.remplirListeArrondissements(interventions);

        // Vérification du résultat
        ArrayList<String> attendu = new ArrayList<>(Arrays.asList("Lachine","Montréal-Nord"));

        assertEquals(attendu, resultat1);
        assertEquals(2, resultat1.size());
    }

    @Test
    public void ListeInterventionsPolicieresTest4(){
        // On teste si la taille de la liste

        ArrayList<InterventionPoliciere> interventions = new ArrayList<>();
        interventions.add(new InterventionPoliciere("2020-11-12", "14:30", "Parc Henri-Bourassa", "Montréal-Nord", "Bagarre"));
        interventions.add(new InterventionPoliciere("2022-11-13", "16:45", "Parc Poirier ", "Montréal-Nord", "Bagarre"));
        interventions.add(new InterventionPoliciere("2021-11-14", "12:00", "Parc Parc René-Lévesque", "Montréal-Nord", "Bagarre"));


       ArrayList<String> resultat1 = ListeArrondissementsInterventionsPolicieres.remplirListeArrondissements(interventions);

        // Vérification du résultat


        assertFalse(resultat1.contains("Ahuntsic-Cartierville"));
        assertTrue(resultat1.contains("Montréal-Nord"));
        assertNotEquals(2,resultat1.size());
    }

    @Test
    public void ListeArrondissementsInterventionsPolicieresTest5() {
        // On créé une instance de classe

        ArrayList<InterventionPoliciere> interventions = new ArrayList<>();
        interventions.add(new InterventionPoliciere("2023-08-26", "23:11", "Parc Brook", "Pierrefonds-Roxboro", "Vente de drogues"));
        interventions.add(new InterventionPoliciere("2023-09-12","13:11","Parc Carignan","Lachine","Bagarre"));

        // on appele la méthode qui ajoute des éléments à l'objet InterventionsPolicieres
        ArrayList<String> liste = ListeArrondissementsInterventionsPolicieres.remplirListeArrondissements(interventions);

        // On utilise des assertions pour vérifier le contenu
        assertTrue(liste.contains("Pierrefonds-Roxboro"));
    }

}



