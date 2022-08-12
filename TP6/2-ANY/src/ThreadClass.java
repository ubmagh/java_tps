public  class ThreadClass implements Runnable{

    int number;

    public ThreadClass() {
        number=0;
    }

    @Override
    public  void run() {
    // public synchronized void run() {  // synchronizing the whole function

        // try this with & without "sychrounized" keyword
        for ( int i=0; i< 10000; i++){
            //synchronized (this) {
                number++;
            //}
        }


        System.out.print("\n\n\t ==>number : "+number);
    }
}
