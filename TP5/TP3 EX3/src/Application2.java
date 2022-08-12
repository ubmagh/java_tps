import Classes.MetierClientImpl;
import Entities.Client;
import java.util.Scanner;



public class Application2 {

    public static void main(String[] args) {
        String searchStr="", nom="", prenom="", tel="", address="", email="";
        Scanner input = new Scanner(System.in);
        Client searchedClient;
        int nbrChoice;
        String charChoice;
        MetierClientImpl clientsObj = new MetierClientImpl("clients.dat");

        while(true){
            System.out.print("\n\n\n\t #####################  Menu : Gestion des clients #########################");
            System.out.print("\n\t  1--> Afficher la liste des clients. ");
            System.out.print("\n\t  2--> Rechercher un client par son nom. ");
            System.out.print("\n\t  3--> Ajouter un nouveau client. ");
            System.out.print("\n\t  4--> Supprimer un client. ");
            System.out.print("\n\t  5--> Sauvegarder les clients . ");
            System.out.print("\n\t  6--> Charger les clients sauvgardés. ");
            System.out.print("\n\t  7--> Quitter. ");

            do{
                System.out.print("\n\t\t [i]> Votre choix : ");
                nbrChoice = input.nextInt();
                input.nextLine();
            }while( nbrChoice<1 || nbrChoice>7);

            switch(nbrChoice){
                case 1:
                    System.out.print("\n\n\t **************************  Afficher tous les clients  **************************");
                    if( clientsObj.getAll().size()==0 ) System.out.print("\n\t [i]> ❌ Aucun client dans la liste");
                    for( Client p: clientsObj.getAll() ){
                        System.out.print("\n\t -> "+p);
                    }
                    break;
                case 2:
                    System.out.print("\n\n\t ////////////////////  Rechercher un client par son nom  ////////////////////");
                    do{
                        System.out.print("\n\t\t [i] entrez le nom à rechercher : ");
                        searchStr = input.nextLine();
                    }while( searchStr.length()==0 );
                    searchedClient = clientsObj.findByNom(searchStr);
                    if( searchedClient!=null )
                        System.out.print("\n\t [i]> Résultats trouvés: \n "+searchedClient);
                    else
                        System.out.print("\n\t [i]> Aucun résultat n'a été trouvé ");
                    break;
                case 3:
                    System.out.print("\n\n\t +++++++++++++++++++++++++++  Ajouter un nouveau client  +++++++++++++++++++++++++++");
                    do{
                        System.out.print("\n\t [i]> saisir le nom du client : ");
                        nom = input.nextLine();
                    }while(nom.length()==0);

                    do{
                        System.out.print("\n\t [i]> saisir la prenom du client : ");
                        prenom = input.nextLine();
                    }while(prenom.length()==0);

                    do{
                        System.out.print("\n\t [i]> saisir le tel du client : ");
                        tel = input.nextLine();
                    }while(tel.length()==0);

                    do{
                        System.out.print("\n\t [i]> saisir l'email du client : ");
                        email = input.nextLine();
                    } while(email.length()==0);

                    do{
                        System.out.print("\n\t [i]> saisir l'address du client : ");
                        address = input.nextLine();
                    } while(address.length()==0);

                    clientsObj.add( new Client( nom, prenom, address, tel, email));
                    System.out.print("\n\t [i]> ✅ CLient est créé avec succès !");
                    break;
                case 4:
                    System.out.print("\n\n\t ----------------------------- Supprimer un Client ---------------------------");
                    do{
                        System.out.print("\n\t\t [i] entrez le nom du Client à supprimer : ");
                        searchStr = input.nextLine();
                    }while( searchStr.length()==0 );
                    searchedClient = clientsObj.findByNom(searchStr);
                    if( searchedClient!=null ){
                        System.out.print("\n\t [i]> Résultats trouvés: \n "+searchedClient);
                    }
                    else {
                        System.out.print("\n\t [i]> Aucun résultat n'a été trouvé ");
                        continue;
                    }
                    do{
                        System.out.print("\n\n\t [i] Voulez-vraiment le supprimer (Y/[N]) : ");
                        charChoice = input.nextLine();
                    }while( charChoice.length()>1 );
                    if(charChoice.toLowerCase().trim().equals("y")) {
                        clientsObj.delete(searchedClient.getNom());
                        System.out.print("\n\t  ✅ Client supprimé");
                    }
                    break;
                case 5:
                    System.out.print("\n\n\t .........................  Sauvegarder tous les Clients  .........................");
                    clientsObj.saveAll();
                    System.out.print("\n\t\t ✅ done !");
                    break;
                case 6:
                    System.out.print("\n\n\t ⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆ Charger les Clients sauvegardés ⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆⬆");
                    clientsObj.loadAll();
                    break;
                default:
                    System.out.print("\n\n\n\t\t ]-) A bienToT ! \n\n");
                    return;
            }
        }
    }
}
