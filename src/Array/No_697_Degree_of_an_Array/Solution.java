package Array.No_697_Degree_of_an_Array;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-02-11 18:23
 * Description: Degree of an Array
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 * <p>
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 * <p>
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * Note:
 * <p>
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 */
public class Solution {
    public int findShortestSubArray(int[] nums) {
        int minLength = 50000;
        int curLength;
        int maxFrequency = 0;

        int[] frequency = new int[50001];
        int[] pos = new int[50001];

        if (nums.length == 1) return 1;

        for (int i = 1; i < nums.length + 1; i++) {
            if (pos[nums[i - 1]] != 0) {
                frequency[nums[i - 1]]++;
                curLength = i - pos[nums[i - 1]] + 1;
                if (frequency[nums[i - 1]] > maxFrequency) {
                    maxFrequency = frequency[nums[i - 1]];
                    minLength = curLength;
                } else if (frequency[nums[i - 1]] == maxFrequency) {
                    minLength = curLength < minLength ? curLength : minLength;
                }
            } else {
                pos[nums[i - 1]] = i;
            }
        }
        if (maxFrequency == 0) {
            return 1;
        }
        return minLength;
    }
}
