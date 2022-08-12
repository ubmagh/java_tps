public class Main {

    public static void main(String[] args) {

        Thread talkative1 = new Thread( new Talkative(1) );
        Thread talkative2 = new Thread( new Talkative(2) );
        Thread talkative3 = new Thread( new Talkative(3) );
        Thread talkative4 = new Thread( new Talkative(4) );
        Thread talkative5 = new Thread( new Talkative(5) );
        Thread talkative6 = new Thread( new Talkative(6)) ;
        Thread talkative7 = new Thread( new Talkative(7) );
        Thread talkative8 = new Thread( new Talkative(8) );
        Thread talkative9 = new Thread( new Talkative(9) );
        Thread talkative10 = new Thread( new Talkative(10) );


        talkative1.start();
        talkative2.start();
        talkative3.start();
        talkative4.start();
        talkative5.start();
        talkative6.start();
        talkative7.start();
        talkative8.start();
        talkative9.start();
        talkative10.start();



    }

}
