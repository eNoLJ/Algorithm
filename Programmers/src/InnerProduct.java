import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class InnerProduct {

    public int solution(int[] a, int[] b) {
        return IntStream.range(0, a.length).map(i -> a[i] * b[i]).sum();
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(new int[]{1, 2, 3, 4}, new int[]{-3, -1, 0, 2})).isEqualTo(3);
        softly.assertThat(solution(new int[]{-1, 0, 1}, new int[]{1, 0, -1})).isEqualTo(-2);
        softly.assertAll();
    }
}
