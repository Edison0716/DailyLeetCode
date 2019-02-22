package Array.No_566_Reshape_the_Matrix;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-02-22 10:05
 * Description: Reshape the Matrix
 * <p>
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
 * <p>
 * You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
 * <p>
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
 * <p>
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 * <p>
 * Example 1:
 * Input:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 1, c = 4
 * Output:
 * [[1,2,3,4]]
 * Explanation:
 * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
 * Example 2:
 * Input:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 2, c = 4
 * Output:
 * [[1,2],
 * [3,4]]
 * Explanation:
 * There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 * Note:
 * The height and width of the given matrix is in range [1, 100].
 * The given r and c are all positive.
 */
public class Solution {
    //3ms
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] resArray = new int[r][c];
        //不符合条件 则输出原始数据
        if (resArray.length == 0 || r * c != nums.length * nums[0].length)
            return nums;

        int rows = 0, cols = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                //赋值
                resArray[rows][cols] = nums[i][j];
                //每次列数加一
                cols++;
                //若列数等于c 则行数加一 列数归零
                if (cols == c) {
                    rows++;
                    cols = 0;
                }
            }
        }

        return resArray;
    }

    public int[][] matrixReshape1(int[][] nums, int r, int c) {
        int resArray[][] = new int[r][c];

        //不符合条件 则输出原始数据
        if (resArray.length == 0 || r * c != nums.length * nums[0].length)
            return nums;

        for (int i = 0; i < r * c; i++) {
            resArray[i / c][i % c] = nums[i / nums[0].length][i % nums[0].length];
        }

        return resArray;
    }
}
