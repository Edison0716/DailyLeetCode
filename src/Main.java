import Array.No_1_TwoSum.Solution;

public class Main {


    public static void main(String[] args) {
        System.out.println("Hello World!");

        int[] nums = new int[4];
        nums[0] = 2;
        nums[1] = 7;
        nums[2] = 11;
        nums[3] = 15;

        Solution solution = new Solution();
        int[] ints = solution.twoSum(nums, 13);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}
