package Sort;

/**
 * FileName: BobbleSort
 * Author:   mac
 * Date:     2019-01-21 16:27
 * Description: 冒泡排序
 * N个数字要排序完成，总共进行N-1轮排序，每i轮的排序次数为(N-i)次，所以可以用双重循环语句，外层控制循环多少趟，内层控制每一趟的循环次数
 */
public class BobbleSort {
    public static int[] bobbleSort1(int[] aars) {
        for (int i = 1; i < aars.length; i++) {
            for (int j = 0; j < aars.length - i; j++) {
                if (aars[j] > aars[j + 1]) {
                    int r = aars[j];
                    aars[j] = aars[j + 1];
                    aars[j + 1] = r;
                }
            }
        }
        return aars;
    }


    public static int[] bobbleSort2(int[] aars) {

        int n = aars.length;
        boolean swapped;


        do {
            swapped = false;

            for (int i = 1; i < n; i++) {
                if (aars[i - 1] > aars[i]) {
                    int r = aars[i - 1];
                    aars[i - 1] = aars[i];
                    aars[i] = r;
                    swapped = true;
                }
            }

            n--;

        } while (swapped);

        return aars;
    }


    public static int[] bobbleSort3(int[] aars) {

        return aars;
    }
}
