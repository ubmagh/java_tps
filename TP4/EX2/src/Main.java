import java.util.Scanner;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws Exception, InterruptedException {

        Double [][] t1= new Double[10][10];
        Double[][] t2 = new Double[10][10];

        int i=0, j=0, it,counter=0;
        final int ITERATIONS = 100;
        double k=0.6, c=3650, deltaT = 0.1, deltaX = 0.01, rho= 1040;
        double cte = ((deltaT * k) / (rho * c * deltaX * deltaX)) ;
        Scanner scanner = new Scanner(System.in);

        for( i=0; i<10; i++){
            for( j=0;j<10; j++) {
                t1[i][j] = t2[i][j] = 0.;
            }
        }
        t1[4][4] = t2[4][4] = 30.0;

        System.out.print("\n\t saisissez une chaine pour continuer ...");
        scanner.next() ;

        System.out.print("\n\n\t Calcule sans threads : \n");
        for ( it=0; it<ITERATIONS;it++) {
            for (i = 1; i < 9; i++) {
                for (j = 1; j < 9; j++) {
                    if ( !(i == 4 && j == 4) ) {
                        if (it % 2 == 0) {
                            t2[i][j] = t1[i][j] + ( cte * ( t1[i-1][j]+t1[i+1][j]+t1[i][j-1]+t1[i][j+1]-4*t1[i][j] ));
                        } else {
                            t1[i][j] = t2[i][j] + ( cte * ( t2[i-1][j]+t2[i+1][j]+t2[i][j-1]+t2[i][j+1]-4*t2[i][j] ));
                        }
                    }
                }
            }
        }
        afficher( t1, t2,10);



        System.out.print("\n\n\t ++> Reinitialiser les matrices ...");
        for( i=0; i<10; i++){
            for( j=0;j<10; j++) {
                t1[i][j] = t2[i][j] = 0.;
            }
        }        t1[4][4] = t2[4][4] = 30.0;
        //afficher( t1, t2,10);


        Thread tr;
        ExecutorService tpe = Executors.newFixedThreadPool(63);


        System.out.print("\n\t saisissez une chaine pour continuer ...");
        scanner.next() ;

        System.out.print("\n\n\t Calcule avec les threads : \n");
        for ( it=0; it<ITERATIONS;it++) {
            for (i = 1; i < 9; i++) {
                for (j = 1; j < 9; j++) {
                    if ( !(i == 4 && j == 4) ) {
                        tr = new Thread( new CThread( i, j, t1, t2, it%2==0) );
                        tpe.execute( tr );
                        counter++;
                    }
                }
            }
        }
        tpe.shutdown();
        tpe.awaitTermination( Long.MAX_VALUE, TimeUnit.SECONDS);

        afficher( t1, t2,10);
        System.out.printf("\n\n Pour %d itérations , %d threads sont lancés \n", ITERATIONS, counter);
    }

    private static void afficher( Double[][]t1, Double[][]t2, int size){
        int i,j;
        for(i =0; i<size; i++) {
            System.out.print("\n");
            for (j = 0; j < size; j++)
                System.out.printf("  %3.2f", t1[i][j]);
        }
    }

}
