package levelOne;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class EvenAndOdd {

    public String solution(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(3)).isEqualTo("Odd");
        softly.assertThat(solution(4)).isEqualTo("Even");
        softly.assertAll();
    }
}
