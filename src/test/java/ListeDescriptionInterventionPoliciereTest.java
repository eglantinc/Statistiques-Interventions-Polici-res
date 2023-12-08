import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListeDescriptionInterventionPoliciereTest {
    @Test
    public void remplirListeDescriptionInterventionPoliciereTest() {
        // On crée une instance de classe

        ArrayList<InterventionPoliciere> interventions = new ArrayList<>();
        interventions.add(new InterventionPoliciere("2023-08-26", "23:11", "Parc Brook", "Pierrefonds-Roxboro", "Vente de drogues"));
        interventions.add(new InterventionPoliciere("2023-09-12","13:11","Parc Carignan","Lachine","Bagarre"));

        // on appele la méthode qui ajoute des éléments à l'objet InterventionsPolicieres
        ArrayList<String> liste = ListeDescriptionInterventionPoliciere.remplirListeInterventionsPolicieres(interventions);

        // On utilise des assertions pour vérifier le contenu
        assertEquals(2, liste.size());
    }

    @Test
    public void remplirListeDescriptionInterventionPoliciereTest2() {
        // On crée une liste d'objets InterventionPoliciere incluant nos données

        ArrayList<InterventionPoliciere> interventions = new ArrayList<>();
        interventions.add(new InterventionPoliciere("2020-11-12", "14:30", "Parc Henri-Bourassa", "Montréal-Nord", "Bagarre"));
        interventions.add(new InterventionPoliciere("2022-11-13", "16:45", "Parc Poirier ", "Verdun", "Port d'arme prohibée"));
        interventions.add(new InterventionPoliciere("2021-11-14", "12:00", "Parc René-Lévesque", "Lachine", "Vente de drogues"));

        ArrayList<String> resultat = ListeDescriptionInterventionPoliciere.remplirListeInterventionsPolicieres(interventions);

        // Vérification du résultat
        ArrayList<String> attendu = new ArrayList<>();
        attendu.add("Bagarre");
        attendu.add("Port d'arme prohibée");
        attendu.add("Vente de drogues");

        assertEquals(attendu, resultat);
    }

    @Test
    public void remplirListeDescriptionInterventionPoliciereTest3() {
        // On crée une liste d'objets InterventionPoliciere incluant nos données

        ArrayList<InterventionPoliciere> interventions = new ArrayList<>();
        interventions.add(new InterventionPoliciere("2020-11-12", "14:30", "Parc Henri-Bourassa", "Montréal-Nord", "Bagarre"));
        interventions.add(new InterventionPoliciere("2022-11-13", "16:45", "Parc Poirier ", "Verdun", "Port d'arme prohibée"));
        interventions.add(new InterventionPoliciere("2021-11-14", "12:00", "Parc René-Lévesque", "Lachine", "Vente de drogues"));
        interventions.add(new InterventionPoliciere("2021-11-14", "12:00", "Parc René-Lévesque", "Lachine", "Vente de drogues"));
        ArrayList<String> resultat = ListeDescriptionInterventionPoliciere.remplirListeInterventionsPolicieres(interventions);

        // Vérification du résultat
        ArrayList<String> attendu = new ArrayList<>();
        attendu.add("Bagarre");
        attendu.add("Port d'arme prohibée");
        attendu.add("Vente de drogues");

        // Devrait ne pas avoir de duplications
        assertEquals(attendu, resultat);
    }


}
