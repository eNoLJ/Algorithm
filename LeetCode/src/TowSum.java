import java.util.Arrays;

public class TowSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1 ; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
