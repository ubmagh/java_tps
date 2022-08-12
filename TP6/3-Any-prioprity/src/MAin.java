public class MAin {
    public static void main(String[] args) {
        ClassThread t1 = new ClassThread( "thread1 /3 secs",3);
        ClassThread t2 = new ClassThread( "thread2 /4 secs",4);

        Thread tr1 = new Thread(t1);
        Thread tr2 = new Thread(t2);
        tr1.setPriority(Thread.MIN_PRIORITY); // 0<priority<=10
        tr2.setPriority(Thread.MAX_PRIORITY); // 0<priority<=10
        tr1.start();
        tr2.start();
    }
}
