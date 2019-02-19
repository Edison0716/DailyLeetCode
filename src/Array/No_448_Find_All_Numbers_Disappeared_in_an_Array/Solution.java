package Array.No_448_Find_All_Numbers_Disappeared_in_an_Array;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-02-19 10:12
 * Description: Find all numbers disappeared in an array
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * <p>
 * Example:
 * <p>
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [5,6]
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> resArray = new ArrayList<>();

        //如果num[num[i] - 1] 是正数 则将其取反
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0)
                nums[index] = -nums[index];
        }

        //遍历 正数所在的位置 + 1 就是缺失的数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                resArray.add(i + 1);
        }

        return resArray;
    }


    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> resArray = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[nums[i] - 1]) {
                int tem = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tem;
                i--; //交换完以后 还得从当前这个数在来一遍
            }
        }


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                resArray.add(i + 1);
        }


        return resArray;
    }

}
