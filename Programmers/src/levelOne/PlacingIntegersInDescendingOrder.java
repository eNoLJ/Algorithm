package levelOne;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class PlacingIntegersInDescendingOrder {

    public long solution(long n) {
        String[] numberArr = String.valueOf(n).split("");
        Arrays.sort(numberArr, Collections.reverseOrder());
        return Long.parseLong(String.join("", numberArr));
    }

    public long solution2(long n) {
        return Long.parseLong(Arrays.stream(String.valueOf(n).split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(""))
        );
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(118372)).isEqualTo(873211);
        softly.assertThat(solution2(118372)).isEqualTo(873211);
        softly.assertAll();
    }
}
