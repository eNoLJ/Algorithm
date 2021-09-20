import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BaekJoon1966 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCount = sc.nextInt();

        for (int i = 0; i < testCount; i++) {
            int documentCount = sc.nextInt();
            int targetDocumentIndex = sc.nextInt();
            List<Integer> documentList = new LinkedList<>();

            for (int j = 0; j < documentCount; j++) {
                documentList.add(sc.nextInt());
            }

            int count = 1;
            while (!documentList.isEmpty()) {
                if (checkBigNumber(documentList)) {
                    if (targetDocumentIndex == 0) {
                        System.out.println(count);
                        break;
                    }
                    count++;
                    targetDocumentIndex--;
                } else {
                    if (targetDocumentIndex == 0) {
                        targetDocumentIndex = documentList.size() - 1;
                    } else {
                        targetDocumentIndex--;
                    }
                    documentList.add(documentList.get(0));
                }
                documentList.remove(0);
            }
        }
    }

    public static boolean checkBigNumber(List<Integer> documentList) {
        int firstNumber = documentList.get(0);
        for (int i = 1; i < documentList.size(); i++) {
            if (firstNumber < documentList.get(i)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(run(
                "3\n" +
                "1 0\n" +
                "5\n" +
                "4 2\n" +
                "1 2 3 4\n" +
                "6 0\n" +
                "1 1 9 1 1 1"))
                .isEqualTo(
                "1\n" +
                "2\n" +
                "5\n");
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
