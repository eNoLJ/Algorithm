import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static int[] solution(int[] answers) {
        String[] students = {"12345", "21232425", "3311224455"};
        int[] answer = new int[3];
        int maxNum = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < students.length; i++) {
            String[] student = students[i].split("");

            for (int j = 0; j < answers.length; j++) {
                if (Integer.parseInt(student[j % student.length]) == answers[j]) {
                    answer[i]++;
                }
            }

            if (maxNum < answer[i]) {
                maxNum = answer[i];
            }
        }

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == maxNum) {
                result.add(i + 1);
            }
        }

        answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] answers;

        answers = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solution(answers)));

        answers = new int[]{1,3,2,4,2};
        System.out.println(Arrays.toString(solution(answers)));

    }
}
