public class CreateWeirdCharacters {

    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] splitStr = s.split("");
        boolean even = true;

        for (String value : splitStr) {
            if (value.equals(" ")) {
                answer.append(" ");
                even = false;
            } else if (even) {
                answer.append(value.toUpperCase());
            } else {
                answer.append(value.toLowerCase());
            }

            even = !even;
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        String s = "try hello world";
        System.out.println(solution(s));
    }
}
