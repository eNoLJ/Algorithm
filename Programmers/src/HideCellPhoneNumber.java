import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HideCellPhoneNumber {

    public String solution(String phoneNumber) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < phoneNumber.length(); i++) {
            answer.append((i < phoneNumber.length() - 4) ? "*" : phoneNumber.charAt(i));
        }
        return answer.toString();
    }

    public String solution2(String phoneNumber) {
        return IntStream.range(0, phoneNumber.length())
                .mapToObj(i -> (i < phoneNumber.length() - 4) ? "*" : phoneNumber.charAt(i))
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution2("01033334444")).isEqualTo("*******4444");
        softly.assertThat(solution2("027778888")).isEqualTo("*****8888");
        softly.assertAll();
    }
}
