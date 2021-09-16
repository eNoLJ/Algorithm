import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.stream.LongStream;

public class CalculateTheShortfall {

    public long solution(int price, int money, int count) {
        long answer = 0;
        for (long i = 1; i <= count; i++) {
            answer += price * i;
        }
        answer -= money;
        return answer >= 0 ? answer : 0;
    }

    public long solution2(int price, int money, int count) {
        long answer = LongStream.rangeClosed(1, count).map(i -> i * price).sum() - money;
        return answer >= 0 ? answer : 0;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution2(3, 20, 4)).isEqualTo(10);
        softly.assertThat(solution2(3, 30, 4)).isEqualTo(0);
        softly.assertAll();
    }
}
