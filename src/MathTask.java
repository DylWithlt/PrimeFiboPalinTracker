abstract class MathTask implements Runnable {
    int[] theArray;

    MathTask(int[] theArray) {
        this.theArray = theArray;
    }

    @Override
    public void run() {}
}
