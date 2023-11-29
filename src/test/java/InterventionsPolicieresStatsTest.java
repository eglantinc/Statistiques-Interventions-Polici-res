import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class InterventionsPolicieresStatsTest {

        @Test
        public void testCalculerNombreInterventions() {
            ArrayList<String> listeParcs = new ArrayList<>();
            listeParcs.add( "Parc Camille" );
            listeParcs.add( "Parc de la Merci" );
            listeParcs.add( "Parc Prieur" );

            ArrayList<String> listeInterventions = new ArrayList<>();
            listeInterventions.add( "Vente de drogues" );
            listeInterventions.add( "Bagarre" );
            listeInterventions.add( "Manifestation illégale" );

            Arrondissement arrondissement = new Arrondissement("Ahuntsic-Cartierville",
                    listeParcs, listeInterventions);

            Assertions.assertEquals(
                    3,
                    InterventionsPolicieresStats.calculerNombreInterventions(arrondissement));
        }

    @Test
    public void testCalculerNombreInterventions1() {
        ArrayList<String> listeParcs = new ArrayList<>();
        listeParcs.add( "Parc Camille" );
        listeParcs.add( "Parc de la Merci" );
        listeParcs.add( "Parc Prieur" );

        ArrayList<String> listeInterventions = new ArrayList<>();

        Arrondissement arrondissement = new Arrondissement("Ahuntsic-Cartierville",
                listeParcs, listeInterventions);

        Assertions.assertEquals(
                0,
                InterventionsPolicieresStats.calculerNombreInterventions(arrondissement));
    }

        @Test
         public void testCalculerNombreParcs() {
            ArrayList<String> listeParcs = new ArrayList<>();
            listeParcs.add( "Parc Camille" );
            listeParcs.add( "Parc de la Merci" );

            ArrayList<String> listeInterventions = new ArrayList<>();
            listeInterventions.add( "Vente de drogues" );
            listeInterventions.add( "Bagarre" );
            listeInterventions.add( "Manifestation illégale" );

            Arrondissement arrondissement = new Arrondissement("Ahuntsic-Cartierville",
                    listeParcs, listeInterventions);

            Assertions.assertEquals(
                    2,
                    InterventionsPolicieresStats.calculerNombreParcs(arrondissement));
    }

    // Nombre de parcs = 0;
    @Test
    public void testCalculerNombreParcs1(){
        ArrayList<String> listeParcs = new ArrayList<>();

        ArrayList<String> listeInterventions = new ArrayList<>();
        listeInterventions.add( "Vente de drogues" );
        listeInterventions.add( "Bagarre" );
        listeInterventions.add( "Manifestation illégale" );

        Arrondissement arrondissement = new Arrondissement("Ahuntsic-Cartierville",
                listeParcs, listeInterventions);

        Assertions.assertEquals(
                0,
                InterventionsPolicieresStats.calculerNombreParcs(arrondissement));
    }


}
