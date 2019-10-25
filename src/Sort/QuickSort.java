package Sort;


/**
 * 快速排序
 */
public class QuickSort {
    public static int[] sort(int[] a, int start, int end) {
        // 递归结束条件
        if (start >= end) return a;

        int basePoint = acquireBasePoint(a, start, end);
        sort(a, start, basePoint - 1);
        sort(a, basePoint + 1, end);
        return a;
    }

    private static int acquireBasePoint(int[] a, int start, int end) {
        int basePoint = a[end];
        int slowPoint = start;


        for (int fastPoint = start; fastPoint < end; ++fastPoint) {
            if (a[fastPoint] < basePoint){
                if (slowPoint == fastPoint){
                    ++slowPoint;
                }else {
                    int tmp = a[fastPoint];
                    a[fastPoint] = a[slowPoint];
                    a[slowPoint++] = tmp;
                }
            }
        }

        a[end] = a[slowPoint];
        a[slowPoint] = basePoint;

        return slowPoint;
    }
}
