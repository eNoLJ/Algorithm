import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class TheHighestAndLowestRanksOfTheLottery {

    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCount = (int) Arrays.stream(lottos).filter(lotto -> lotto == 0).count();
        int sameNumberCount = (int) Arrays.stream(lottos).filter(lotto -> checkNumber(lotto, win_nums)).count();
        return new int[]{convertNumberToRank(sameNumberCount + zeroCount), convertNumberToRank(sameNumberCount)};
    }

    private boolean checkNumber(int lotto, int[] win_nums) {
        return Arrays.stream(win_nums).filter(win_num -> win_num == lotto).anyMatch(win_num -> win_num > 0);
    }

    private int convertNumberToRank(int number) {
        int rank = Math.abs(7 - number);
        return rank < 7 ? rank : 6;
    }

    @Test
    public void test() {
        int[][] lottos = new int[][]{{44, 1, 0, 0, 31, 25}, {0, 0, 0, 0, 0, 0}, {45, 4, 35, 20, 3, 9}};
        int[][] win_nums = new int[][]{{31, 10, 45, 1, 6, 19}, {38, 19, 20, 40, 15, 25}, {20, 9, 3, 45, 4, 35}};
        int[][] expectedResult = new int[][]{{3, 5}, {1, 6}, {1, 1}};
        IntStream.range(0, expectedResult.length)
                .forEach(i -> assertThat(solution(lottos[i], win_nums[i])).isEqualTo(expectedResult[i]));
    }
}
