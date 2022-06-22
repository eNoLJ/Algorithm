package levelOne;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class FlipNaturalNumbersToFormAnArray {

    public int[] solution(long n) {
        String[] strArray = String.valueOf(n).split("");
        int[] answer = new int[strArray.length];

        for (int i = 0; i < strArray.length; i++) {
            answer[answer.length - i - 1] = Integer.parseInt(strArray[i]);
        }
        return answer;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(12045)).isEqualTo(new int[]{5, 4, 0, 2, 1});
        softly.assertAll();
    }
}
