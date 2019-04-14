package Tree.medium.No_508_Most_Frequent_Subtree_Sum;

import Tree.TreeNode;

import java.util.*;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-04-14 20:54
 * Description: Most Frequent Subtree Sum
 * Difficulty: Medium
 *
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 *
 * Examples 1
 * Input:
 *
 *   5
 *  /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 *
 *   5
 *  /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 */
public class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        //存放 元素 找频率
        HashMap frequentContainer = new HashMap<Integer, Integer>();
        handleFrequent(root, frequentContainer);

        //找频率最高的
        int[] resFrequentArray = new int[frequentContainer.size()];
        Iterator iterator = frequentContainer.entrySet().iterator();
        int temFrequentValue = 0;
        int index = 0;
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            if ((int) entry.getValue() > temFrequentValue) {
                resFrequentArray[0] = (int) entry.getKey();
                index = 1;
                temFrequentValue = (int) entry.getValue();
            } else if ((int) entry.getValue() == temFrequentValue){
                resFrequentArray[index] = (int) entry.getKey();
                index++;
            }
        }
        return Arrays.copyOfRange(resFrequentArray, 0, index);
    }

    private int handleFrequent(TreeNode root, HashMap<Integer, Integer> frequentContainer) {
        int sum = 0;
        sum += root.val;

        if (root.left != null) sum = sum + handleFrequent(root.left, frequentContainer);
        if (root.right != null) sum = sum + handleFrequent(root.right, frequentContainer);

        //记录总和
        if (frequentContainer.containsKey(sum)) {
            frequentContainer.put(sum, frequentContainer.get(sum) + 1);
        } else {
            frequentContainer.put(sum, 1);
        }

        return sum;
    }
}
