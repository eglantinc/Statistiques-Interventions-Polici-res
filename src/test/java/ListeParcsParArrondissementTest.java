import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;

public class ListeParcsParArrondissementTest {

    public void testListeParcParArrondissement() {
        ListeParcsParArrondissement listeParcsParArrondissementMock = Mockito.mock(ListeParcsParArrondissement.class);

        InterventionPoliciere interventionPoliciere = new InterventionPoliciere("2023-02-15", "11:23", "Parc des Roseraies", "Anjou", "Possession / consommation de stupéfiant");
        ArrayList<InterventionPoliciere> interventionPoliciereArrayList = new ArrayList<>();
        ArrayList<String> listeArrondissement = new ArrayList<>();

        // TODO: Dois-je faire des mock object pour tout?

        // InterventionPoliciere interventionPoliciereMock = Mockito.mock(InterventionPoliciere.class);
//
//        String arrondissement = "Anjou";
//        String parc = "Parc des Roseraies";
//        String date = "2023-02-15";
//        String heure = "11:23";
//        String description = "Possession / consommation de stupéfiant";
//
//        Mockito.when(interventionPoliciereMock.getArrondissement()).thenReturn(arrondissement);
//        Mockito.when(interventionPoliciereMock.getParc()).thenReturn(parc);
//        Mockito.when(interventionPoliciereMock.getDate()).thenReturn(date);
//        Mockito.when(interventionPoliciereMock.getHeure()).thenReturn(heure);
//        Mockito.when(interventionPoliciereMock.getDescription()).thenReturn(description);
//
//        Mockito.when(interventionPoliciereMock.toString()).thenReturn(
//                "InterventionPoliciere[arrondissement=" + arrondissementValue +
//                        ", parc=" + parcValue +
//                        ", date=" + dateValue +
//                        ", heure=" + heureValue +
//                        ", description=" + descriptionValue + "]"
//        );
    }
}
