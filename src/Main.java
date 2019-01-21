//import Math.No_9_PalindromeNumber.Solution;
//import Math.No_7_ReverseInteger.Solution;

import Array.No_26_RemoveDuplicatesFromSortedArray.Solution;
import Sort.BobbleSort;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] array = new int[]{1, 1, 2, 3, 3, 4, 5, 6, 6};

        System.out.println(solution.removeDuplicates(array));

        int[] bobbleArray = new int[]{6, 3, 8, 2, 9, 1};
        int[] orderArray = BobbleSort.bobbleSort2(bobbleArray);

        for (int i = 0; i < orderArray.length; i++) {
            System.out.println(orderArray[i]);
        }
    }
}
