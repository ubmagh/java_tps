import java.util.*;

public class Main {

    public static void main(String[] args) {
        String ch,copy ;
        int ascii=0, i=0;
        char Char;
        Scanner input = new Scanner(System.in);
        int nb_occurrences[] = new int[26];

        do{
            System.out.println(" ##> Saisissez la chainne de caractères (max:100) : ");
            ch = input.nextLine();
        }while( ch.length()>100 );
        copy = ch.toLowerCase(Locale.ROOT);

        for( i=0; i<ch.length(); i++ ){
            ascii = copy.charAt(i);
            ascii -=97;
            nb_occurrences[ascii]++;
        }

        System.out.println(" ##> La chainne "+ch+"\" contient : ");

        for( i=0; i<nb_occurrences.length; i++){
            if(nb_occurrences[i]>0){
                Char =  (char)(i+97);
                String p = ""+Char;
                System.out.println("-> "+nb_occurrences[i]+" fois la lettre '"+ p.toUpperCase() +"'.");
            }
        }

    }

}
