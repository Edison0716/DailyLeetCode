package Array.No_888_Fair_Candy_Swap;

import java.util.HashSet;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-01-31 10:38
 * Description: Fair Candy Swap
 * <p>
 * Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that Alice has, and B[j] is the size of the j-th bar of candy that Bob has.
 * <p>
 * Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)
 * <p>
 * Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, and ans[1] is the size of the candy bar that Bob must exchange.
 * <p>
 * If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [1,1], B = [2,2]
 * Output: [1,2]
 * Example 2:
 * <p>
 * Input: A = [1,2], B = [2,3]
 * Output: [1,2]
 * Example 3:
 * <p>
 * Input: A = [2], B = [1,3]
 * Output: [2,3]
 * Example 4:
 * <p>
 * Input: A = [1,2,5], B = [2,4]
 * Output: [5,4]
 */
public class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int totalA = 0;
        int totalB = 0;

        for (int num : A) {
            totalA = totalA + num;
        }

        for (int num : B) {
            totalB = totalB + num;
        }

        HashSet<Integer> integers = new HashSet<>();

        for (int num : B) {
            integers.add(num);
        }

        int avg = (totalA + totalB) / 2;
        for (int i = 0; i < A.length; i++) {
            int num = avg - (totalA - A[i]); //平均数 - A总数中不包含当前选中的值
            if (integers.contains(num)) {
                return new int[]{A[i], num};
            }
        }

        throw null;
    }


    //超时
    public int[] fairCandySwap1(int[] A, int[] B) {
        int totalNum = 0;
        int[] resultArray = new int[2];
        for (int i = 0; i < A.length; i++) {
            totalNum = totalNum + A[i];
        }

        for (int i = 0; i < B.length; i++) {
            totalNum = totalNum + B[i];
        }

        System.out.println(totalNum);

        int avgNum = totalNum / 2;

        for (int i = 0; i < A.length; i++) {
            int tem;
            for (int j = 0; j < B.length; j++) {
                tem = B[j];
                B[j] = 0;
                int total = 0;
                for (int k = 0; k < B.length; k++) {
                    total = total + B[k];
                }
                if (avgNum == total + A[i]) {
                    resultArray[0] = A[i];
                    resultArray[1] = tem;
                }
                B[j] = tem;
            }
        }
        return resultArray;
    }
}
