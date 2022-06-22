package levelOne;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Average {

    public double solution(int[] arr) {
        return (double) Arrays.stream(arr).sum() / arr.length;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(new int[]{1, 2, 3, 4})).isEqualTo(2.5);
        softly.assertThat(solution(new int[]{5, 5})).isEqualTo(5);
        softly.assertAll();
    }
}
