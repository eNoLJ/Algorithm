public class ReverseInteger {

    public static int reverse(int x) {
        int minus = 1;
        long longNum = (long)x;

        if (x < 0) {
            minus *= -1;
            longNum *= -1;
        }

        String strNum = String.valueOf(longNum);
        String reverseStrNum = new StringBuffer(strNum).reverse().toString();
        longNum = Long.parseLong(reverseStrNum) * minus;

        if (Integer.MIN_VALUE > longNum || longNum > Integer.MAX_VALUE) {
            return 0;
        }

        return (int)longNum;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }
}
