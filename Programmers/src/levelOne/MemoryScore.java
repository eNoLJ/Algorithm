package levelOne;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MemoryScore {

    public int[] solution(String[] name, int[] yearning, String[][] photos) {
        int[] answer = {};
        Map<String, Integer> nameYearning = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            nameYearning.put(name[i], yearning[i]);
        }

         return Arrays.stream(photos)
                 .mapToInt(photo -> Arrays.stream(photo)
                         .filter(nameYearning::containsKey)
                         .mapToInt(nameYearning::get)
                         .sum())
                 .toArray();
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(new String[]{"may", "kein", "kain", "radi"},
                new int[]{5, 10, 1, 3},
                new String[][]{{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}}))
                .isEqualTo(new int[]{19, 15, 6});
        softly.assertThat(solution(new String[]{"kali", "mari", "don"},
                        new int[]{11, 1, 55},
                        new String[][]{{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}}))
                .isEqualTo(new int[]{67, 0, 55});
        softly.assertThat(solution(new String[]{"may", "kein", "kain", "radi"},
                        new int[]{5, 10, 1, 3},
                        new String[][]{{"may"},{"kein", "deny", "may"}, {"kon", "coni"}}))
                .isEqualTo(new int[]{5, 15, 0});
        softly.assertAll();
    }
}
