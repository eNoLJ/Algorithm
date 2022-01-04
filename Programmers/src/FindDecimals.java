import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class FindDecimals {

    public int solution(int n) {
        List<Integer> decimals = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (verifyDecimal(decimals, i)) {
                decimals.add(i);
            }
        }
        return decimals.size();
    }

    public boolean verifyDecimal(List<Integer> decimals, int n) {
        for (int decimal : decimals) {
            if (n % decimal == 0) {
                return false;
            }
            if (Math.sqrt(n) < decimal) {
                break;
            }
        }
        return true;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(10)).isEqualTo(4);
        softly.assertThat(solution(5)).isEqualTo(3);
        softly.assertThat(solution(15)).isEqualTo(6);
        softly.assertThat(solution(120)).isEqualTo(30);
        softly.assertThat(solution(121)).isEqualTo(30);
        softly.assertAll();
    }
}
