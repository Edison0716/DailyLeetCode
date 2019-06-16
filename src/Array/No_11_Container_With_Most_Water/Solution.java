package Array.No_11_Container_With_Most_Water;

/**
 * FileName: Solution
 * Author:   EdisonLi的Windows
 * Date:     2019/6/10 17:16
 * Description: 11. Container With Most Water
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * <p>
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example:
 * <p>
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Difficulty: Medium
 */
public class Solution {

    //o(n)
    public int maxArea(int[] height) {
        int maxArea = 0;
        int startP = 0, endP = height.length - 1;
        while (startP < endP){
            maxArea = Math.max(maxArea,Math.min(height[startP],height[endP]) * (endP - startP));
            if (height[startP] < height[endP])
                startP++;
            else
                endP--;
        }
        return maxArea;
    }

    //o(n^2)
    public int maxArea1(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                if (height[i] < height[j]) {
                    maxArea = Math.max(maxArea, height[i] * (j - i));
                }else {
                    maxArea = Math.max(maxArea, height[j] * (j - i));
                }
            }
        }
        return maxArea;
    }
}
