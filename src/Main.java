//import Math.No_9_PalindromeNumber.Solution;
//import Math.No_7_ReverseInteger.Solution;


import Math.No_66_PlusOne.Solution;

public class Main {
    public static void main(String[] args) {
//        Solution solution = new Solution();
//
//        int[] array = new int[]{1, 1, 2, 3, 3, 4, 5, 6, 6};
//
//        System.out.println(solution.removeDuplicates(array));
//
//        int[] bobbleArray = new int[]{6, 3, 8, 2, 9, 1};
//        int[] orderArray = BobbleSort.bobbleSort2(bobbleArray);
//
//        for (int i = 0; i < orderArray.length; i++) {
//            System.out.println(orderArray[i]);
//        }

//        int[] array = new int[]{4, 5, 2, 3, 6};
//        int[] ints = SelectSort.selectSort(array, array.length);
//
//        for (int i = 0; i < ints.length; i++) {
//            System.out.println(ints[i]);
//        }

        //System.out.printf(String.valueOf(Solution.romanToInt("III")));

        int[] ints = Solution.plusOne(new int[]{9,9,9});
        for (int i = 0;i<ints.length;i++){
            System.out.println(ints[i]);
        }
    }
}
