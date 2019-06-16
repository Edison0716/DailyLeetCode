package Array.No_15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/6/10 17:19
 * Description:
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * Difficulty: Medium
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //先进行排序
        Arrays.sort(nums);
        List<List<Integer>> resArray = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                //分成两个区域
                int startArea = i + 1, endArea = nums.length - 1, sum = 0 - nums[i];
                while (startArea < endArea) {
                    if (nums[startArea] + nums[endArea] == sum) {
                        resArray.add(Arrays.asList(nums[i], nums[startArea], nums[endArea]));
                        while (startArea < endArea && nums[startArea] == nums[startArea + 1]) startArea++;
                        while (startArea < endArea && nums[endArea] == nums[endArea - 1]) endArea--;
                        startArea++;
                        endArea--;
                    } else if (nums[startArea] + nums[endArea] < sum) {
                        startArea++;
                    } else {
                        endArea--;
                    }
                }
            }
        }
        return resArray;
    }
}
