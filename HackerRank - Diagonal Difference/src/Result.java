import java.util.ArrayList;
import java.util.List;

public class Result {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int size = arr.size();
        int lTrNum = 0;
        int rTlNum = 0;

        for (int i = 0; i < size; i++) {
            lTrNum += arr.get(i).get(i);
            rTlNum += arr.get(i).get(size - i - 1);
        }

        return Math.abs(lTrNum - rTlNum);
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>() { {add(11); add(2); add(4);} };
        List<Integer> b = new ArrayList<>() { {add(4); add(5); add(6);} };
        List<Integer> c = new ArrayList<>() { {add(10); add(8); add(-12);} };
        List<List<Integer>> List = new ArrayList<>() { {add(a); add(b); add(c);} };

        System.out.println(diagonalDifference(List));
    }

}
