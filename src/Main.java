//import Math.No_9_PalindromeNumber.Solution;
//import Math.No_7_ReverseInteger.Solution;


import LinkedList.No_21_MergeTwoSortedLists.ListNode;
import LinkedList.No_21_MergeTwoSortedLists.Solution;

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

//        int[] ints = Solution.plusOne(new int[]{9,9,9});
//        for (int i = 0;i<ints.length;i++){
//            System.out.println(ints[i]);
//        }

        ListNode listNode1 = new ListNode(3);

        ListNode listNode2 = new ListNode(2);

        listNode1.setNext(listNode2);

        ListNode listNode3 = new ListNode(4);

        listNode2.setNext(listNode3);


        ListNode listNode4 = new ListNode(6);

        ListNode listNode5 = new ListNode(3);

        listNode4.setNext(listNode5);

        ListNode listNode6 = new ListNode(5);

        listNode5.setNext(listNode6);


        ListNode listNode = new Solution().mergeTwoLists(listNode1, listNode4);

        System.out.println(listNode.getNext().getNext().getVal());
    }
}
