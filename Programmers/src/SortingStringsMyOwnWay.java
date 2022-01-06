import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class SortingStringsMyOwnWay {

    public String[] solution(String[] strings, int n) {
        Map<Character, List<String>> hashStrings = new HashMap<>();
        for (String string : strings) {
            hashStrings.computeIfAbsent(string.charAt(n), k -> new ArrayList<>());
            List<String> hashString = hashStrings.get(string.charAt(n));
            hashString.add(string);
        }

        Character[] keys = hashStrings.keySet().toArray(new Character[hashStrings.size() - 1]);
        Arrays.sort(keys);
        List<String> answer = new ArrayList<>();

        for (Character key : keys) {
            Collections.sort(hashStrings.get(key));
            answer.addAll(hashStrings.get(key));
        }

        return answer.toArray(new String[answer.size() - 1]);
    }

    public String[] solution2(String[] strings, int n) {
        return Arrays.stream(strings).map(string -> string.charAt(n) + string)
                .sorted()
                .map(string -> string.substring(1))
                .toArray(String[]::new);
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution2(new String[]{"sun", "bed", "car"}, 1)).isEqualTo(new String[]{"car", "bed", "sun"});
        softly.assertThat(solution2(new String[]{"abce", "abcd", "cdx"}, 2)).isEqualTo(new String[]{"abcd", "abce", "cdx"});
        softly.assertAll();
    }
}
