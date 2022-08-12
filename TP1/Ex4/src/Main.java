import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String verbe;
        Scanner input = new Scanner(System.in);
        boolean is1erGrp = false;
        do {
            System.out.printf(" ##> Saissez le verbe du 1er grp :  ");
            verbe = input.nextLine();
            verbe = verbe.trim();
            is1erGrp =  verbe.substring( verbe.length()-2, verbe.length() ).equals("er");
        } while ( verbe.length() == 0 || !is1erGrp );

        StringBuilder premierePartie = new StringBuilder(verbe);

        verbe = premierePartie.substring(0, premierePartie.length()-2);



        System.out.printf("\n# je " + verbe +"e"+
                "\n# tu " + verbe +"es"+
                "\n# il " + verbe + "e"+
                "\n# nous " + verbe + "ons"+
                "\n# vous " + verbe + "ez"+
                "\n# ils "+ verbe+"ent ." );

    }
}

