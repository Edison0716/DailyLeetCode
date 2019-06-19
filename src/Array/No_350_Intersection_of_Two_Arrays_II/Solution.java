package Array.No_350_Intersection_of_Two_Arrays_II;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * FileName: Solution
 * Author:   EdisonLi的MacBook pro
 * Date:     2019/6/19 23:24
 * Description:
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Difficulty: Easy
 */

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //先排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> resArray = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while ((p1 < nums1.length) && (p2 < nums2.length)) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                if (nums1[p1] > nums2[p2]) {
                    p2++;
                } else {
                    resArray.add(nums1[p1]);
                    p1++;
                    p2++;
                }
            }
        }
        int[] res = new int[resArray.size()];
        for (int i = 0; i < resArray.size(); i++) {
            res[i] = resArray.get(i);
        }
        return res;
    }
}
