import java.util.Scanner;
import java.io.IOException;


public class Main {

    public static void main(String[] args)  throws IOException, InterruptedException {
        StringBuilder chaine= new StringBuilder("");
        boolean typed=false;
        int choix = 0;
        String tmp="";
        Scanner input = new Scanner(System.in);
        while(true){

            System.out.printf("\n\n --cls-- \n\n\n");


            System.out.println("\n ---------- Menu d'opérations sur la chainne de caractères : ---------- ");
            System.out.printf("     1 - Saisir la chainne ");
            System.out.printf("     2 - Afficher la chainne ");
            System.out.printf("     3 - Inverser la chainne ");
            System.out.printf("     4 - Nombre de mots dans la chainne ");
            System.out.printf("     0 - Quitter ");
            System.out.println("\n ----------------------------------------------------------------------- \n");

            do {
                System.out.printf(" ----> votre choix: ");
                choix = input.nextInt();
            }while( choix<0 && choix>4 );

            System.out.printf("\n\n --cls-- \n\n\n");

            switch( choix ){
                case 1:
                    System.out.printf(" --> saisissez la chainne : ");
                    chaine = new StringBuilder( input.nextLine() );
                    chaine.append( input.nextLine());
                    typed= true;
                    break;
                case 2:
                    if( !typed)
                        System.out.println(" -->! Saisissez d'abord une chainne !");
                    else
                        System.out.println("--> affichage de la chainne : "+chaine);
                    break;
                case 3:
                    if( !typed)
                        System.out.println(" -->! Saisissez d'abord une chainne !");
                    else
                        System.out.println(" --> l'inverse de la chainne :  "+chaine.reverse());
                    break;
                case 4:
                    if( !typed)
                        System.out.println(" -->! Saisissez d'abord une chainne !");
                    else {
                        int count = 0;
                        for ( String word:(chaine.toString().trim().split(" ")) ) if (word.trim().length()>0) count++;
                        System.out.println(" --> nombre de mots dans la chainne : " +count );
                    }
                    break;
                case 0:
                    System.out.printf("A bientot !");
                    return;
            }

        }
    }
}
