import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

public class BaekJoon9012 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        for (int i = 0; i < length; i++) {
            String[] brackets = sc.next().split("");
            int count = 0;
            for (String bracket : brackets) {
                if (bracket.equals("(")) {
                    count++;
                } else if (bracket.equals(")")) {
                    count--;
                }
                if (count < 0) {
                    break;
                }
            }
            System.out.println(count == 0 ? "YES" : "NO");
        }
    }

    @Test
    public void test() {
        String input;
        OutputStream out;
        InputStream in;

        input = "6\n" +
                "(())())\n" +
                "(((()())()\n" +
                "(()())((()))\n" +
                "((()()(()))(((())))()\n" +
                "()()()()(()()())()\n" +
                "(()((())()(";
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        main(new String[]{});
        Assertions.assertThat(out.toString()).isEqualTo(
                "NO\n" +
                "NO\n" +
                "YES\n" +
                "NO\n" +
                "YES\n" +
                "NO\n");


        input = "3\n" +
                "((\n" +
                "))\n" +
                "())(()";
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        main(new String[]{});
        Assertions.assertThat(out.toString()).isEqualTo(
                "NO\n" +
                "NO\n" +
                "NO\n");
    }
}
