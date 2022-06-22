package levelOne;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class NumericStringsAndEnglishWords {

    public int solution(String s) {
        StringBuilder answer = new StringBuilder();
        StringBuilder numStr = new StringBuilder();

        Map<String, Integer> map = new HashMap<String, Integer>(){{
            put("zero", 0); put("one", 1);
            put("two", 2); put("three", 3);
            put("four", 4); put("five", 5);
            put("six", 6); put("seven", 7);
            put("eight", 8); put("nine", 9);
        }};

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                answer.append(ch);
            } else {
                numStr.append(ch);
            }

            Integer num = map.get(numStr.toString());
            if (num != null) {
                answer.append(num);
                numStr = new StringBuilder();
            }
        }

        return Integer.parseInt(answer.toString());
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution("one4seveneight")).isEqualTo(1478);
        softly.assertThat(solution("23four5six7")).isEqualTo(234567);
        softly.assertThat(solution("2three45sixseven")).isEqualTo(234567);
        softly.assertThat(solution("123")).isEqualTo(123);
        softly.assertAll();
    }
}
