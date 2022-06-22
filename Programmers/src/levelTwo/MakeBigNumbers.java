package levelTwo;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class MakeBigNumbers {

    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int index = 0;
        char value;

        for (int i = number.length() - k; i > 0; i--) {
            value = 0;

            for (int j = index; j <= number.length() - i; j++) {
                if (value < number.charAt(j)) {
                    value = number.charAt(j);
                    index = j + 1;
                }
            }

            answer.append(value);
        }

        return answer.toString();
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution("19245", 2)).isEqualTo("945");
        softly.assertThat(solution("1924", 2)).isEqualTo("94");
        softly.assertThat(solution("1924", 3)).isEqualTo("9");
        softly.assertThat(solution("1024", 2)).isEqualTo("24");
        softly.assertThat(solution("24", 1)).isEqualTo("4");
        softly.assertThat(solution("1000100011", 5)).isEqualTo("11011");
        softly.assertThat(solution("1231234", 3)).isEqualTo("3234");
        softly.assertThat(solution("4177252841", 4)).isEqualTo("775841");
        softly.assertAll();
    }
}
