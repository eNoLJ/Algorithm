package levelTwo;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class NumberOf124countries {

    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int remainder;

        while (n > 0) {
            remainder = n % 3;

            if (remainder == 0) {
                remainder = 4;
            }

            answer.insert(0, remainder);
            n = (n - 1) / 3;
        }

        return answer.toString();
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(1)).isEqualTo("1");
        softly.assertThat(solution(2)).isEqualTo("2");
        softly.assertThat(solution(3)).isEqualTo("4");
        softly.assertThat(solution(4)).isEqualTo("11");
        softly.assertThat(solution(5)).isEqualTo("12");
        softly.assertThat(solution(6)).isEqualTo("14");
        softly.assertThat(solution(9)).isEqualTo("24");
        softly.assertThat(solution(11)).isEqualTo("42");
        softly.assertThat(solution(12)).isEqualTo("44");
        softly.assertThat(solution(13)).isEqualTo("111");
        softly.assertThat(solution(14)).isEqualTo("112");
        softly.assertThat(solution(15)).isEqualTo("114");
        softly.assertThat(solution(16)).isEqualTo("121");
        softly.assertThat(solution(17)).isEqualTo("122");
        softly.assertThat(solution(18)).isEqualTo("124");
        softly.assertThat(solution(19)).isEqualTo("141");
        softly.assertThat(solution(20)).isEqualTo("142");
        softly.assertThat(solution(21)).isEqualTo("144");
        softly.assertThat(solution(22)).isEqualTo("211");
        softly.assertAll();
    }
}
