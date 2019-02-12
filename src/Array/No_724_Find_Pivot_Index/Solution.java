package Array.No_724_Find_Pivot_Index;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-02-12 08:51
 * Description: Find Pivot Index
 * <p>
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 * <p>
 * We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
 * <p>
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 * Explanation:
 * The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
 * Also, 3 is the first index where this occurs.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input:
 * nums = [1, 2, 3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 * <p>
 * <p>
 * Note:
 * <p>
 * The length of nums will be in the range [0, 10000].
 * Each element nums[i] will be an integer in the range [-1000, 1000].
 */
public class Solution {
    public int pivotIndex(int[] nums) {
        int arrLength = nums.length;
        int arrSum = 0;
        int leftSum = 0;

        for (int num : nums) arrSum += num;

        for (int i = 0; i < arrLength; ++i) {
            if (arrSum - nums[i] - leftSum == leftSum) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}
