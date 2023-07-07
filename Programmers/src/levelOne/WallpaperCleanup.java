package levelOne;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class WallpaperCleanup {

    public int[] solution(String[] wallpaper) {
        int[] minS = new int[]{50, 50};
        int[] maxS = new int[]{0, 0};

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {

                if (wallpaper[i].charAt(j) == '#') {
                    minS[0] = Math.min(minS[0], i);
                    minS[1] = Math.min(minS[1], j);
                    maxS[0] = Math.max(maxS[0], i);
                    maxS[1] = Math.max(maxS[1], j);
                }
            }
        }

        return new int[]{minS[0], minS[1], maxS[0] + 1, maxS[1] + 1};
    }

    @Test
    void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(solution(new String[]{".#...", "..#..", "...#."})).isEqualTo(new int[]{0, 1, 3, 4});
        softly.assertThat(solution(new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."})).isEqualTo(new int[]{1, 3, 5, 8});
        softly.assertThat(solution(new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."})).isEqualTo(new int[]{0, 0, 7, 9});
        softly.assertThat(solution(new String[]{"..", "#."})).isEqualTo(new int[]{1, 0, 2, 1});
        softly.assertAll();
    }
}
