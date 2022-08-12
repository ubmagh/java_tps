import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ClassThread t1 = new ClassThread(" T1 ");
        ClassThread t2 = new ClassThread(" T2 ");
        ClassThread t3 = new ClassThread(" T3 ");
        ClassThread t4 = new ClassThread(" T4 ");
        ClassThread t5 = new ClassThread(" T5 ");
        ClassThread t6 = new ClassThread(" T6 ");

        // exemple de traitement de requettes dans un serveur par ex.
        ExecutorService executorService = Executors.newFixedThreadPool(3); // executer 3 thread à la fois

        executorService.execute(t1);
        executorService.execute(t2);
        executorService.execute(t3);
        executorService.execute(t4);
        executorService.execute(t5);
        executorService.execute(t6);
        executorService.shutdown();

    }
}
