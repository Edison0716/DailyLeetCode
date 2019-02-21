package Array.No_485_Max_Consecutive_Ones;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-02-21 10:38
 * Description: Max Consecutive Ones
 * <p>
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * <p>
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 * Note:
 * <p>
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxTimes = 0;
        int tem = 0;
        for (int num : nums) {
            if (num != 0) {
                tem = tem + 1;
            } else {
               tem = 0;
            }
            maxTimes = Math.max(maxTimes, tem);
        }
        return maxTimes;
    }
}
