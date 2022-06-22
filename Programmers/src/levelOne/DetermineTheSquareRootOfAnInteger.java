package levelOne;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class DetermineTheSquareRootOfAnInteger {

    public long solution(long n) {
        double square = Math.sqrt(n);
        return square == (int) square ? (long) Math.pow(square + 1, 2) : -1;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(121)).isEqualTo(144);
        softly.assertThat(solution(3)).isEqualTo(-1);
        softly.assertAll();
    }
}
