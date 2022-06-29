import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BaekJoon15649 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        recursion(new int[m], 0, n, m);
    }

    private static void recursion(int[] sequence, int index, int n, int m) {
        if (m == 0) {
            System.out.println(Arrays.stream(sequence)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")));
        } else {
            for (int i = 1; i <= n; i++) {
                if (verifyArray(sequence, i)) {
                    continue;
                }
                sequence[index] = i;
                recursion(sequence, index + 1, n, m - 1);
                sequence[index] = 0;
            }
        }
    }

    private static boolean verifyArray(int[] sequence, int element) {
        for (int el : sequence) {
            if (el == element) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(run("3 1")).isEqualTo(
                "1\n" + "2\n" + "3\n");
        softly.assertThat(run("4 2")).isEqualTo(
                "1 2\n" + "1 3\n" + "1 4\n" +
                "2 1\n" + "2 3\n" + "2 4\n" +
                "3 1\n" + "3 2\n" + "3 4\n" +
                "4 1\n" + "4 2\n" + "4 3\n");
        softly.assertThat(run("4 4")).isEqualTo(
                "1 2 3 4\n" + "1 2 4 3\n" + "1 3 2 4\n" + "1 3 4 2\n" + "1 4 2 3\n" + "1 4 3 2\n" +
                "2 1 3 4\n" + "2 1 4 3\n" + "2 3 1 4\n" + "2 3 4 1\n" + "2 4 1 3\n" + "2 4 3 1\n" +
                "3 1 2 4\n" + "3 1 4 2\n" + "3 2 1 4\n" + "3 2 4 1\n" + "3 4 1 2\n" + "3 4 2 1\n" +
                "4 1 2 3\n" + "4 1 3 2\n" + "4 2 1 3\n" + "4 2 3 1\n" + "4 3 1 2\n" + "4 3 2 1\n");
        softly.assertAll();
    }

    public String run(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        main(new String[]{});
        return out.toString();
    }
}
