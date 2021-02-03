public class Solution {

    public static String solution(int a, int b) {
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] week = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int days = 0;

        for (int i = 0; i < a - 1; i++) {
            days += month[i];
        }

        return week[(days + b) % 7];
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 24)); // TUE
    }

}
