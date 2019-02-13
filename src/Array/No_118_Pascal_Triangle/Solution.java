package Array.No_118_Pascal_Triangle;


import java.util.ArrayList;
import java.util.List;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-02-13 11:24
 * Description: Pascal's Triangle
 * <p>
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 5
 * Output:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> temArray = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    temArray.add(1);//头是一
                } else if (j == i) {
                    temArray.add(1);//尾是一
                } else {
                    temArray.add(resList.get(i - 1).get(j) + resList.get(i - 1).get(j - 1));//中间的数是上一层的该位置与上一层的该位置前一个数之和
                }
            }
            resList.add(temArray);
        }
        return resList;
    }
}
