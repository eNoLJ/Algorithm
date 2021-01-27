public class Result {

    static int saveThePrisoner(int n, int m, int s) {
        int prisonerNum = (m + s - 1) % n;
        return prisonerNum == 0 ? n : prisonerNum;
    }

    public static void main(String[] args) {
        System.out.println(saveThePrisoner(7, 19, 2)); // 6
        System.out.println(saveThePrisoner(3, 7, 3)); // 3
    }

}
