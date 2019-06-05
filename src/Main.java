//import Math.No_9_PalindromeNumber.Solution;
//import Math.No_7_ReverseInteger.Solution;


//import Array.No_169_Majority_Element.Solution;
//import LinkedList.ListNode;


import LinkedList.ListNode;
import Tree.medium.No_117_Populating_Next_Right_Pointers_in_Each_Node_II.Node;
import Tree.medium.No_117_Populating_Next_Right_Pointers_in_Each_Node_II.Solution;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        Solution Solution = new Solution();
//
//        int[] array = new int[]{1, 1, 2, 3, 3, 4, 5, 6, 6};
//
//        System.out.println(Solution.removeDuplicates(array));
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

//        ListNode listNode1 = new ListNode(1);
//
//        ListNode listNode2 = new ListNode(2);
//
//        listNode1.setNext(listNode2);
//
//        ListNode listNode3 = new ListNode(3);
//
//        listNode2.setNext(listNode3);
//
//        ListNode listNode4 = new ListNode(4);
//
//        listNode3.next = listNode4;
//
//        ListNode listNode5 = new ListNode(5);
//
//        listNode4.setNext(listNode5);
//
//        ListNode listNode6 = new ListNode(6);
//
//        listNode5.setNext(listNode6);
//        new Solution().reverseList(listNode1);
//        new Solution().swapPairs(listNode1);

        //ListNode listNode = new Solution().middleNode(listNode1);

        //System.out.println(listNode.getNext().getNext().getVal());


//        int[] array1 = new int[]{1, 2, 3, 4, 5};
//        int[] array2 = new int[]{ 1, 7, 8};
//
//        Solution Solution = new Solution();
//        Solution.merge(array1, 2, array2, 3);

//        int[] nums = {1, 2, 3, 4, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 6, 7, 8, 4};
//
//        Solution Solution = new Solution();
//        Solution.majorityElement2(nums);

//        int[] A = {1,1};
//        int[] B = {2,2};
//        Solution Solution = new Solution();
//        int[] squares = Solution.sortedSquares(nums);
//        for (int num : squares) {
//            System.out.println(num);
//        }

//        Solution solution = new Solution();
//        int[] result = solution.fairCandySwap(A, B);
//        for (int num:result){
//            System.out.println(num);
//        }


        //new Solution().mergeTwoLists()

        //new Solution().generate(5);

//        int[] nums = {1,3,5,7,2,4,5,6};
//        System.out.println(new Solution().findUnsortedSubarray(nums));
//        new Solution().rotate1(nums,3);

//        List<Integer> disappearedNumbers = new Solution().findDisappearedNumbers(nums);
//
//        for (int num : disappearedNumbers) {
//            System.out.println(num);
//        }


//        LinkedList<Node> node1 = new LinkedList<>();
//        LinkedList<Node> node2 = new LinkedList<>();
//        LinkedList<Node> nodesNull = new LinkedList<>();
//
//        node2.add(new Node(5,nodesNull));
//        node2.add(new Node(6,nodesNull));
//
//        Node node11 = new Node(3,node2);
//        Node node12 = new Node(2,nodesNull);
//        Node node13 = new Node(4,nodesNull);
//
//        node1.add(node11);
//        node1.add(node12);
//        node1.add(node13);
//
//        Node node = new Node(1,node1);
//
//        System.out.println(new Solution().levelOrder(node));

//        new Solution().allPossibleFBT(3,"root");

//        ListNode bigPart = new ListNode(0);
//        ListNode big = bigPart;
//
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//
//        big.next = head;
//        System.out.println(big.next.val);
//        System.out.println(bigPart.next.val);
//
//        big = big.next;
//        System.out.println(big.val);
//        System.out.println(bigPart.next.val);
        //new Solution().numTrees(4);
        ArrayList<Integer> aa = new ArrayList<>();
        aa.add(1);
        aa.add(2);
        aa.add(3);
        ArrayList<Integer> bb = aa;
        bb.add(4);
        bb.add(5);


        System.out.println(aa);
        System.out.println(bb);

        Node node4 = new Node(4, null, null, null);


        Node node5 = new Node(5, null, null, null);
        Node node7 = new Node(7, null, null, null);
        Node node3 = new Node(3,null,node7,null);
        Node node2 = new Node(2, node4, node5, null);


        Node node1 = new Node(1,node2,node3,null);
        Solution solution = new Solution();
        Node connect = solution.connect(node1);

        System.out.println();
    }
}
