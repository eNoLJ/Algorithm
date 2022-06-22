package levelOne;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class StringHandlingBasics {

    public boolean solution(String s) {
        int strLength = s.length();

        if (strLength != 4 && strLength != 6) {
            return false;
        }

        for (int i = 0; i < strLength; i++) {
            if (s.charAt(i) > '9') {
                return false;
            }
        }

        return true;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution("a234")).isFalse();
        softly.assertThat(solution("1234")).isTrue();
        softly.assertAll();
    }
}
