package Array.No_349_Intersection_of_Two_Arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/6/11 16:52
 * Description:
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Difficulty: Easy
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++){
            set1.add(nums1[i]);
        }

        for (int j = 0; j < nums2.length; j++){
            if (set1.contains(nums2[j])){
                set2.add(nums2[j]);
            }
        }
        int[] res = new int[set2.size()];
        int o = 0;
        for (int i:set2){
            res[o++] = i;
        }
        return res;
    }
}
