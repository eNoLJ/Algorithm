import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon1107 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int targetChannel = sc.nextInt();
        int m = sc.nextInt();
        int moveCount = Math.abs(100 - targetChannel);

        if (m == 0) {
            System.out.println(Math.min(moveCount, Integer.toString(targetChannel).split("").length));
            return;
        }

        sc.nextLine();
        String[] brokenButtons = sc.nextLine().split(" ");
        int maxNumber = getMaxNumber(targetChannel, brokenButtons);
        int minNumber = getMinNumber(targetChannel, brokenButtons);

        if (maxNumber == 1000001 && minNumber == -1) {
            System.out.println(moveCount);
        } else if (maxNumber == 1000001) {
            System.out.println(Math.min(moveCount, getMoveCount(targetChannel, minNumber)));
        } else if (minNumber == -1) {
            System.out.println(Math.min(moveCount, getMoveCount(targetChannel, maxNumber)));
        } else {
            int[] result = new int[]{moveCount, getMoveCount(targetChannel, maxNumber), getMoveCount(targetChannel, minNumber)};
            Arrays.sort(result);
            System.out.println(result[0]);
        }
    }

    public static int getMoveCount(int targetChannel, int currentChannel) {
        int digit = Integer.toString(currentChannel).split("").length;
        return digit + Math.abs(targetChannel - currentChannel);
    }

    public static int getMaxNumber(int targetChannel, String[] brokenButtons) {
        while (targetChannel <= 1000000) {
            String[] targetChannels = Integer.toString(targetChannel).split("");
            if (helper(targetChannels, brokenButtons)) {
                break;
            }
            targetChannel++;
        }
        return targetChannel;
    }

    public static int getMinNumber(int targetChannel, String[] brokenButtons) {
        while (targetChannel >= 0) {
            String[] targetChannels = Integer.toString(targetChannel).split("");
            if (helper(targetChannels, brokenButtons)) {
                break;
            }
            targetChannel--;
        }
        return targetChannel;
    }

    public static boolean helper(String[] targetChannels, String[] brokenButtons) {
        for (String targetChannel : targetChannels) {
            for (String brokenButton : brokenButtons) {
                if (targetChannel.equals(brokenButton)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(run("5457\n" + "0\n")).isEqualTo("4\n");
        softly.assertThat(run("5457\n" + "3\n" + "6 7 8")).isEqualTo("6\n");
        softly.assertThat(run("100\n" + "5\n" + "0 1 2 3 4")).isEqualTo("0\n");
        softly.assertThat(run("500000\n" + "8\n" + "0 2 3 4 6 7 8 9")).isEqualTo("11117\n");
        softly.assertThat(run("99\n" + "2\n" + "9 8")).isEqualTo("1\n");
        softly.assertThat(run("1555\n" + "8\n" + "0 1 3 4 5 6 7 9")).isEqualTo("670\n");
        softly.assertThat(run("101\n" + "3\n" + "4 5 6")).isEqualTo("1\n");
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
