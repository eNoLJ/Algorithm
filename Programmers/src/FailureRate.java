import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class FailureRate {

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] failureRate = new double[N];

        for (int i = 0; i < N; i++) {
            double challengePlayers = 0;
            double reachedPlayers = 0;
            for (int stage : stages) {
                if (stage == i + 1) {
                    challengePlayers++;
                    reachedPlayers++;
                }
                if (stage > i + 1) {
                    reachedPlayers++;
                }
            }
            if (challengePlayers != 0) {
                failureRate[i] = challengePlayers / reachedPlayers;
            } else {
                failureRate[i] = 0;
            }
        }

        for (int i = 0; i < N; i++) {
            int failureRateIndex = -1;
            double highestFailureRate = -1;
            for (int j = 0; j < failureRate.length; j++) {
                if (failureRate[j] > highestFailureRate) {
                    failureRateIndex = j;
                    highestFailureRate = failureRate[j];
                }
            }
            answer[i] = failureRateIndex + 1;
            failureRate[failureRateIndex] = -1;
        }

        return answer;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})).isEqualTo(new int[]{3, 4, 2, 1, 5});
        softly.assertThat(solution(4, new int[]{4, 4, 4, 4, 4})).isEqualTo(new int[]{4, 1, 2, 3});
        softly.assertThat(solution(4, new int[]{2, 2, 2, 2, 2})).isEqualTo(new int[]{2, 1, 3, 4});
        softly.assertAll();
    }
}
