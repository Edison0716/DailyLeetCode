package Array.No_1_TwoSum;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-01-18 15:13
 * Description:
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int num2 = nums[j];
                if (num1 + num2 == target) {
                    int[] numss = new int[2];
                    numss[0] = num1;
                    numss[1] = num2;
                    return numss;
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
