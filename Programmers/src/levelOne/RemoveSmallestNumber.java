package levelOne;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RemoveSmallestNumber {

    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        int minNum = arr[0];
        for (int num : arr) {
            if (minNum > num) {
                minNum = num;
            }
        }

        int[] answer = new int[arr.length - 1];
        int index = 0;
        for (int num : arr) {
            if (num != minNum) {
                answer[index] = num;
                index++;
            }
        }

        return answer;
    }

    public int[] solution2(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        int minNum = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(num -> num != minNum).toArray();
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution2(new int[]{4, 3, 2, 1})).isEqualTo(new int[]{4, 3, 2});
        softly.assertThat(solution2(new int[]{10})).isEqualTo(new int[]{-1});
        softly.assertAll();
    }
}
