import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class WatermelonWatermelon {

    public String solution(int n) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                answer += "수";
            } else {
                answer += "박";
            }
        }
        return answer;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(3)).isEqualTo("수박수");
        softly.assertThat(solution(4)).isEqualTo("수박수박");
        softly.assertAll();
    }
}
