package levelOne;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Budget {

    public int solution(int[] requestedAmount, int budget) {
        Arrays.sort(requestedAmount);
        int answer = 0;
        for (int amount : requestedAmount) {
            if (amount <= budget) {
                budget -= amount;
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(new int[]{1, 3, 2, 5, 4}, 9)).isEqualTo(3);
        softly.assertThat(solution(new int[]{2, 2, 3, 3}, 10)).isEqualTo(4);
        softly.assertAll();
    }
}
