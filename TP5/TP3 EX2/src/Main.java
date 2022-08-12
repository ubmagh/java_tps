import com.sun.source.doctree.SeeTree;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        int choice=0, listChoice=0;
        Scanner input = new Scanner(System.in);
        DossierContact dc = new DossierContact();
        String nom, num;
        List<String> results;
        String[] keys;

        while(true){
            System.out.print("\n\n\n\t ########################### Menu Dossier Contact #########################");
            System.out.print("\n\t 1- Rechercher un numéro de téléphone .");
            System.out.print("\n\t 2- Ajouter un nouveau contact.");
            System.out.print("\n\t 3- Supprimer un contact. ");
            System.out.print("\n\t 4- Changer le numéro de téléphone d’un contact.");
            System.out.print("\n\t 5- Quitter ce programme.");
            do {
                System.out.print("\n\n\t   [i] votre choix =-> ");
                choice = input.nextInt();
                input.nextLine();
            }while(choice<1||choice>5);
            switch( choice ){
                case 1:
                    System.out.print("\n\n\t +++++++++++++++++++++++++ Rechercher un contact +++++++++++++++++++++++++++");
                    nom="";
                    do {
                        System.out.print("\n\t [i]> Entrez le nom à rechercher : ");
                        nom = input.nextLine();
                    }while( nom.length()==0 );
                    results = dc.ChercherContactParNom( nom );
                    if( results.size() ==0 )
                        System.out.print("\n\t [i]> ❌ Aucun résultat n'a été trouvé !");
                    else {
                        System.out.print("\n\t [i]> Resultats de la recherche : \n");

                        System.out.printf("\n\t\t    %20s  :  %10s ", "# contact","# numéro de tel");
                        for ( String key : results ){
                            System.out.printf("\n\t\t --> %20s : %10s", key, dc.getContactNum(key) );
                        }
                    }
                    break;
                case 2:
                    System.out.print("\n\n\t +++++++++++++++++++++++++ Ajouter un contact +++++++++++++++++++++++++++");
                    nom="";
                    num="";
                    do {
                        System.out.print("\n\t\t [i]> Entrez le nom : ");
                        nom = input.nextLine();
                    }while( nom.length()==0 );
                    do {
                        System.out.print("\n\t\t [i]> Entrez le numéro de tel : ");
                        num = input.nextLine();
                    }while (num.length()==0);
                    if( dc.AjouterContact( nom, num) )
                        System.out.print("\n\t [i]> ✅ Contact ajouté avec succès !");
                    else
                        System.out.print("\n\t [i]> ❌ Contact n'est pas ajouté  !");
                    break;
                case 3:
                    System.out.print("\n\n\t ----------------------------- Supprimer un contact ------------------------------------");

                    keys = dc.getKeys().toArray(new String[0]);

                    for(int i=0; i<keys.length; i++){
                        System.out.printf("\n\t\t %2d --> %20s  :  %10s", i+1, keys[i], dc.getContactNum(keys[i]) );
                    }
                    listChoice=0;
                    do {
                        System.out.print("\n\t [i]> Choisissez le contact à supprimer : ");
                        listChoice = input.nextInt();
                        input.nextLine();
                    }while(listChoice<1 || listChoice>keys.length);
                    if( dc.SupprimerContact( keys[listChoice-1] ) )
                        System.out.print("\n\t [i]> ✅ Contact supprimé avec succès .");
                    else
                        System.out.print("\n\t [i]> ❌ Contact n'a pas été supprimé .");
                    break;
                case 4:
                    System.out.print("\n\n\t################################ Changer le numéro d'un contact #################################");

                    keys = dc.getKeys().toArray(new String[0]);

                    for(int i=0; i<keys.length; i++){
                        System.out.printf("\n\t\t %2d --> %20s  :  %10s", i+1, keys[i], dc.getContactNum(keys[i]) );
                    }
                    listChoice=0;
                    do {
                        System.out.print("\n\t [i]> Choisissez le contact pour changer son numéro : ");
                        listChoice = input.nextInt();
                        input.nextLine();
                    }while(listChoice<1 || listChoice>keys.length);
                    num = "";
                    do {
                        System.out.print("\n\t ");
                        num = input.nextLine();
                    }while(num.length()==0);
                    if( dc.ChangerNumero( keys[listChoice-1], num) )
                        System.out.print("\n\t [i]> ✅ Contact mis-à-jour avec succès .");
                    else
                        System.out.print("\n\t [i]> ❌ Le numéro de contact n'a pas été changé .");
                    break;
                default :
                    System.out.print("\n\n\n\t\t ]-) A bienToT ! \n\n");
                    return;
            }
        }

    }
}
