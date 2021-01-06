import java.util.*;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] baseArr = {{10}, {1}, {6, 2, 4, 8}, {1, 3, 9, 7}, {6, 4}, {5}, {6}, {1, 7, 9, 3}, {6, 8, 4, 2}, {1, 9}};

        for (int i = 0; i < num; i++) {
            int base = sc.nextInt() % 10;
            int power = sc.nextInt();
            int index = power % baseArr[base].length;
            int value = baseArr[base][index];

            System.out.println(value);
        }
    }

}
