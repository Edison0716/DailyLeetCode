package Array.No_167_Two_Sum_II_Input_Array_Is_Sorted;


/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-02-10 19:05
 * Description: Two Sum II - Input array is sorted
 * <p>
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * <p>
 * Note:
 * <p>
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] resArray = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    resArray[0] = i + 1;
                    resArray[1] = j + 1;
                }
            }
        }
        return resArray;
    }


    public int[] twoSum1(int[] numbers, int target) {
            int i = 0, j = numbers.length - 1;
            while (i < j) {
                if (numbers[i] + numbers[j] == target) {
                    int resArray[] = {i + 1, j + 1};
                    return resArray;
                } else if (numbers[i] + numbers[j] > target) {
                    j--;
                } else {
                    i++;
                }
            }
            throw new RuntimeException("No Value");
    }
}
