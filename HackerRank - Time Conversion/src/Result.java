public class Result {

    static String timeConversion(String s) {
        String ch = String.valueOf(s.charAt(8));
        int hour = Integer.parseInt(s.substring(0, 2));
        String zero = "";

        if (ch.equals("P")) {
            hour += hour != 12 ? 12 : 0;
        } else if (ch.equals("A")) {
            hour += hour == 12 ? -12 : 0;
        }

        if (hour < 10) {
            zero = "0";
        }

        return zero + hour + s.substring(2, 8);
    }

    public static void main(String[] args) {
        System.out.println(timeConversion("12:01:00PM")); // 12:01:00
        System.out.println(timeConversion("12:01:00AM")); // 00:01:00
        System.out.println(timeConversion("07:04:05PM")); // 19:05:45
    }

}
