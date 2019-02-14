package Array.No_119_Pascal_Triangle_II;


import java.util.ArrayList;
import java.util.List;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-02-14 09:57
 * Description: Pascal's Triangle II
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * <p>
 * Note that the row index starts from 0.
 * <p>
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output: [1,3,3,1]
 * Follow up:
 * <p>
 * Could you optimize your algorithm to use only O(k) extra space?
 */

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<ArrayList<Integer>> temArray = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {

            ArrayList<Integer> resArray = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    resArray.add(1);
                } else if (j == i) {
                    resArray.add(1);
                } else {
                    resArray.add(temArray.get(i - 1).get(j) + temArray.get(i - 1).get(j - 1));
                }
            }
            temArray.add(resArray);
        }

        return temArray.get(rowIndex);
    }
}
