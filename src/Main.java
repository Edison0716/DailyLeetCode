//import Math.No_9_PalindromeNumber.Solution;
//import Math.No_7_ReverseInteger.Solution;


//import Array.No_169_Majority_Element.Solution;
//import LinkedList.ListNode;


import java.util.ArrayList;
import java.util.Arrays;

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
        ArrayList<String> aa = new ArrayList<>();
        ArrayList<String> bb = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            aa.add("aa" + i);
        }

        for (int i = 0; i < 3; i++) {
            bb.add("bb" + i);
        }

        int index = 1;
        boolean isEnd = false;
        int maxIndex = Math.max(aa.size(), bb.size());
        for (String num : bb) {
            if (index < maxIndex) {
                if (!isEnd) {
                    aa.add(index, num);
                    index += 2;
                } else {
                    aa.add(num);
                }
            } else {
                isEnd = true;
                aa.add(num);
            }
        }
        for (String v : aa) {
            System.out.println(v);
        }

//        System.out.println(bb);
//
//        Node node4 = new Node(4, null, null, null);
//
//
//        Node node5 = new Node(5, null, null, null);
//        Node node7 = new Node(7, null, null, null);
//        Node node3 = new Node(3, null, node7, null);
//        Node node2 = new Node(2, node4, node5, null);
//
//
//        Node node1 = new Node(1, node2, node3, null);
//        Solution solution = new Solution();
//        Node connect = solution.connect(node1);
//
//        System.out.println();


        //new ArrayBlockingQueue();

        int[] a = new int[10];
        a[0] = 4;
        a[1] = 12;
        a[2] = 22;
        a[3] = 3;
        a[4] = 14;
        a[5] = 76;
        a[6] = 55;
        a[7] = 43;
        a[8] = 1;
        a[9] = 8;
//        for (int i : sortArray(a)) {
//            System.out.println("归并排序" + i);
//        }
//        for (int i : insertArray(a)) {
//            System.out.println("插入排序" + i);
//        }

        for (int i : quickSort(a, 0, a.length - 1)) {
            System.out.println("快速排序" + i);
        }

    }


    // 快速排序
    private static int[] quickSort(int[] a, int L, int R) {
        // 递归结束条件
        if (L >= R) return a;
        // 找出基准点
        int basePoint = acquireBasePoint(a, L, R);
        // 递归左侧
        quickSort(a, L, basePoint - 1);
        // 递归右侧
        quickSort(a, basePoint + 1, R);
        return a;
    }

    // 最坏的情况 n^2 最好 nlogn 平均 nlogn
    private static int acquireBasePoint(int[] a, int start, int end) {
        int basePoint = a[end];
        int slowP = start;
        for (int fastP = start; fastP < end; ++fastP) {
            if (a[fastP] < basePoint) {
                if (slowP == fastP) {
                    ++slowP;
                } else {
                   // 进行交换
                    int tem = a[slowP];
                    a[slowP++] = a[fastP];
                    a[fastP] = tem;
                }
            } else {
                // do nothing
            }
        }
        int tem = a[end];
        a[end] = a[slowP];
        a[slowP] = tem;
        return slowP;

//        // 就以最右侧为基准点
//        int basePoint = a[end];
//        // i 的作用就是 标记距离比基准点小的最近的一个位置
//        int i = start;
//        for (int j = start; j < end; ++j) {
//            // 从左侧遍历 小于基准值的情况 快指针 一旦发现比基准小的指针 但前一个指针大于基准点 就将这个节点与慢指针下一个节点进行交换
//            if (a[j] < basePoint) {
//                // 开始遍历的时候 指针相等 则 两个指针同时移动
//                if (i == j) {
//                    ++i;
//                } else {
//                    int tmp = a[i];
//                    a[i++] = a[j];
//                    a[j] = tmp;
//                }
//            } else {
//                // do nothing
//                // 大于基准值 直接让 j + 1 之后 i != j 下一次循环直接进行值交换
//            }
//
//        }
//
//        // 将 基准点 与 当前的 i 值 替换
//        int tem = a[i];
//        a[i] = a[end];
//        a[end] = tem;
//        return i;
    }

    private static int[] insertArray(int[] a) {
        if (a.length < 2) return a;
        for (int i = 1; i < a.length; ++i) {
            int j = i - 1;
            int v = a[i];
            for (; j >= 0; --j) {
                if (a[j] > v) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = v;
        }
        return a;
    }

    // 归并排序 nlogn
    private static int[] sortArray(int[] a) {
        if (a.length < 2) return a;
        int middleIndex = a.length / 2;
        int[] leftArray = Arrays.copyOfRange(a, 0, middleIndex);
        int[] rightArray = Arrays.copyOfRange(a, middleIndex, a.length);
        return merge(sortArray(leftArray), sortArray(rightArray));
    }

    private static int[] merge(int[] leftArray, int[] rightArray) {
        int totalCap = leftArray.length + rightArray.length;
        int[] result = new int[totalCap];
        for (int i = 0, leftIndex = 0, rightIndex = 0; i < totalCap; ++i) {
            if (leftIndex >= leftArray.length) {
                result[i] = rightArray[rightIndex++];
            } else if (rightIndex >= rightArray.length) {
                result[i] = leftArray[leftIndex++];
            } else if (leftArray[leftIndex] > rightArray[rightIndex]) {
                result[i] = rightArray[rightIndex++];
            } else {
                result[i] = leftArray[leftIndex++];
            }
        }
        return result;
    }
}
