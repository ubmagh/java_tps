import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        float tab[] = new float[100];
        float Membre = 0;
        int nbrElements = 0, choix=0, i=0, j=0 ;
        Scanner input = new Scanner(System.in);

        while(true){

            do {
                System.out.printf("\n\n\n*****************************");
                System.out.printf("\n 1# Afficher le tableau ;");
                System.out.printf("\n 2# Insérer dans le tableau ;");
                System.out.printf("\n 3# Suprimer dans le tableau ;");
                System.out.printf("\n 0# Quitter ;");
                System.out.printf("\n*****************************");
                System.out.printf("\n\t ## Votre choix est ---> ");
                choix = input.nextInt();
            } while( choix<0 && choix>3 );

            switch (choix){
                case 1:
                    if( nbrElements==0 ) {
                        System.out.printf("\n\n&&&#> Aucun élément dans le tableau");
                        break;
                    }
                    float temp[] = Arrays.copyOfRange( tab, 0, nbrElements);
                    System.out.printf("\n\n&&&#> Tableau : "+Arrays.toString(temp));
                break;
                case 2:
                    System.out.printf("\n\n&&&#> Entrez un nombre à insérer : ");
                    Membre = input.nextFloat();
                    tab[nbrElements] = Membre;
                    Membre =0; nbrElements ++;
                    Arrays.sort( tab, 0, nbrElements);
                    System.out.printf("\n&&&#> Bien Inséré");
                break;
                case 3:
                    System.out.printf("\n\n&&&#> Entrez un nombre à supprimer : ");
                    Membre = input.nextFloat();
                    i=0;
                    while( i<nbrElements ){
                        if( tab[i]==Membre ) {
                            for (j = i; j < nbrElements - 1; j++)
                                tab[j] = tab[j + 1];
                            tab[nbrElements-1]=0;
                            nbrElements--;
                        }else
                        i++;
                    }
                    Arrays.sort( tab, 0, nbrElements);
                    System.out.printf("\n&&&#> Bien Supprimé");
                break;
                default:
                    System.out.printf("\n\n\t###===>   A bientot !    <===###\n");
                    return;
            }
        }
    }
}