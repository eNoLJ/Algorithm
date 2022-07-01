import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

public class BaekJoon14888 {

    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        int[] operators = new int[4];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }

        recursion(n - 1, 0, numbers[0], numbers, operators);
        System.out.println(max + "\n" + min);
    }

    private static void recursion(int n, int index, int value, int[] numbers, int[] operator) {
        if (n == 0) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for (int i = 0; i < 4; i++) {
                if (operator[i] > 0) {
                    operator[i]--;
                    recursion(n - 1, index + 1, calculator(value, i, numbers[index + 1]), numbers, operator);
                    operator[i]++;
                }
            }
        }
    }

    private static int calculator(int num1, int operator, int num2) {
        switch (operator) {
            case 0: return num1 + num2;
            case 1: return num1 - num2;
            case 2: return num1 * num2;
            case 3: return num1 / num2;
            default: return 0;
        }
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(run("2\n" + "5 6\n" + "0 0 1 0")).isEqualTo("30\n" + "30\n");
        softly.assertThat(run("3\n" + "3 4 5\n" + "1 0 1 0")).isEqualTo("35\n" + "17\n");
        softly.assertThat(run("6\n" + "1 2 3 4 5 6\n" + "2 1 1 1")).isEqualTo("54\n" + "-24\n");
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
