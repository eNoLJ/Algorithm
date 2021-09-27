import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class MinimumRectangle {

    public int solution(int[][] sizes) {
        int horizontal = 0;
        int vertical = 0;

        for (int[] size : sizes) {
            horizontal = Math.max(horizontal, Math.max(size[0], size[1]));
            vertical = Math.max(vertical, Math.min(size[0], size[1]));
        }

        return horizontal * vertical;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(new int[][]{new int[]{60, 50}, new int[]{30, 70}, new int[]{60, 30}, new int[]{80, 40}})).isEqualTo(4000);
        softly.assertThat(solution(new int[][]{new int[]{10, 7}, new int[]{12, 3}, new int[]{8, 15}, new int[]{14, 7}, new int[]{5, 15}})).isEqualTo(120);
        softly.assertAll();
    }
}
