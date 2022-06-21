import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class SecretMap {

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            int num = n;

            while (num > 0) {
                if (arr1[i] % 2 == 1 || arr2[i] % 2 == 1) {
                    answer[i] = "#" + answer[i];
                } else {
                    answer[i] = " " + answer[i];
                }
                arr1[i] /= 2;
                arr2[i] /= 2;
                num--;
            }

            answer[i] = answer[i].substring(0, answer[i].length() - 4);
        }

        return answer;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28}))
                .isEqualTo(new String[]{"#####", "# # #", "### #", "#  ##", "#####"});
        softly.assertThat(solution(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10}))
                .isEqualTo(new String[]{"######", "###  #", "##  ##", " #### ", " #####", "### # "});
        softly.assertAll();
    }
}
