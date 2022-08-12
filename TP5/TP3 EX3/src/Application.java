import Classes.MetierProduitImpl;
import Entities.Produit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Application {

    public static void main(String[] args) {


        String searchStr="", nom="", marque="", desc="";
        int qte=0;
        float prix=0f;
        Scanner input = new Scanner(System.in);
        Produit searchedProduit;
        int nbrChoice;
        String charChoice;
        MetierProduitImpl produitObj = new MetierProduitImpl("produits.dat");


        while(true){
            System.out.print("\n\n\n\t #####################  Menu : Gestion des produits  #########################");
            System.out.print("\n\t  1--> Afficher la liste des produits. ");
            System.out.print("\n\t  2--> Rechercher un produit par son nom. ");
            System.out.print("\n\t  3--> Ajouter un nouveau produit. ");
            System.out.print("\n\t  4--> Supprimer un produit. ");
            System.out.print("\n\t  5--> Sauvegarder les produits . ");
            System.out.print("\n\t  6--> Charger les produits sauvgardés. ");
            System.out.print("\n\t  7--> Quitter. ");

            do{
                System.out.print("\n\t\t [i]> Votre choix : ");
                nbrChoice = input.nextInt();
                input.nextLine();
            }while( nbrChoice<1 || nbrChoice>7);

            switch(nbrChoice){
                case 1:
                    System.out.print("\n\n\t **************************  Afficher tous les produits  **************************");
                    if( produitObj.getAll().size()==0 ) System.out.print("\n\t [i]> ❌ Aucun produit dans la liste");
                    for( Produit p: produitObj.getAll() ){
                        System.out.print("\n\t -> "+p);
                    }
                    break;
                case 2:
                    System.out.print("\n\n\t ////////////////////  Rechercher un produit par son nom  ////////////////////");
                    do{
                        System.out.print("\n\t\t [i] entrez le nom à rechercher : ");
                        searchStr = input.nextLine();
                    }while( searchStr.length()==0 );
                    searchedProduit = produitObj.findByNom(searchStr);
                    if( searchedProduit!=null )
                        System.out.print("\n\t [i]> Résultats trouvés: \n "+searchedProduit);
                    else
                        System.out.print("\n\t [i]> Aucun résultat n'a été trouvé ");
                    break;
                case 3:
                    System.out.print("\n\n\t +++++++++++++++++++++++++++  Ajouter un nouveau produit  +++++++++++++++++++++++++++");
                    do{
                        System.out.print("\n\t [i]> saisir le nom du produit : ");
                        nom = input.nextLine();
                    }while(nom.length()==0);

                    do{
                        System.out.print("\n\t [i]> saisir la marque du produit : ");
                        marque = input.nextLine();
                    }while(marque.length()==0);

                    do{
                        System.out.print("\n\t [i]> saisir la description du produit : ");
                        desc = input.nextLine();
                    }while(desc.length()==0);

                    do{
                        System.out.print("\n\t [i]> saisir la quantité en stock du produit : ");
                        qte = input.nextInt();
                        input.nextLine();
                    } while(qte<1);

                    do{
                        System.out.print("\n\t [i]> saisir le prix du produit (f): ");
                        prix = input.nextFloat();
                    } while(prix<1f);

                    produitObj.add( new Produit( nom, marque, prix, desc, qte));
                    System.out.print("\n\t [i]> ✅ Produit est créé avec succès !");
                    break;
                case 4:
                    System.out.print("\n\n\t ----------------------------- Supprimer un produit ---------------------------");
                    do{
                        System.out.print("\n\t\t [i] entrez le nom du produit à supprimer : ");
                        searchStr = input.nextLine();
                    }while( searchStr.length()==0 );
                    searchedProduit = produitObj.findByNom(searchStr);
                    if( searchedProduit!=null ) {
                        System.out.print("\n\t [i]> Résultats trouvés: \n " + searchedProduit);
                    }
                    else{
                        System.out.print("\n\t [i]> Aucun résultat n'a été trouvé ");
                        continue;
                    }
                    do{
                        System.out.print("\n\n\t [i] Voulez-vraiment le supprimer (Y/[N]) : ");
                        charChoice = input.nextLine();
                    }while( charChoice.length()>1 );
                    if(charChoice.toLowerCase().trim().equals("y")) {
                        produitObj.delete(searchedProduit.getNom());
                        System.out.print("\n\t  ✅ Produit supprimé");
                    }
                    break;
                case 5:
                    System.out.print("\n\n\t .........................  Sauvegarder tous les produits  .........................");
                    produitObj.saveAll();
                    System.out.print("\n\t\t ✅ done !");
                    break;
                case 6:
                    System.out.print("\n\n\t ⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆ Charger les produits sauvegardés ⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆");
                    produitObj.loadAll();
                    break;
                default:
                    System.out.print("\n\n\n\t\t ]-) A bienToT ! \n\n");
                    return;
            }
        }
    }

}
