package Sort;

import java.util.Arrays;

/**
 * 计数排序
 */
public class CountingSort {
    public static int[] countingSort(int[] a) {
        // 先复制一份
        int[] copyArray = Arrays.copyOf(a, a.length);
        // 找出最大值
        int maximumNum = getMaximumNum(copyArray);
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
            while (countingArray[i] > 0){
                // 向数组中顺序添加元素
                a[currentFlag++] = i;
                // 次数减1
                countingArray[i]--;
            }
        }

        return a;
    }

    private static int getMaximumNum(int[] copyArray) {
        int maximumNum = 0;
        for (int a : copyArray) {
            if (a > maximumNum) {
                maximumNum = a;
            }
        }
        return maximumNum;
    }
}
