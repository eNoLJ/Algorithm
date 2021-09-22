import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class FindKimSeobangInSeoul {

    public String solution(String[] seoul) {
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                return "김서방은 " + i + "에 있다";
            }
        }
        return "";
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(new String[]{"Jane", "Kim"})).isEqualTo("김서방은 1에 있다");
        softly.assertAll();
    }
}
