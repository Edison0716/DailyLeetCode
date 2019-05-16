package String.easy.No_136_Single_Number;


import java.util.Arrays;
import java.util.HashMap;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-05-16 19:40
 * Description:
 * <p>
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,1,2,1,2]
 * Output: 4
 */

public class Solution {


    //任何数与0异或都为其本身
    //两个相同数字异或等于零
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i : nums) {
            result ^= i;
        }
        return result;
    }


    private HashMap<Integer, Integer> container = new HashMap<>();

    public int singleNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (container.containsKey(nums[i]))
                container.put(nums[i], container.get(nums[i]) + 1);
            else
                container.put(nums[i], 1);
        }

        int res = -1;

        for (int i = 0; i < nums.length; i++) {
            if (container.get(nums[i]) == 1){
                res = nums[i];
            }
        }

        return res;
    }
}