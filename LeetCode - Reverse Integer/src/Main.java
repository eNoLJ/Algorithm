public class Main {

    public static int reverse(int x) {
        int minus = 1;
        long longNum = (long)x;

        if (x < 0) {
            minus *= -1;
            longNum *= -1;
        }

        String strNum = String.valueOf(longNum);
        String reverseStrNum = new StringBuffer(strNum).reverse().toString();

        if (minus > 0) {
            if (Integer.MAX_VALUE < Long.parseLong(reverseStrNum)) {
                return 0;
            }
        } else {
            if (Integer.MIN_VALUE > Long.parseLong(reverseStrNum) * minus) {
                return 0;
            }
        }

        return Integer.parseInt(reverseStrNum) * minus;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }

}