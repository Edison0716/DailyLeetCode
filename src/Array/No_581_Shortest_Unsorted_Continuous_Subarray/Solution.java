package Array.No_581_Shortest_Unsorted_Continuous_Subarray;


/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-02-23 04:12
 * Description: Shortest Unsorted Continuous Subarray
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 * <p>
 * You need to find the shortest such subarray and output its length.
 * <p>
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 */
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int l = nums.length;
        int beg = -1;
        int end = -2;

        int min = nums[l - 1];
        int max = nums[0];

        for (int i = 0; i < l; i++) {
            min = Math.min(min, nums[l - 1 - i]); //从后往前找最小
            max = Math.max(max, nums[i]); //从前往后找最大

            if (min < nums[l - 1 - i]) {
                beg = l - 1 - i; //最小值所应该在的位置
            }

            if (max > nums[i]){
                end = i; //最大值所应该在的位置
            }
        }


        return end - beg + 1;
    }
}
