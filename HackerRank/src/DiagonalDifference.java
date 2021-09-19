import java.util.ArrayList;
import java.util.List;

public class DiagonalDifference {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int lTrNum = 0;
        int rTlNum = 0;

        for (int i = 0; i < arr.size(); i++) {
            lTrNum += arr.get(i).get(i);
            rTlNum += arr.get(i).get(arr.size() - i - 1);
        }

        return Math.abs(lTrNum - rTlNum);
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>() { {add(11); add(2); add(4);} };
        List<Integer> b = new ArrayList<Integer>() { {add(4); add(5); add(6);} };
        List<Integer> c = new ArrayList<Integer>() { {add(10); add(8); add(-12);} };
        List<List<Integer>> List = new ArrayList<List<Integer>>() { {add(a); add(b); add(c);} };

        System.out.println(diagonalDifference(List)); // 15
    }
}
