package Tree.medium.No_96_Unique_Binary_Search_Trees;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/4/24 11:27
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * Difficulty: Medium
 *
 */
public class Solution {
    //卡特兰数
    public int numTrees(int n) {
        if (n == 1 || n == 0)
            return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        //每个数都可以成为根节点
        for (int i = 1; i <= n; i++) {
            //i为根节点时，左子树从0开始增加
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
