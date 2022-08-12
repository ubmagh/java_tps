public class Main {

    public static void main(String[] args) {
        ThreadClass tc = new ThreadClass();

        new Thread( tc ).start();
        new Thread( tc ).start();

        // the value should reach basically : 20 000 ,
        /***
         * when not synchronizing both of threads are changing the value of the 'number' attribute
         * so each one of them changes the old value that the other has juste changed ==> value doesn't reach 20 000
         * try with synchronized keyword
         *
         * synchronized keyword locks a part of code from being accessed by more than 1 thread.
         */
    }

}
