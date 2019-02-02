package Array.No_268_Missing_Number;

import java.util.Arrays;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-02-02 10:21
 * Description: Missing Number
 * <p>
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class Solution {

    //数组肯定是少一位元素 所以使用高斯算法 用（length + 1）减去原有的 的元素之和就是空缺的元素
    public int missingNumber(int[] nums) {
        int sum = 0;
        int len = nums.length;
        int expectedSum = (len) * (len + 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        return (expectedSum - sum);
    }

    public int missingNumber1(int[] nums) {
        //先排序 之后临位相减
        if (nums.length == 0) {
            throw new IllegalArgumentException("Array is empty.");
        }

        if (nums.length == 1) {

            if (nums[0] == 0) {
                return 1;
            } else {
                return nums[0] - 1;
            }

        } else {
            //sortArray(nums);

            Arrays.sort(nums);

            for (int i = 0; i < nums.length; i++) {
                if (i + 1 == nums.length) {
                    return nums[i] + 1;
                } else if (nums[0] != 0) {
                    return nums[0] - 1;
                } else if (nums[i + 1] - nums[i] > 1) {
                    return nums[i] + 1;
                }
            }
            throw new IllegalArgumentException("Array have not missing numbers.");
        }
    }

    //插入排序
    private int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    //交换元素
                    int m = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = m;
                }
            }
        }
        return nums;
    }
}
