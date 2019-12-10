import java.util.stream.LongStream;

public class PrimeTask extends MathTask {

    PrimeTask(int[] theArray) {
        super(theArray);
    }

    private static boolean checkPrime(long n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i < n/2; i++) {
            int remainder = (int) (n%i);
            if (n%i == 0) {
                return false;
            }
        }
        return true;
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
