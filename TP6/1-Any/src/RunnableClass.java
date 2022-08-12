import java.util.concurrent.TimeUnit;

/**
 *  The difference between using inheritance & implementation, is that when implementing the interface, we can extend from another class while keeping the run function
 */

public class RunnableClass implements Runnable{

    String message;
    int sleepSec;
    public RunnableClass(String message, int seconds){
        this.message = message;
        sleepSec = seconds;
    }

    @Override
    public void run() {
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
