public class FiboTask extends MathTask {

    FiboTask(int[] theArray) {
        super(theArray);
    }

    private static boolean isSquare(int n) {
        int s = (int)Math.sqrt(n);
        return (s*s == n);
    }

    private static boolean checkFibo(int n) {
        return isSquare(5*n*n + 4) || isSquare(5*n*n - 4);
    }

    @Override
    public void run() {
        for (int i = 1; i < theArray.length; i++) {
            if (checkFibo(i)) {
                theArray[i] += 10;
            }
        }
    }
}