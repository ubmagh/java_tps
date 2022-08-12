import java.util.*;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        List<CompteBancaire> comptes = new ArrayList<CompteBancaire>();

        comptes.add( new CompteBancaire(802));
        comptes.add( new CompteBancaire(482));
        comptes.add( new CompteBancaire(105));
        comptes.add( new CompteBancaire(884.47f));

        System.out.printf("\n --Array List for -- \n");
        for( int i=0; i<comptes.size(); i++)
            System.out.println(comptes.get(i).getSolde());


        System.out.printf("\n --iterateur-- \n");

        Iterator<CompteBancaire> iterateur = comptes.iterator();

        while( iterateur.hasNext() ) {
            System.out.println( iterateur.next().getSolde()+"" );
        }

        System.out.printf("\n --vecteur iterateur -- \n");

        Vector<CompteBancaire> vcomptes = new Vector<CompteBancaire>();
        for ( CompteBancaire cb: comptes ) {
            vcomptes.add( cb );
        }

        iterateur = vcomptes.iterator();
        while( iterateur.hasNext() ) {
            System.out.println( iterateur.next().getSolde()+"" );
        }


        // HashMap (int java) <==> Dictionnary (in python ..else)

        System.out.printf("\n --Hash Map-- \n");
        Map<String, CompteBancaire> map = new HashMap<String, CompteBancaire>();

        for( int i=0; i<comptes.size(); i++)
            map.put("compte"+(1+i), comptes.get(i));

        for( Map.Entry<String,CompteBancaire> m: map.entrySet() )
            System.out.println( "Clé: "+m.getKey()+" | Valeur : "+m.getValue().getSolde() );


        System.out.printf("\n\n --Functions Hash Map-- \n");

        Map<Integer, Function<Integer, Float> > mymap = new HashMap<Integer, Function<Integer, Float> >();
        mymap.put(1, new Function<Integer, Float>() {
            @Override
            public Float apply(Integer integer) {
                return 10f * integer;
            }
        });
        mymap.put(2, new Function<Integer, Float>() {
            @Override
            public Float apply(Integer integer) {
                return 20f * integer;
            }
        });

        System.out.println(" FunctionalHash.get(1).apply(5) =  "+mymap.get(1).apply(5) );
        System.out.println(" FunctionalHash.get(2).apply(5) = "+mymap.get(2).apply(5) +"\n\n");



        //Exceptions handling
        //      2 types d'exceptions qui ne sont pas detectés (par le compilateur) : Runtime & error exceptions
        //

        // String str[] = new String[1000000000]; //--> error exception
        // a/0 ==> arithmetic<-- runtime exception

        // l'exception non ratrappée remonte vers le niveau supérieure (fonction main de cet exemple).
        try{
            Main.getArithmeticException(true);
        }catch( ArithmeticException e ){
            System.out.println(" [!] EXCEPTION ====> Division par 0 exception, message: '"+ e.getMessage() +"' !!!");
        }finally {
            System.out.println("\n\n ---> Executed anyways <---- \n");
        }


    }

    /*
            throws ArithmeticException  : decoration pour laisser le niveau supérieure traite l'exception
                donc catch doit etre présente dans la fonction qui appel Main.getArithmeticException()

     */

    public static float getArithmeticException(boolean quickly) throws ArithmeticException {
        if(quickly) throw new ArithmeticException("Hi there");
        // or
        int a = 1, b=0;
        float c = a/b;
        return c;
    }
}
