import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BaekJoon15652 {

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
                if (index != 0 && sequence[index - 1] > i) {
                    continue;
                }
                sequence[index] = i;
                recursion(sequence, index + 1, n, m - 1);
            }
        }
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(run("3 1")).isEqualTo(
                "1\n" + "2\n" + "3\n");
        softly.assertThat(run("4 2")).isEqualTo(
                "1 1\n" + "1 2\n" + "1 3\n" + "1 4\n" +
                "2 2\n" + "2 3\n" + "2 4\n" +
                "3 3\n" + "3 4\n" +
                "4 4\n");
        softly.assertThat(run("3 3")).isEqualTo(
                "1 1 1\n" + "1 1 2\n" + "1 1 3\n" + "1 2 2\n" + "1 2 3\n" + "1 3 3\n" +
                "2 2 2\n" + "2 2 3\n" + "2 3 3\n" +
                "3 3 3\n");
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
