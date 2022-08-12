import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int nbrNotes = 0, i, occurences=0;
        float somme=0, moyenne=0, noteSrch=0;
        Scanner input = new Scanner(System.in);

        System.out.printf(" Entrez le nombre des notes : ");
        nbrNotes = input.nextInt();

        float notes[] = new float[nbrNotes];
        for( i=0; i<nbrNotes; i++){
            System.out.printf(" Saisissez la note "+(1+i)+" : ");
            notes[i] = input.nextFloat() ;
        }

        System.out.printf("\n --> La table des notes (n'est pas trié): ");
        System.out.printf(Arrays.toString( notes) );

        moyenne = somme/nbrNotes;
        System.out.print("\n --> Moyenne : "+moyenne);

        Arrays.sort(notes);
        System.out.print("\n --> Note maximale : "+notes[nbrNotes-1]);
        System.out.print("\n --> Note minimale : "+notes[0]);


        System.out.print("\n --> La note à chercher  : ");
        noteSrch = input.nextFloat();

        for( float note:notes){
            if(note == noteSrch) occurences++;
        }
        System.out.print("\n --> Nombre d'étudiants ayants la note "+noteSrch+" est : "+occurences);

    }
}
