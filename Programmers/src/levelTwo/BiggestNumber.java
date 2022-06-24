package levelTwo;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BiggestNumber {

    public String solution(int[] numbers) {
        String answer =  Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((a, b) -> Integer.parseInt(b + a) - Integer.parseInt(a + b))
                .collect(Collectors.joining());

        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(new int[]{6, 10, 2})).isEqualTo("6210");
        softly.assertThat(solution(new int[]{3, 30, 34, 5, 9})).isEqualTo("9534330");
        softly.assertThat(solution(new int[]{3, 5, 9})).isEqualTo("953");
        softly.assertThat(solution(new int[]{10, 104, 103})).isEqualTo("10410310");
        softly.assertThat(solution(new int[]{52, 525})).isEqualTo("52552");
        softly.assertThat(solution(new int[]{12, 121})).isEqualTo("12121");
        softly.assertThat(solution(new int[]{101, 10, 232, 23})).isEqualTo("2323210110");
        softly.assertThat(solution(new int[]{0, 0})).isEqualTo("0");
        softly.assertAll();
    }
}
