package Sort;


import sun.rmi.runtime.Log;

/**
 * 基数排序
 */
public class RadixSort {
    public static int[] radixSort(int[] a) {

        // 先获取最大的数
        int maximumNum = a[0];
        for (int i : a) {
            if (maximumNum < i) {
                maximumNum = i;
            }
        }
        // 计算一共要循环多少次 根据最大数字位数
        for (int i = 1; maximumNum / i > 0; i *= 10) {
            countingSort(a, i);
        }
        return a;
    }

    private static void countingSort(int[] a, int i) {
        if (a.length <= 1) return;

        int[] b = new int[10];

        // 计数排序 逻辑
        for (int value : a) {
            b[(value / i) % 10]++;
        }

        for (int k = 1; k < b.length; ++k) {
            b[k] = b[k] + b[k - 1];
        }

        // 临时存放数组
        int[] temA = new int[a.length];

        // 从后往前找位置
        for (int k = a.length - 1; k >= 0; --k) {
            temA[b[(a[k] / i) % 10] - 1] = a[k];
            b[(a[k] / i) % 10]--;
        }

        System.arraycopy(temA, 0, a, 0, a.length);

        String log = "";

        for (int i1 : a) {
            log = log + " " + i1;
        }

        System.out.println(log);
    }
}
