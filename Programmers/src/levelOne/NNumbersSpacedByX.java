package levelOne;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class NNumbersSpacedByX {

    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = (long) x * (i + 1);
        }

        return answer;
    }

    public long[] solution2(int x, int n) {
        return IntStream.range(0, n).mapToLong(i -> (long) x * (i + 1)).toArray();
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution2(2, 5)).isEqualTo(new long[]{2, 4, 6, 8, 10});
        softly.assertThat(solution2(4, 3)).isEqualTo(new long[]{4, 8, 12});
        softly.assertThat(solution2(-4, 2)).isEqualTo(new long[]{-4, -8});
        softly.assertAll();
    }
}
