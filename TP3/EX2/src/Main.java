import Entities.*;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        ArrayList<Ordinateur> ordinateurs = new ArrayList<Ordinateur>();
        ordinateurs.add( new Ordinateur( "Precision M6700", "DELL", 5600f, "DEll workstation laptop", 5) );
        ordinateurs.add( new Ordinateur( "Precision XPS", "DELL", 8800f, "DEll powerfull laptop", 2) );
        ordinateurs.add( new Ordinateur( "Omen", "HP", 8000f, "HP gaming laptop", 7) );

        Categorie categorie = new Categorie( "PC PORTABLES", "categorie des pc portables", ordinateurs);

        Client client = new Client( "Ayoub", "Maghdaoui", "ubmagh@gmail.com", "Mohammedia", "Hay nahda", "0696625030");

        Commande commande = new Commande( "REF0001", "Commande avec Ref : REF0001", new Date(), client );


        ArrayList<LigneCommande> lignescommande = new ArrayList<LigneCommande>();
        lignescommande.add( new LigneCommande( 2, commande, ordinateurs.get(0)) );
        lignescommande.add( new LigneCommande( 1, commande, ordinateurs.get(1)) );
        lignescommande.add( new LigneCommande( 3, commande, ordinateurs.get(2)) );

        System.out.printf("\n\n\t Affichage de la commande: \n");

        System.out.printf( commande + "\n\n\t Ordinateurs de cette commande : \n" + lignescommande+"\n");

    }

}
