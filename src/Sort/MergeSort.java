package Sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public static int[] mergeSort(int[]a) {
        // 递归终止条件
        if (a.length < 2) return a;
        // 找出中间点
        int middlePoint = a.length / 2;
        int[] startArray = Arrays.copyOfRange(a, 0, middlePoint);
        int[] endArray = Arrays.copyOfRange(a,middlePoint,a.length);
        return mergeSort(mergeSort(startArray), mergeSort(endArray));
    }

    private static int[] mergeSort(int[] start, int[] end) {
        int[] resultArray = new int[start.length + end.length];
        for (int i = 0,startIndex = 0,endIndex = 0; i < resultArray.length; ++i) {
            if (startIndex >= start.length){
                resultArray[i] = end[endIndex++];
            }else if (endIndex >= end.length){
                resultArray[i] = start[startIndex++];
            }else if (start[startIndex] > end[endIndex]){
                resultArray[i] = start[startIndex++];
            }else {
                resultArray[i] = end[endIndex++];
            }
        }
        return resultArray;
    }
}
