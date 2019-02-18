package Array.No_414_Third_Maximum_Number;

import java.util.Arrays;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-02-18 10:51
 * Description: Third Maximum Number
 * <p>
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 * <p>
 * Example 1:
 * Input: [3, 2, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 * <p>
 * Output: 2
 * <p>
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 * <p>
 * Output: 1
 * <p>
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */
public class Solution {

    //分三次遍历
    public int thirdMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int m2 = Integer.MIN_VALUE;
        int m3 = Integer.MIN_VALUE;

        boolean flag = false;

        for (int num1 : nums) {
            if (num1 > max) {
                max = num1;
            }
        }
        for (int num : nums) {
            if (num < max && num > m2) {
                m2 = num;
            }
        }
        for (int num : nums) {
            if (num < m2 && num >= m3) {
                m3 = num;
                flag = true;
            }
        }
        if (flag) {
            return m3;
        } else {
            return max;
        }
    }
}
