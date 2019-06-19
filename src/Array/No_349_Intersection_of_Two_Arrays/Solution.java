package Array.No_349_Intersection_of_Two_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/6/11 16:52
 * Description:
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 * <p>
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
