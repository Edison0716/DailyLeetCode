package search;


public class BSearch {
    // 二分查找 前提是有序(升序)数组
    public static int bSearch(int[] a, int target) {
        // 获取长度
        int maximumIndex = a.length - 1;
        int minimumIndex = 0;

        while (minimumIndex <= maximumIndex) {
            int middle = (minimumIndex + maximumIndex) / 2;
            if (target > a[middle]) {
                minimumIndex = middle + 1;
            } else if (target < a[middle]) {
                maximumIndex = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }


    public static int bSearchBST(int[] a, int target) {
        return bSearchInternally(a, 0, a.length - 1, target);
    }

    private static int bSearchInternally(int[] a, int min, int max, int target) {
        if (min > max) return -1;
        int middle = (max + min) / 2;
        if (a[middle] > target) {
            return bSearchInternally(a, min, middle - 1, target);
        } else if (a[middle] < target) {
            return bSearchInternally(a, middle + 1, max, target);
        }else {
            return middle;
        }
    }
}
