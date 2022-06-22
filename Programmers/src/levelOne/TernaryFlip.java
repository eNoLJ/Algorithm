package levelOne;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class TernaryFlip {

    public int solution(int n) {
        StringBuilder answer = new StringBuilder();

        while (n > 0) {
            answer.append(n % 3);
            n = n / 3;
        }

        return Integer.parseInt(answer.toString(), 3);
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(45)).isEqualTo(7);
        softly.assertThat(solution(125)).isEqualTo(229);
        softly.assertAll();
    }
}
