package levelOne;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class ParkWalk {

    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        for (String route : routes) {
            char way = route.charAt(0);
            int distance = Character.getNumericValue(route.charAt(2));

            if ((way == 'E' && answer[1] + distance > park[0].length() - 1) ||
                    (way == 'W' && answer[1] - distance < 0) ||
                    (way == 'S' && answer[0] + distance > park.length - 1) ||
                    (way == 'N' && answer[0] - distance < 0)) {
                continue;
            }

            for (int i = 1; i <= distance; i++) {
                if ((way == 'E' && park[answer[0]].charAt(answer[1] + i) == 'X') ||
                        (way == 'W' && park[answer[0]].charAt(answer[1] - i) == 'X') ||
                        (way == 'S' && park[answer[0] + i].charAt(answer[1]) == 'X') ||
                        (way == 'N' && park[answer[0] - i].charAt(answer[1]) == 'X')) {
                    break;
                }

                if (distance == i) {
                    if (way == 'E') {
                        answer[1] = answer[1] + distance;
                    }

                    if (way == 'W') {
                        answer[1] = answer[1] - distance;
                    }

                    if (way == 'S') {
                        answer[0] = answer[0] + distance;
                    }

                    if (way == 'N') {
                        answer[0] = answer[0] - distance;
                    }
                }
            }
        }

        return answer;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(new String[]{"SOO", "OOO", "OOO"}, new String[]{"E 2", "S 2", "W 1"}))
                .isEqualTo(new int[]{2, 1});
        softly.assertThat(solution(new String[]{"SOO", "OXX", "OOO"}, new String[]{"E 2", "S 2", "W 1"}))
                .isEqualTo(new int[]{0, 1});
        softly.assertThat(solution(new String[]{"OSO", "OOO", "OXO", "OOO"}, new String[]{"E 2", "S 3", "W 1"}))
                .isEqualTo(new int[]{0, 0});
        softly.assertThat(solution(new String[]{"OXXO", "XSXO", "XXXX"}, new String[]{"E 1", "S 1"}))
                .isEqualTo(new int[]{1, 1});
        softly.assertThat(solution(new String[]{"OOO", "OSO", "OOO", "OOO"}, new String[]{"N 2", "S 2"}))
                .isEqualTo(new int[]{3, 1});
        softly.assertAll();
    }
}
