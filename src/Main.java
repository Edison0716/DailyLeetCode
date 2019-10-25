import Sort.BucketSort;
import Sort.QuickSort;
import Sort.ShellSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[10];
        a[0] = 4;
        a[1] = 12;
        a[2] = 22;
        a[3] = 3;
        a[4] = 14;
        a[5] = 76;
        a[6] = 55;
        a[7] = 43;
        a[8] = 1;
        a[9] = 8;

//        for (int i : sortArray(a)) {
//            System.out.println("归并排序" + i);
//        }

//        for (int i : insertArray(a)) {
//            System.out.println("插入排序" + i);
//        }

//        for (int i : quickSort(a, 0, a.length - 1)) {
//            System.out.println("快速排序" + i);
//        }

        for (int i : BucketSort.sort(a,4)) {
            System.out.println("桶排序：" + i);
        }


//        for (int i = 0; i < a.length; ++i) {
//            boolean swap = false;
//            for (int j = 0; j < a.length - i - 1; ++j) {
//                if (a[j] > a[j + 1]) {
//                    int tem = a[j];
//                    a[j] = a[j + 1];
//                    a[j + 1] = tem;
//                    swap = true;
//                }
//            }
//            if (!swap) {
//                break;
//            }
//        }
//
//        for (int i : a) {
//            System.out.println("冒泡排序:" + i);
//        }
    }


    // 快速排序
    private static int[] quickSort(int[] a, int L, int R) {
        // 递归结束条件
        if (L >= R) return a;
        // 找出基准点
        int basePoint = acquireBasePoint(a, L, R);
        // 递归左侧
        quickSort(a, L, basePoint - 1);
        // 递归右侧
        quickSort(a, basePoint + 1, R);
        return a;
    }

    // 最坏的情况 n^2 最好 nlogn 平均 nlogn
    private static int acquireBasePoint(int[] a, int start, int end) {
        int basePoint = a[end];
        int slowP = start;
        for (int fastP = start; fastP < end; ++fastP) {
            if (a[fastP] < basePoint) {
                if (slowP == fastP) {
                    ++slowP;
                } else {
                    // 进行交换
                    int tem = a[slowP];
                    a[slowP++] = a[fastP];
                    a[fastP] = tem;
                }
            } else {
                // do nothing
            }
        }
        int tem = a[end];
        a[end] = a[slowP];
        a[slowP] = tem;
        return slowP;

//        // 就以最右侧为基准点
//        int basePoint = a[end];
//        // i 的作用就是 标记距离比基准点小的最近的一个位置
//        int i = start;
//        for (int j = start; j < end; ++j) {
//            // 从左侧遍历 小于基准值的情况 快指针 一旦发现比基准小的指针 但前一个指针大于基准点 就将这个节点与慢指针下一个节点进行交换
//            if (a[j] < basePoint) {
//                // 开始遍历的时候 指针相等 则 两个指针同时移动
//                if (i == j) {
//                    ++i;
//                } else {
//                    int tmp = a[i];
//                    a[i++] = a[j];
//                    a[j] = tmp;
//                }
//            } else {
//                // do nothing
//                // 大于基准值 直接让 j + 1 之后 i != j 下一次循环直接进行值交换
//            }
//
//        }
//
//        // 将 基准点 与 当前的 i 值 替换
//        int tem = a[i];
//        a[i] = a[end];
//        a[end] = tem;
//        return i;
    }

    private static int[] insertArray(int[] a) {
        if (a.length < 2) return a;
        for (int i = 1; i < a.length; ++i) {
            int j = i - 1;
            int v = a[i];
            for (; j >= 0; --j) {
                if (a[j] > v) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = v;
        }
        return a;
    }

    // 归并排序 nlogn
    private static int[] sortArray(int[] a) {
        if (a.length < 2) return a;
        int middleIndex = a.length / 2;
        int[] leftArray = Arrays.copyOfRange(a, 0, middleIndex);
        int[] rightArray = Arrays.copyOfRange(a, middleIndex, a.length);
        return merge(sortArray(leftArray), sortArray(rightArray));
    }

    private static int[] merge(int[] leftArray, int[] rightArray) {
        int totalCap = leftArray.length + rightArray.length;
        int[] result = new int[totalCap];
        for (int i = 0, leftIndex = 0, rightIndex = 0; i < totalCap; ++i) {
            if (leftIndex >= leftArray.length) {
                result[i] = rightArray[rightIndex++];
            } else if (rightIndex >= rightArray.length) {
                result[i] = leftArray[leftIndex++];
            } else if (leftArray[leftIndex] > rightArray[rightIndex]) {
                result[i] = rightArray[rightIndex++];
            } else {
                result[i] = leftArray[leftIndex++];
            }
        }
        return result;
    }
}
