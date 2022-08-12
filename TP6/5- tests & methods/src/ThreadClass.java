public class ThreadClass extends Thread{

    String name;
    static int number;

    public ThreadClass(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10000; i++)
            synchronized (ThreadClass.class){ // c'est ici la différence, car l'objet est de la classe, n'est pas une instance
                number++;
            }
        System.out.print("\n\t "+name+" : "+number);
    }
}
