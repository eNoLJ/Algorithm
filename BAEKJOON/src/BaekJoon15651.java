import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BaekJoon15651 {

    private static final StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        helper(new int[m], 0, n, m);
        System.out.println(result);
    }

    private static void helper(int[] sequence, int index, int n, int m) {
        if (m == 0) {
            result.append(Arrays.stream(sequence)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")));
            result.append("\n");
        } else {
            for (int i = 1; i <= n; i++) {
                sequence[index] = i;
                helper(sequence, index + 1, n, m - 1);
            }
        }
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(run("3 1")).isEqualTo("1\n" + "2\n" + "3\n" + "\n");
        result.setLength(0);
        softly.assertThat(run("4 2")).isEqualTo(
                "1 1\n" + "1 2\n" + "1 3\n" + "1 4\n" +
                "2 1\n" + "2 2\n" + "2 3\n" + "2 4\n" +
                "3 1\n" + "3 2\n" + "3 3\n" + "3 4\n" +
                "4 1\n" + "4 2\n" + "4 3\n" + "4 4\n" + "\n");
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
