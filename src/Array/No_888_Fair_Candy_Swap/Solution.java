package Array.No_888_Fair_Candy_Swap;

import java.util.HashSet;
import java.util.Set;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-01-31 10:38
 * Description: Fair Candy Swap
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
