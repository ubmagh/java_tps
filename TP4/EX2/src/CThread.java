public class CThread implements Runnable {

    int i,j;
     Double [][]t1;
     Double [][]t2 ;

    final double k=0.6, c=3650, deltaT = 0.1, deltaX = 0.01, rho= 1040;
    boolean evenIteration = false;


    public CThread(int i, int j, Double[][]  t1, Double[][] t2, boolean evenIteration) {
        this.i = i;
        this.j = j;
        this.t1 = t1;
        this.t2 = t2;
        this.evenIteration =evenIteration ;
    }

    @Override
    public void run() {
        final double cte = ((deltaT * k) / (rho * c * deltaX * deltaX)) ;
        synchronized (this){

        if ( evenIteration ) {
                t2[i][j] = t1[i][j] + (cte * (t1[i - 1][j] + t1[i + 1][j] + t1[i][j - 1] + t1[i][j + 1]) );
        }else {
                t1[i][j] = t2[i][j] + (cte * (t2[i - 1][j] + t2[i + 1][j] + t2[i][j - 1] + t2[i][j + 1]));
        }
        }

    }
}
