package levelOne;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class GreatestCommonFactorAndLeastCommonMultiple {

    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int lowNumber = Math.min(n, m);
        int highNumber = Math.max(n, m);

        for (int i = 1; i <= lowNumber; i++) {
            if (lowNumber % i == 0 && highNumber % i == 0) {
                answer[0] = i;
            }
            if (answer[1] == 0 && (highNumber * i % lowNumber == 0)) {
                answer[1] = highNumber * i;
            }
        };

        return answer;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(3, 12)).isEqualTo(new int[]{3, 12});
        softly.assertThat(solution(2, 5)).isEqualTo(new int[]{1, 10});
        softly.assertAll();
    }
}
