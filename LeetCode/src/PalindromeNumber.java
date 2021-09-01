public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String[] strNum = String.valueOf(x).split("");

        for (int i = 0; i < strNum.length / 2; i++) {
            if (!strNum[i].equals(strNum[strNum.length - (i + 1)])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {}
}
