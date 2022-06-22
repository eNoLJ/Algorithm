package levelOne;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class IHateTheSameNumber {

    public int[] solution(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int currentNumber = -1;
        for (int number : arr) {
            if (number != currentNumber) {
                result.add(number);
                currentNumber = number;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void test() {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(solution(new int[]{1,1,3,3,0,1,1})).isEqualTo(new int[]{1,3,0,1});
            softly.assertThat(solution(new int[]{4,4,4,3,3})).isEqualTo(new int[]{4,3});
        });
    }
}
