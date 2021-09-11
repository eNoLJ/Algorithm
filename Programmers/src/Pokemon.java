import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Pokemon {

    public int solution(int[] nums) {
        Arrays.sort(nums);
        int answer = 0;
        int currentNumber = 0;
        for (int num : nums) {
            if (num != currentNumber) {
                answer++;
                currentNumber = num;
            }
            if (answer == nums.length / 2) {
                break;
            }
        }
        return answer;
    }

    // 중복되는 값 처리는 HashSet을 통해한다.
    public int solution2(int[] nums) {
        Set<Integer> numberSet = new HashSet<>();
        for (int num : nums) {
            numberSet.add(num);
        }
        return Math.min((nums.length / 2), numberSet.size());
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(new int[]{3, 1, 2, 3})).isEqualTo(2);
        softly.assertThat(solution(new int[]{3, 3, 3, 2, 2, 4})).isEqualTo(3);
        softly.assertThat(solution(new int[]{3, 3, 3, 2, 2, 2})).isEqualTo(2);
        softly.assertAll();
    }
}
