import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class FindANumberWhoseRemainderIsOne {

    public int solution(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 1) {
                return i;
            }
        }
        return 0;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(10)).isEqualTo(3);
        softly.assertThat(solution(12)).isEqualTo(11);
        softly.assertAll();
    }
}
