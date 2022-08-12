public class ClassThread extends Thread{

    String name;

    public ClassThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        super.run();
        System.out.print("\n\t Thread : "+name);
    }
}
