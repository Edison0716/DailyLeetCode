package Array.No_219_Contains_Duplicate_II;

import java.util.HashMap;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-02-18 10:08
 * Description: Contains Duplicate II
 * <p>
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 * <p>
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */
public class Solution {
    //时间换空间
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k < 0) return false;

        HashMap<Integer, Integer> container = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (container.containsKey(nums[i])) {
                if (i - container.get(nums[i]) <= k)
                    return true;
            }
            container.put(nums[i], i);
        }

        return false;
    }


    //空间底 耗时大
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        if (k < 0) return false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]){
                    if (j - i <= k)
                        return true;
                }
            }
        }
        return false;
    }

}
