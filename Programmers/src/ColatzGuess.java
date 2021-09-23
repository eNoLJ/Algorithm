import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class ColatzGuess {

    public int solution(long num) {
        int answer = 0;
        while (answer != 500 && num != 1) {
            num = (num % 2 == 0) ? (num / 2) : (num * 3 + 1);
            answer++;
        }
        return answer == 500 ? -1 : answer;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(1)).isEqualTo(0);
        softly.assertThat(solution(6)).isEqualTo(8);
        softly.assertThat(solution(16)).isEqualTo(4);
        softly.assertThat(solution(626331)).isEqualTo(-1);
        softly.assertAll();
    }
}
