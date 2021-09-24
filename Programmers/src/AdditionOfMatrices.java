import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class AdditionOfMatrices {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(new int[][]{new int[]{1, 2}, new int[]{2, 3}},
                new int[][]{new int[]{3, 4}, new int[]{5, 6}}))
                .isEqualTo(new int[][]{new int[]{4, 6}, new int[]{7, 9}});
        softly.assertThat(solution(new int[][]{new int[]{1}, new int[]{2}},
                new int[][]{new int[]{3}, new int[]{4}}))
                .isEqualTo(new int[][]{new int[]{4}, new int[]{6}});
        softly.assertAll();
    }
}
