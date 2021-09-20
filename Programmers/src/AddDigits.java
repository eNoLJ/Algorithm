import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AddDigits {

    public int solution(int n) {
        return Arrays.stream(String.valueOf(n).split(""))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(123)).isEqualTo(6);
        softly.assertThat(solution(987)).isEqualTo(24);
        softly.assertAll();
    }
}
