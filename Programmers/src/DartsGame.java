import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DartsGame {

    public int solution(String dartResult) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            int lastIndexOfResult = result.size() - 1;

            if (48 <= ch && ch <= 57) {
                if (ch == 48 && !result.isEmpty() && dartResult.charAt(i - 1) == 49) {
                    result.set(lastIndexOfResult, result.get(lastIndexOfResult) * 10);
                } else {
                    result.add(Character.getNumericValue(ch));
                }
            }

            if (ch == 83 || ch == 68 || ch == 84) {
                int pow = 0;
                if (ch == 83) {
                    pow = 1;
                }
                if (ch == 68) {
                    pow = 2;
                }
                if (ch == 84) {
                    pow = 3;
                }
                result.set(lastIndexOfResult, (int) Math.pow(result.get(lastIndexOfResult), pow));
            }

            if (ch == 42) {
                result.set(lastIndexOfResult, result.get(lastIndexOfResult) * 2);
                if (lastIndexOfResult != 0) {
                    result.set(result.size() - 2, result.get(result.size() - 2) * 2);
                }
            }

            if (ch == 35) {
                result.set(lastIndexOfResult, result.get(lastIndexOfResult) * -1);
            }
        }

        return result.get(0) + result.get(1) + result.get(2);
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution("1S2D*3T")).isEqualTo(37);
        softly.assertThat(solution("1D2S#10S")).isEqualTo(9);
        softly.assertThat(solution("1D2S0T")).isEqualTo(3);
        softly.assertThat(solution("1S*2T*3S")).isEqualTo(23);
        softly.assertThat(solution("1D#2S*3S")).isEqualTo(5);
        softly.assertThat(solution("1T2D3D#")).isEqualTo(-4);
        softly.assertThat(solution("1D2S3T*")).isEqualTo(59);
        softly.assertAll();
    }
}
