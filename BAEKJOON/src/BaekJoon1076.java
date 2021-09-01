import java.util.*;

public class BaekJoon1076 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> colors = new ArrayList<>(Arrays.asList("black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"));

        System.out.println(
                (colors.indexOf(sc.next()) * 10L + colors.indexOf(sc.next())) * (long)Math.pow(10, colors.indexOf(sc.next()))
        );
    }
}
