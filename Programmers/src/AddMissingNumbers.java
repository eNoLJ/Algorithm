import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AddMissingNumbers {

    public int solution(int[] numbers) {
        return 45 - Arrays.stream(numbers).sum();
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0})).isEqualTo(14);
        softly.assertThat(solution(new int[]{5, 8, 4, 0, 6, 7, 9})).isEqualTo(6);
        softly.assertAll();
    }
}
