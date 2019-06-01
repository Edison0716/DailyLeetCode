package Array.No_78_Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * FileName: Solution
 * Author:   EdisonLi的MacBook pro
 * Date:     2019/06/01 21：45
 * Description:
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> resChild = new ArrayList<>();
        //先进行排序
        Arrays.sort(nums);

        handleArray(res, resChild, nums, nums.length, 0);

        return res;
    }

    private void handleArray(List<List<Integer>> res, List<Integer> resChild, int[] nums, int length, int start) {
        //加入一次
        res.add(new ArrayList<>(resChild));
        for (int i = start; i < length; i++) {
            resChild.add(nums[i]);
            handleArray(res,resChild,nums,length,i + 1);
            System.out.println(resChild);
            resChild.remove(resChild.size() - 1);
        }
    }
}
