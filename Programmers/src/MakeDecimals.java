import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MakeDecimals {

    public int solution(int[] nums) {
        List<Integer> sumNums = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    sumNums.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        int answer = 0;
        for (Integer sumNum : sumNums) {
            if (verifyDecimal(sumNum)) {
                answer++;
            }
        }
        return answer;
    }

    public boolean verifyDecimal(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(new int[]{1, 2, 3, 4})).isEqualTo(1);
        softly.assertThat(solution(new int[]{1, 2, 7, 6, 4})).isEqualTo(4);
        softly.assertAll();
    }
}
