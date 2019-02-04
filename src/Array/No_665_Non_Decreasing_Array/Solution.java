package Array.No_665_Non_Decreasing_Array;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-02-01 10:11
 * Description: Non decreasing array
 * <p>
 * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
 * <p>
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 * <p>
 * Example 1:
 * Input: [4,2,3]
 * Output: True
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * Example 2:
 * Input: [4,2,1]
 * Output: False
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 * Note: The n belongs to [1, 10,000].
 */
public class Solution {
    public boolean checkPossibility(int[] nums) {
        int changeElement = 0;
        for (int i = 0; i + 1 < nums.length; i++) {
            if (nums[i] > nums[i + 1]) {
                changeElement++;
                //根据当前索引为i的位置
                // 判断前一个与后一个谁大谁小
                // 也就知道应该改变的是当前索引还是改变索引后一个元素了
                if (i > 0 && nums[i + 1] < nums[i - 1]) nums[i + 1] = nums[i];
                else nums[i] = nums[i + 1];
            }
        }
        return changeElement <= 1;
    }
}
