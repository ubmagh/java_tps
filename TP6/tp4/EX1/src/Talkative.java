public class Talkative implements Runnable {

    private int nbr;


    public Talkative(int nbr) {
        this.nbr = nbr;
    }

    @Override
    public void run() {

        for(int i=0; i<100; i++)
            System.out.print("\n -> "+nbr+" <-");

    }
}
