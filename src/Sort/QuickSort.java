package Sort;


/**
 * 快速排序
 */
public class QuickSort {
    /**
     * 为什么最坏情况下快速排序的时间复杂度是 O(n2) 呢？我们前面讲过，如果数据原来就是有序的或者接近有序的，
     * 每次分区点都选择最后一个数据，那快速排序算法就会变得非常糟糕，时间复杂度就会退化为 O(n2)。
     * 实际上，这种 O(n2) 时间复杂度出现的主要原因还是因为我们分区点选的不够合理。
     */
    // 最坏的情况是O（n^2）
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

        // 快慢指针 若快指针小于右侧的基准点  并且慢指针与快指针都在同一个位置 则满指针也走一步 不在一起 两个指针就交换位置
        for (int fastPoint = start; fastPoint < end; ++fastPoint) {
            if (a[fastPoint] < basePoint) {
                if (slowPoint == fastPoint) {
                    ++slowPoint;
                } else {
                    int tmp = a[fastPoint];
                    a[fastPoint] = a[slowPoint];
                    a[slowPoint++] = tmp;
                }
            }
        }

        // 完事以后 将慢指针与基准点互换位置 基准点就找到的正确的位置 左边是比它小的 右侧是比它大的
        a[end] = a[slowPoint];
        a[slowPoint] = basePoint;

        return slowPoint;
    }
}
