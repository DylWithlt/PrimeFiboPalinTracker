import java.util.stream.LongStream;

public class PrimeTask extends MathTask {

    PrimeTask(int[] theArray) {
        super(theArray);
    }

    private static boolean checkPrime(long n) {

        if (n % 2 == 0 && n != 2)
            return false;
        return (LongStream.rangeClosed(3, (long) Math.sqrt(n))
                .filter((x) -> (n % x == 0))
                .count() == 0);

    }

    @Override
    public void run() {
        for (int i = 2; i < theArray.length; i++) {
            if (!checkPrime(i)) {
                theArray[i] = -1;
            }
        }
    }
}
