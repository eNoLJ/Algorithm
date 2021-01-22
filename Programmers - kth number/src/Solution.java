import java.util.Arrays;

public class Solution {

    public static int[] solution(int[] array, int[][] commands) {
        return Arrays.stream(commands).mapToInt(command -> {
            int[] copyCommand = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(copyCommand);
            return copyCommand[command[2] - 1];
        }).toArray();
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(Arrays.toString(solution(array, commands)));
    }

}
