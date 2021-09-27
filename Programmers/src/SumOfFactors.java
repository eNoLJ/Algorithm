import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class SumOfFactors {

    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }

        return answer;
    }

    public int solution2(int n) {
        return IntStream.rangeClosed(1, n).filter(i -> n % i == 0).sum();
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution2(12)).isEqualTo(28);
        softly.assertThat(solution2(5)).isEqualTo(6);
        softly.assertAll();
    }
}
