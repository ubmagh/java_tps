import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tmp=0;
        EntierNaturel e1;
        System.out.printf("\n\n\t --> saisissez un entier : ");
        tmp = sc.nextInt();
        sc.nextLine();
        System.out.printf("\n\n\t [i] La valeur saisie est : "+tmp);

        System.out.printf("\n\n\t [i] Création de l'objet 'EntierNaturel' ");

        try{
            e1 = new EntierNaturel( tmp );
        }catch( NombreNegatifException e){
            System.out.printf("\n\n\t [!! Exception !!]> "+e.getMessage()+"\n\n");
            return;
        }

        try{
            while(true){
                System.out.printf("\n\n\t [i]> Décrementation de la valeur saisie à "+(e1.getVal()-1));
                e1.decrementer();
            }
        }catch ( NombreNegatifException e){
            System.out.printf("\n\n\t [!! Exception !!]> "+e.getMessage());
            System.out.printf("\n\n\t Valeur négative à travers la methode e.getExceptionValue() : "+e.getExceptionValue()+"\n\n");
            return;
        }




    }

}
