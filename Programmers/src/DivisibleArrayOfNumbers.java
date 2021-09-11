import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class DivisibleArrayOfNumbers {

    public int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr)
                .filter(num -> num % divisor == 0)
                .sorted()
                .toArray();
        return answer.length != 0 ? answer : new int[]{-1};
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(new int[]{5, 9, 7, 10}, 5)).isEqualTo(new int[]{5, 10});
        softly.assertThat(solution(new int[]{2, 36, 1, 3}, 1)).isEqualTo(new int[]{1, 2, 3, 36});
        softly.assertThat(solution(new int[]{3, 2, 6}, 10)).isEqualTo(new int[]{-1});
        softly.assertAll();
    }
}
