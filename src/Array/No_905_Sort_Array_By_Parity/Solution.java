package Array.No_905_Sort_Array_By_Parity;


/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-02-17 09:36
 * Description: Sort Array By Parity
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * <p>
 * You may return any answer array that satisfies this condition.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */

public class Solution {
    public int[] sortArrayByParity(int[] A) {


        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] % 2 == 0) {
                    int tem = A[j];
                    A[j] = A[i];
                    A[i] = tem;
                    break;
                }
            }
        }

        return A;
    }


    public int[] sortArrayByParity1(int[] A) {
        int moveIndex = 1;
        int curIndex = 0;
        while (moveIndex < A.length) {
            if (A[moveIndex] % 2 == 0) {
                int tem = A[curIndex];
                A[curIndex] = A[moveIndex];
                A[moveIndex] = tem;
                curIndex++;
            }
            moveIndex++;
        }

        return A;
    }
}
