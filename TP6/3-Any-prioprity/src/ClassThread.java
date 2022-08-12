import java.util.concurrent.TimeUnit;

public class ClassThread implements Runnable {

    String name;
    int seconds;

    public ClassThread(String name, int seconds) {
        this.name = name;
        this.seconds = seconds;
    }

    @Override
    public void run() {
        loop(1000000);
        System.out.print("\n\t threadname: "+name);
    }


    private void loop(int KKK){
        for(int i =0; i<KKK; i++);
    }


    private void sleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        }catch (Exception e) {
            System.out.print("\n\t\t [Exception]Pince()> " + e.getMessage());
        }
    }
}
