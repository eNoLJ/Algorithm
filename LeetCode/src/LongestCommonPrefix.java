public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String result = "";
        boolean check = true;

        if (strs.length == 0) {
            return result;
        }

        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[0].charAt(i) != strs[j].charAt(i)) {
                    check = false;
                    break;
                }
            }

            if (check) {
                result += strs[0].charAt(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {}
}
