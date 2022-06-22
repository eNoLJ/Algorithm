package levelOne;

import java.util.*;
import java.util.stream.Collectors;

public class GymSuit {

    public static int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostList = Arrays.stream(lost)
                .filter(num -> Arrays.stream(reserve).noneMatch(i -> i == num))
                .boxed()
                .collect(Collectors.toList());

        List<Integer> reserveList = Arrays.stream(reserve)
                .filter(num -> Arrays.stream(lost).noneMatch(i -> i == num))
                .boxed()
                .collect(Collectors.toList());

        lostList = lostList.stream()
                .filter(loster -> {
                    int index;
                    if ((index = reserveList.indexOf(loster - 1)) != -1 ||
                        (index = reserveList.indexOf(loster + 1)) != -1
                    ) {
                        reserveList.remove(index);
                    }
                    return index == -1; })
                .collect(Collectors.toList());

        return n - lostList.size();
    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int[] {2, 4}, new int[] {1, 3, 5})); // 5
        System.out.println(solution(5, new int[] {2, 4}, new int[] {3})); // 4
        System.out.println(solution(3, new int[] {3}, new int[] {1})); // 2
        System.out.println(solution(3, new int[] {1, 2}, new int[] {2, 3})); // 2
    }
}
