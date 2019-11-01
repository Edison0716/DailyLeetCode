package Sort;

public class ShellSort {

    public static int[] sort(int[] a) {
        int arrayLength = a.length;
        if (arrayLength < 2) return a;

        // 获取 间隔
        int gap = arrayLength / 2;

        while (gap > 0) {
            // 判断 具备 gap 间隔 的分组一共有几组
            for (int i = gap; i < arrayLength; ++i) {
                //  index = gap 时就是右侧的值
                int right = a[i];
                //  index = 当前右侧的index - gap = 左侧的数值
                int leftIndex = i - gap;

                // 判断 这个间隔 在这个长度中 可以有多少块
                while (leftIndex >= 0 && a[leftIndex] > right) {

                    a[leftIndex + gap] = a[leftIndex];

                    leftIndex -= gap;
                }

                // 将最小的放到正确的位置
                a[leftIndex + gap] = right;

            }
            gap /= 2;
        }
        return a;
    }
}
