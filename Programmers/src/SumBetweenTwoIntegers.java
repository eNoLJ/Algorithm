import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.stream.LongStream;

public class SumBetweenTwoIntegers {

    public long solution(int a, int b) {
        long answer = 0;
        for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
            answer += i;
        }
        return answer;
    }

    public long solution2(int a, int b) {
        return LongStream.rangeClosed(Math.min(a, b), Math.max(a, b)).sum();
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution2(3, 5)).isEqualTo(12);
        softly.assertThat(solution2(3, 3)).isEqualTo(3);
        softly.assertThat(solution2(5, 3)).isEqualTo(12);
        softly.assertAll();
    }
}
