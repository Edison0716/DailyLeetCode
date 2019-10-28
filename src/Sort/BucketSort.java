package Sort;

/**
 * 桶排序
 */
public class BucketSort {

    /**
     * @param a          待排序的数组
     * @param bucketSize 每一个桶的容量
     * @return
     */
    public static int[] sort(int[] a, int bucketSize) {
        // 先找出组大的数 与 最小的数
        int maximum = a[0];
        int minimum = a[1];

        for (int i : a) {
            if (i > maximum) {
                maximum = i;
            } else if (i < minimum) {
                minimum = i;
            }
        }

        // 计算桶的数量
        int bucketCount = (maximum - minimum) / bucketSize + 1;
        // 桶的二维数组
        int[][] buckets = new int[bucketCount][bucketSize];
        // 保存每一个桶中已经保存多少数据了
        int[] bucketArraySize = new int[bucketCount];


        // 将数组的数据 放入桶中
        for (int value : a) {
            // 计算这个数据 存放在第几个桶中
            int saveBucketIndex = (value - minimum) / bucketSize;
            // 一个桶 存放的数据超过了预设容量值 则需要扩容 获取二维数组 第二个数组的容量
            if (bucketArraySize[saveBucketIndex] == buckets[saveBucketIndex].length) {
                // 扩容
                ensureCapacity(buckets, saveBucketIndex);
            }
            // 保存
            buckets[saveBucketIndex][bucketArraySize[saveBucketIndex]++] = value;
        }

        // 对每一个桶中的数据进行 快速排序
        int k = 0;

        for (int i = 0; i < buckets.length; ++i) {
            if (bucketArraySize[i] == 0) {
                continue;
            }

            QuickSort.sort(buckets[i],0,bucketArraySize[i] - 1);

            for (int j = 0; j < bucketArraySize[i]; ++j) {
                a[k++] = buckets[i][j];
            }
        }

        return a;
    }


    private static void ensureCapacity(int[][] a, int saveBucketIndex) {
        int[] temArray = a[saveBucketIndex];
        int[] newArray = new int[temArray.length * 2];
        System.arraycopy(temArray, 0, newArray, 0, temArray.length);
        a[saveBucketIndex] = newArray;
    }

}
