package Sort;

import java.util.Arrays;

/**
 * 计数排序
 */
public class CountingSort {

    // 非稳定排序
    public static int[] countingSort(int[] a) {
        // 先复制一份
        int[] copyArray = Arrays.copyOf(a, a.length);
        // 找出最大值
        int maximumNum = getMaximumNumAndMinimum(copyArray)[0];
        // 开辟一个数组空间用于存放这些值所出现的次数
        int[] countingArray = new int[maximumNum + 1];
        // 分配数据 index 代表数据的值 value 代表数据所出现的次数
        for (int b : copyArray) {
            countingArray[b]++;
        }

        int currentFlag = 0;

        // 遍历数组到最大值
        for (int i = 0; i < maximumNum; ++i) {
            // 若index对应的值大于0 说明有出现该index对应的值
            while (countingArray[i] > 0) {
                // 向数组中顺序添加元素
                a[currentFlag++] = i;
                // 次数减1
                countingArray[i]--;
            }
        }

        return a;
    }

    // 非稳定排序
    public static int[] countingSortOptimize(int[] a) {
        // 先复制一份
        int[] copyArray = Arrays.copyOf(a, a.length);
        // 找出最大 小值
        int[] numAndMinimum = getMaximumNumAndMinimum(copyArray);
        int maximumNum = numAndMinimum[0];
        int minimumNum = numAndMinimum[1];

        int k = maximumNum - minimumNum + 1;
        int[] b = new int[k];
        for (int c : copyArray) {
            b[c - minimumNum]++;
        }

        int currentFlag = 0;
        for (int i = 0; i < k; ++i) {
            while (b[i] > 0) {
                a[currentFlag++] = i + minimumNum;
                b[i]--;
            }
        }

        return a;
    }


    public static int[] countingSorttoStabilize(int[] a) {
        int length = a.length;
        if (length < 2) return a;
        int maximumNum = getMaximumNumAndMinimum(a)[0];
        // 开辟空间
        int[] b = new int[maximumNum + 1];
        // 添加数据
        for (int num : a) {
            b[num]++;
        }
        // 将每一个index对应的数据都与前面的数字累加
        for (int i = 1; i < maximumNum + 1; ++i) {
            b[i] = b[i] + b[i - 1];
        }

        int[] result = new int[length];


        // 计算出 当前的值在 排序后的位置
        for (int i = length - 1; i >= 0; --i) {
            int index = b[a[i]] - 1;
            result[index] = a[i];
            b[a[i]]--;
        }

        System.arraycopy(result, 0, a, 0, length);


        return a;
    }

    private static int[] getMaximumNumAndMinimum(int[] copyArray) {
        int[] numContainer = new int[2];
        int maximumNum = copyArray[0];
        int minimumNum = copyArray[0];
        for (int a : copyArray) {
            if (a > maximumNum) {
                maximumNum = a;
            }
            if (a < minimumNum) {
                minimumNum = a;
            }
        }

        numContainer[0] = maximumNum;
        numContainer[1] = minimumNum;
        return numContainer;
    }
}
