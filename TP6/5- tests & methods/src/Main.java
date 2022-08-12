public class Main {

    public static void main(String[] args) throws InterruptedException {
        ThreadClass tr1 = new ThreadClass("T1");
        ThreadClass tr2 = new ThreadClass("T2");

        tr1.start();
        // tr1.join();
        tr2.start();

    }

}
