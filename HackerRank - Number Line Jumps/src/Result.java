public class Result {

    static String kangaroo(int x1, int v1, int x2, int v2) {
        int[] frontKangaroo = x1 >= x2 ? new int[] {x1, v1} : new int[] {x2, v2};
        int[] backKangaroo = x1 >= x2 ? new int[] {x2, v2} : new int[] {x1, v1};

        while (frontKangaroo[0] >= backKangaroo[0]) {
            if (frontKangaroo[0] == backKangaroo[0]) {
                return "YES";
            }

            frontKangaroo[0] += frontKangaroo[1];
            backKangaroo[0] += backKangaroo[1];
        }

        return "NO";
    }

    public static void main(String[] args) {
        System.out.println(kangaroo(0, 3, 4, 2));
        System.out.println(kangaroo(0, 2, 5, 3));
    }

}
