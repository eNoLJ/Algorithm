package levelOne;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class NumberAndAdditionOfFactors {

    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            if (i == 1) {
                answer--;
                continue;
            }

            double num = Math.sqrt(i);
            if (num == (int)num) {
                answer -= i;
            } else {
                answer += i;
            }
        }

        return answer;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(13, 17)).isEqualTo(43);
        softly.assertThat(solution(13, 13)).isEqualTo(13);
        softly.assertThat(solution(1, 1)).isEqualTo(-1);
        softly.assertThat(solution(24, 27)).isEqualTo(52);
        softly.assertAll();
    }
}
