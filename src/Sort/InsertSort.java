package Sort;

/**
 * FileName: InsertSort
 * Author:   mac
 * Date:     2019-01-21 15:14
 * Description: 插入排序算法
 */
public class InsertSort {
    void insertSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int m = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = m;
                } else {
                    return;
                }
            }
        }
    }

    void insertSort2(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int e = arr[i];
            int j;
            for (j = i; j > 0; j--) {
                if (arr[j - 1] > e) {
                    arr[j] = arr[j - 1];
                }
            }
            arr[j] = e;
        }
    }
}
