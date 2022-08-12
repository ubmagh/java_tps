import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ThreadClass t1 = new ThreadClass( "\n\t ==> Thread 1 ; 3seconds", 3);
        ThreadClass t2 = new ThreadClass( "\n\t ==> Thread 2 ; 2seconds", 2);
        RunnableClass rt3 = new RunnableClass( "\n\t ==> Thread 3 ; 1seconds", 1);
        Thread t3 = new Thread(rt3);
        Thread t32 = new Thread(rt3);
        //ThreadClass t4 = new ThreadClass( "\n\t ==> Thread 4 ; 4seconds", 4);
        t1.start();
        t2.start();
        t3.start();
        t32.start();
        new Thread( new ThreadClass( "\n\t ==> Thread 4 ; 4seconds", 4) ).start(); // create many threads for the same object (rt3 -> t3) for example
        //t4.start();
        System.out.print("\n\t =====> Fin de programme");
    }

}
