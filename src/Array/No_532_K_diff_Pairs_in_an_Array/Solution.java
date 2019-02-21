package Array.No_532_K_diff_Pairs_in_an_Array;

import java.util.Arrays;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-02-20 10:07
 * Description: K-diff Pairs in an Array
 * <p>
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 * <p>
 * Example 1:
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * Example 2:
 * Input:[1, 2, 3, 4, 5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * Example 3:
 * Input: [1, 3, 1, 5, 4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * Note:
 * The pairs (i, j) and (j, i) count as the same pair.
 * The length of the array won't exceed 10,000.
 * All the integers in the given input belong to the range: [-1e7, 1e7].
 */

public class Solution {
    // 161ms
    public int findPairs(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);//先排序
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[j] - nums[i]) == k) {
                    count++;
                    break;
                }
            }
            //遇到重复则跳过
            while (i < nums.length - 1 && nums[i] == nums[i + 1])
                i++;
        }
        return count;
    }

    //滑动窗口方法
    public int findPairs1(int[] nums, int k) {
        if ( k < 0 || nums.length <= 1 ) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        int leftPoint = 0;
        int rightPoint = 1;
        while (rightPoint < nums.length) {
            int leftNum = nums[leftPoint];
            int rightNum = nums[rightPoint];
            if (rightNum - leftNum < k) {
                //数小了
                rightPoint++;
            } else if (rightNum - leftNum > k) {
                //数大了
                leftPoint++;
            } else {
                count++;
                //如果是重复的 则 跳过
                while (leftPoint < nums.length && nums[leftPoint] == leftNum) {
                    leftPoint++;
                }
                //如果是重复的 则 跳过
                while (rightPoint < nums.length && nums[rightPoint] == rightNum) {
                    rightPoint++;
                }
            }
            if (rightPoint == leftPoint){
                rightPoint++;
            }
        }
        return count;
    }

}
