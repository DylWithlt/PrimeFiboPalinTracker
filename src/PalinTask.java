public class PalinTask extends MathTask {

    PalinTask(int[] theArray) {
        super(theArray);
    }

    private static boolean checkIntPalindrome(int n) {
        String strNum = Integer.toString(n);

        if (strNum.length() == 1) {
            return true;
        }
        for (int i = 0; i < (int)(strNum.length()/2); i++) {
            if (!(strNum.charAt(i) == strNum.charAt(strNum.length()-1-i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() {
        for (int i = 1; i < theArray.length; i++) {
            if (checkIntPalindrome(i)) {
                theArray[i] += 100;
            }
        }
    }
}
