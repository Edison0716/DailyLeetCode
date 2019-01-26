package Array.No_88_MergeSortedArray;


/**
 * FileName: Solution
 * Author:
 * Date:     2019-01-26 15:18
 * Description: Merge Sorted Array
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int indexM = m - 1;
        int indexN = n - 1;
        int index = m + n - 1;

        while (indexM >= 0 && indexN >= 0) {
            if (nums1[indexM] >= nums2[indexN]) {
                nums1[index--] = nums1[indexM--];
            } else {
                nums1[index--] = nums2[indexN--];
            }
        }

        while (indexN >= 0) {
            nums1[index--] = nums2[indexN--];
        }
    }
}
