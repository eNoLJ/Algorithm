import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class AddNegativeAndPositive {

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            answer += signs[i] ? absolutes[i] : -absolutes[i];
        }
        return answer;
    }

    public int solution2(int[] absolutes, boolean[] signs) {
        return IntStream.range(0, absolutes.length)
                .map(i -> signs[i] ? absolutes[i] : -absolutes[i])
                .sum();
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(new int[]{4, 7, 12}, new boolean[]{true, false, true})).isEqualTo(9);
        softly.assertThat(solution(new int[]{1, 2, 3}, new boolean[]{false, false, true})).isEqualTo(0);
        softly.assertAll();
    }
}
