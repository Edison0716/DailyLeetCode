package Array.No_169_Majority_Element;

import java.util.Arrays;

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


        for (int num:nums){
            if (count == 0){
                res = num;
            }

            if (res!=num){
                count--;
            }else {
                count++;
            }

        }
        return res;
    }


}
