import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class ListeInterventionsPolicieresTest {
    private Traducteur traducteur;

    @BeforeEach
    void setUp() {
        traducteur = TraducteurSingleton.getInstance();
        traducteur.setLangueEnCours(Traducteur.FRANCAIS);
    }
    @Test
    public void ListeInterventionsPolicieresTest1() {
        // On créé une instance de classe

        ArrayList<InterventionPoliciere> interventions = new ArrayList<>();
        interventions.add(new InterventionPoliciere("2023-08-26", "23:11", "Parc Brook", "Pierrefonds-Roxboro", "Vente de drogues"));
        interventions.add(new InterventionPoliciere("2023-09-12","13:11","Parc Carignan","Lachine","Bagarre"));

        // on appele la méthode qui ajoute des éléments à l'objet InterventionsPolicieres
        ArrayList<String> liste = ListeDescriptionInterventionPoliciere.remplirListeInterventionsPolicieres(interventions);

        // On utilise des assertions pour vérifier le contenu
        assertEquals(2, liste.size());
        assertTrue(liste.contains("Vente de drogues"));
        assertTrue(liste.contains("Bagarre"));
    }
    @Test
    public void ListeInterventionsPolicieresTest2() {
        // On crée une liste d'objets InterventionPoliciere incluant nos données

        ArrayList<InterventionPoliciere> interventions = new ArrayList<>();
        interventions.add(new InterventionPoliciere("2020-11-12", "14:30", "Parc Henri-Bourassa", "Montréal-Nord", "Bagarre"));
        interventions.add(new InterventionPoliciere("2022-11-13", "16:45", "Parc Poirier ", "Verdun", "Port d'arme prohibée"));
        interventions.add(new InterventionPoliciere("2021-11-14", "12:00", "Parc René-Lévesque", "Lachine", "Vente de drogues"));

        ArrayList<String> resultat = ListeDescriptionInterventionPoliciere.remplirListeInterventionsPolicieres(interventions);

        // Vérification du résultat
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("Bagarre","Port d'arme prohibée","Vente de drogues"));
        // On trie la liste attendue
        Collections.sort(expected);
        // On trie le resultat qu'on a eu
        Collections.sort(resultat);
        assertEquals(expected, resultat);
    }

    @Test
    public void ListeInterventionsPolicieresTest3(){
        // On crée une liste d'objets InterventionPoliciere incluant nos données

        ArrayList<InterventionPoliciere> interventions = new ArrayList<>();
        interventions.add(new InterventionPoliciere("2020-11-12", "14:30", "Parc Henri-Bourassa", "Montréal-Nord", "Bagarre"));
        interventions.add(new InterventionPoliciere("2022-11-13", "16:45", "Parc Poirier ", "Verdun", "Bagarre"));
        interventions.add(new InterventionPoliciere("2021-11-14", "12:00", "Parc Parc René-Lévesque", "Lachine", "Bagarre"));


        /** On fait appel à la méthode à tester: remplirListeInterventionsPolicieres
         ** On stock le resultat dans une variable
         **/
        ArrayList<String> resultat1 = ListeDescriptionInterventionPoliciere.remplirListeInterventionsPolicieres(interventions);

        // Vérification du résultat
        ArrayList<String> attendu = new ArrayList<>();
        attendu.add("Bagarre");


        assertEquals(attendu, resultat1);
        assertEquals(1, resultat1.size());
    }

    @Test
    public void ListeInterventionsPolicieresTest4(){
        // On teste si la taille de la liste

        ArrayList<InterventionPoliciere> interventions = new ArrayList<>();
        interventions.add(new InterventionPoliciere("2020-11-12", "14:30", "Parc Henri-Bourassa", "Montréal-Nord", "Bagarre"));
        interventions.add(new InterventionPoliciere("2022-11-13", "16:45", "Parc Poirier ", "Verdun", "Bagarre"));
        interventions.add(new InterventionPoliciere("2021-11-14", "12:00", "Parc Parc René-Lévesque", "Lachine", "Bagarre"));


        /** On fait appel à la méthode à tester: remplirListeInterventionsPolicieres
         ** On stock le resultat dans une variable
         **/
        ArrayList<String> resultat1 = ListeDescriptionInterventionPoliciere.remplirListeInterventionsPolicieres(interventions);

        // Vérification du résultat
        ArrayList<String> attendu = new ArrayList<>();
        attendu.add("Bagarre");
        attendu.add("Vol à main armée");

        assertNotEquals(attendu, resultat1);
        assertNotEquals(2, resultat1.size());
    }
}
