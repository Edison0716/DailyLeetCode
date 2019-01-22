package Sort;

/**
 * FileName: SelectSort
 * Author:   mac
 * Date:     2019-01-22 11:42
 * Description: SelectSort
 */
public class SelectSort {
    public static int[] selectSort(int[] arr, int n) {

        for (int i = 0; i < n; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            int e = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = e;
        }
        return arr;

    }
}
