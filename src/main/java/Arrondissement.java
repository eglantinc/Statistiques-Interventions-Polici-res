import java.util.ArrayList;


/**
 * La classe Arrondissement représente les caractéristiques essentielles d'un arrondissement.
 *
 * @Author: Eglantine Clervil, Minh Ha, Farah Bouaiche, Kamdem Suzanne
 * @Courriel: clervil.eglantine_anne@courrier.uqam.ca, ha.le_minh@courrier.uqam.ca,
 * bouaiche.farah@courrier.uqam.ca, kamdem_pouomogne.suzanne_leocadie@courrier.uqam.ca
 * @Code-permanent: CLEE89530109, HAXL19089505, BOUF06379700, KAMS17628009
 * @Groupe: 30
 */
    public class Arrondissement {

        /**
         * Ces champs de classes représentent les caractéristiques essentielles d'un arrondissement :
         * - 'arrondissement' : L'arrondissement où s'est déroulé l'intervention.
         * - 'listeInfractions' : La liste des interventions qu'il y a eux lieux.
         * - 'listeDeParcs' : La liste des parcs où qu'il y a eu une intervention.
         */
        private String arrondissement;
        private ArrayList<String> listeInfractions;
        private ArrayList<String> listeDeParcs;

        /**
         * Constructeur de la classe Arrondissement qui prend 3 paramètres pour initialiser les propriétés de l'objet.
         *
         * @param arrondissement        L'arrondissement où s'est déroulé l'intervention.
         * @param listeDeParcs          La liste des parcs où qu'il y a eu une intervention.
         * @param listeInfractions      La liste des interventions qu'il y a eux lieu.
         */
        public Arrondissement( String arrondissement, ArrayList<String> listeDeParcs, ArrayList<String>
                listeInfractions ) {

            this.arrondissement = arrondissement;
            this.listeDeParcs = listeDeParcs;
            this.listeInfractions = listeInfractions;
        }

        /**
         * Récupère le nom de l'arrondissement.
         *
         * @return Le nom de l'arrondissement.
         */
        public String getNomArrondissement() {

            return arrondissement;
        }

        /**
         * Récupère la liste des infractions qu'il y a eux lieu.
         *
         * @return La liste des infractions qu'il y a eux lieu.
         */
        public ArrayList<String> getListeInfractions() {

            return listeInfractions;
        }

        /**
         * Récupère la liste de parcs où qu'il y a eu une intervention.
         *
         * @return La liste de parc où qu'il y a eu une intervention.
         */
        public ArrayList<String> getListeDeParcs() {

            return listeDeParcs;
        }

    }


