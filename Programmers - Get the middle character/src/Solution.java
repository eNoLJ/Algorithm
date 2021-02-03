public class Solution {

    public static String solution(String s) {
        int mIdx = s.length() / 2;
        return s.length() % 2 == 0 ? s.substring(mIdx - 1, mIdx + 1) : s.substring(mIdx, mIdx + 1);
    }

    public static void main(String[] args) {
        System.out.println(solution("abcde")); // c
        System.out.println(solution("qwer")); // we
    }

}
