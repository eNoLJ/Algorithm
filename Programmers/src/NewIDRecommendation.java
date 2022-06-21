import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class NewIDRecommendation {

    public String solution(String new_id) {
        String answer = Arrays.stream(new_id.split(""))
                .map(str -> str.charAt(0))
                .map(Character::toLowerCase)
                .filter(ch -> (97 <= ch && ch <= 122) ||
                        (48 <= ch && ch <= 57) ||
                        ch == 45 || ch == 95 || ch == 46)
                .map(String::valueOf)
                .reduce((acc, cur) -> {
                    if (acc.charAt(acc.length() - 1) == 46 && cur.charAt(0) == 46) {
                        return acc;
                    }
                    return acc + cur;
                })
                .orElse("");

        if (answer.length() > 0 && answer.charAt(0) == 46) {
            answer = answer.substring(1);
        }

        if (answer.length() > 0 && answer.charAt(answer.length() - 1) == 46) {
            answer = answer.substring(0, answer.length() - 1);
        }

        if (answer.equals("")) {
            answer = "a";
        }

        if (answer.length() > 15) {
            if (answer.charAt(14) == 46) {
                answer = answer.substring(0, 14);
            } else {
                answer = answer.substring(0, 15);
            }
        }

        if (answer.length() == 1) {
            answer = answer + answer.charAt(0) + answer.charAt(0);
        }

        if (answer.length() == 2) {
            answer += answer.charAt(1);
        }

        return answer;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution("...!@BaT#*..y.abcdefghijklm")).isEqualTo("bat.y.abcdefghi");
        softly.assertThat(solution("z-+.^.")).isEqualTo("z--");
        softly.assertThat(solution("=.=")).isEqualTo("aaa");
        softly.assertThat(solution("123_.def")).isEqualTo("123_.def");
        softly.assertThat(solution("abcdefghijklmn.p")).isEqualTo("abcdefghijklmn");
        softly.assertAll();
    }
}
