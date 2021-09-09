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
        String result;

        input = "6\n" +
                "(())())\n" +
                "(((()())()\n" +
                "(()())((()))\n" +
                "((()()(()))(((())))()\n" +
                "()()()()(()()())()\n" +
                "(()((())()(";
        result = "NO\n" +
                "NO\n" +
                "YES\n" +
                "NO\n" +
                "YES\n" +
                "NO\n";
        Assertions.assertThat(run(input)).isEqualTo(result);

        input = "3\n" +
                "((\n" +
                "))\n" +
                "())(()";
        result = "NO\n" +
                "NO\n" +
                "NO\n";
        Assertions.assertThat(run(input)).isEqualTo(result);
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
