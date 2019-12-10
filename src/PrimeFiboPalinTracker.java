import java.util.Arrays;
import java.util.concurrent.*;
import java.util.stream.LongStream;

public class PrimeFiboPalinTracker {
    public static void main(String[] args) {
        int bigNum = 100;//(int) Math.pow(2,20);

        int[] primeFiboPalinTracker = new int[bigNum];

        for (int i = 0; i < bigNum; i++) {
            primeFiboPalinTracker[i] = 1;
        }

        ExecutorService executor = Executors.newCachedThreadPool();
        MathTask primeTask = new PrimeTask(primeFiboPalinTracker);
        MathTask fiboTask = new FiboTask(primeFiboPalinTracker);
        MathTask palinTask = new PalinTask(primeFiboPalinTracker);

        executor.execute(primeTask);
        executor.execute(fiboTask);
        executor.execute(palinTask);

        executor.shutdown();

        try {
            boolean taskEnded = executor.awaitTermination(1, TimeUnit.MINUTES);
            if (taskEnded) {
                System.out.println("Tasks successfully ended");
            }
        } catch (InterruptedException ignored) {}

        for (int i = 1; i < bigNum ; i++) {
            if (primeFiboPalinTracker[i] == 111) {
                System.out.println("Tripple at: " + i);
            }
        }
        for (int i = 1; i < bigNum; i++) {
            if (primeFiboPalinTracker[i] == 11) {
                System.out.println("Fibo and Prime at: " + i);
            } else if (primeFiboPalinTracker[i] == 101) {
                System.out.println("Palin and Prime at: " + i);
            } else if (primeFiboPalinTracker[i] == 110) {
                System.out.println("Palin and Fibo at: " + i);
            }
        }
    }
}
