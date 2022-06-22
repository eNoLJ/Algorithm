package levelOne;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class HashadSu {

    public boolean solution(int x) {
        int sumOfDigits = Arrays.stream(Integer.toString(x).split(""))
                .mapToInt(Integer::parseInt)
                .sum();
        return x % sumOfDigits == 0;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(10)).isTrue();
        softly.assertThat(solution(11)).isFalse();
        softly.assertThat(solution(12)).isTrue();
        softly.assertThat(solution(13)).isFalse();
        softly.assertAll();
    }
}
