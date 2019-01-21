package Array.No_26_RemoveDuplicatesFromSortedArray;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-01-21 11:35
 * Description:
 * <p>
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Given nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * <p>
 * It doesn't matter what you leave beyond the returned length.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int curNum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[curNum] != nums[i]) {
                curNum++;
                nums[curNum] = nums[i];
            }
        }
        return curNum + 1;
    }
}
