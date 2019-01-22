package Sort;

/**
 * FileName: InsertSort
 * Author:   mac
 * Date:     2019-01-21 15:14
 * Description: 插入排序算法
 */
public class InsertSort {
    //int[]{4,5,2,3,6}

    public static int[] insertSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {

            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    //交换
                    int m = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = m;
                }
            }
        }

        return arr;
    }

    public static int[] insertSort2(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int e = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > e; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
        return arr;
    }
}
