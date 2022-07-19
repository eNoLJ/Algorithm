import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

public class BaekJoon9663 {

    private static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        recursion(board, 0);
        System.out.println(result);
    }

    private static void recursion(int[][] board, int column) {
        if (column == board.length) {
            result++;
        } else {
            for (int i = 0; i < board.length; i++) {
                if (verifyLocation(board, column, i)) {
                    board[column][i] = 1;
                    recursion(board, column + 1);
                    board[column][i] = 0;
                }
            }
        }
    }

    private static boolean verifyLocation(int[][] board, int column, int row) {
        int interval;

        for (int i = 0; i < board.length; i++) {
            interval = Math.abs(i - column);
            if ((board[column][i] == 1 || board[i][row] == 1) ||
                    (row + interval < board.length && board[i][row + interval] == 1) ||
                    (row - interval >= 0 && board[i][row - interval] == 1)) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(run("8")).isEqualTo("92\n");
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
