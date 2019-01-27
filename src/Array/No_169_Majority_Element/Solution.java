package Array.No_169_Majority_Element;

import java.util.Arrays;

/**
 * FileName: Solution
 * Author:
 * Date:     2019-01-27 09:58
 * Description: Majority_Element
 * <p>
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class Solution {
    public int majorityElement(int[] nums) {

        if (nums.length == 0)
            throw new IllegalArgumentException("Array is empty!");


        int index = 0;
        for (int i = 0; i < nums.length; i++) {

            int times = 1;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    times++;
                }
            }

            if (times > nums.length / 2) {
                index = i;
                break;
            }
        }

        return nums[index];
    }

    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    public int majorityElement2(int[] nums) {
        int res = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                res = num;
            }

            if (res != num) {
                count--;
            } else {
                count++;
            }

        }
        return res;
    }


}
