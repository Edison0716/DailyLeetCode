package Array.No_977_Squares_Of_A_Sorted_Array;

import java.util.Arrays;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-01-30 10:04
 * Description: Squares of a Sorted Array
 * <p>
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Example 2:
 * <p>
 * Input: [-7,-3,2,3,11]
 * <p>
 * Output: [4,9,9,49,121]
 */
public class Solution {
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] *= A[i];
        }
        Arrays.sort(A);
        return A;
    }
}
