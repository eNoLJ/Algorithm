package levelOne;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class KeypadPress {

    public String solution(int[] numbers, String hand) {
        String result = "";
        int leftHandLocation = 10;
        int rightHandLocation = 12;
        for (int number : numbers) {
            if (number == 0) {
                number = 11;
            }
            if (number == 1 || number == 4 || number == 7) {
                result += "L";
                leftHandLocation = number;
                continue;
            }
            if (number == 3 || number == 6 || number == 9) {
                result += "R";
                rightHandLocation = number;
                continue;
            }
            if (getDistance(number, leftHandLocation) > getDistance(number, rightHandLocation)) {
                result += "R";
                rightHandLocation = number;
            }
            if (getDistance(number, leftHandLocation) < getDistance(number, rightHandLocation)) {
                result += "L";
                leftHandLocation = number;
            }
            if (getDistance(number, leftHandLocation) == getDistance(number, rightHandLocation)) {
                if (hand.equals("left")) {
                    result += "L";
                    leftHandLocation = number;
                }
                if (hand.equals("right")) {
                    result += "R";
                    rightHandLocation = number;
                }
            }
        }
        return result;
    }

    public int getDistance(int number, int location) {
        int distance = Math.abs(number - location);
        if (distance == 1 || distance == 3) {
            distance = 1;
        }
        if (distance == 2 || distance == 4 || distance == 6) {
            distance = 2;
        }
        if (distance == 5 || distance == 7 || distance == 9) {
            distance = 3;
        }
        if (distance == 8 || distance == 10) {
            distance = 4;
        }
        if (distance == 11) {
            distance = 5;
        }
        return distance;
    }

    @Test
    public void test() {
        int[][] numbers = new int[][]{
                {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},
                {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}};
        String[] hands = {"right", "left", "right"};
        String[] expectedResult = {"LRLLLRLLRRL", "LRLLRRLLLRR", "LLRLLRLLRL"};
        IntStream.range(0, expectedResult.length)
                .forEach(i -> assertThat(solution(numbers[i], hands[i])).isEqualTo(expectedResult[i]));
    }
}
