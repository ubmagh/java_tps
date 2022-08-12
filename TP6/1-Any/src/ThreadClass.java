import java.util.concurrent.TimeUnit;

public class ThreadClass extends Thread{
    String message;
    int sleepSec;
    public ThreadClass(String message, int seconds){
        this.message = message;
        sleepSec = seconds;
    }

    @Override
    public void run() {
        super.run();
        sleep(sleepSec);
        System.out.print(message);
    }

    private void sleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        }catch (Exception e) {
            System.out.print("\n\t\t [Exception]Pince()> " + e.getMessage());
        }
    }

}
