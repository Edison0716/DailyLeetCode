package Math.No_66_PlusOne;

/**
 * FileName: Solution
 * Author:   mac
 * Date:     2019-01-24 10:38
 * Description: Plus One
 * <p>
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 * <p>
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return digits;
        }
        int carry = 1; //判断是否进位
        int temp;
        for (int i = digits.length - 1; i >= 0; i--) {
            temp = digits[i];//当前的值
            digits[i] = (temp + carry) % 10;//当前加1后的值 当小于9 的时候 比如 temp = 8  9 % 10 = 9 为当前  10 % 10 = 0
            carry = (carry + temp) / 10; //判断是否要进位 9/10 = 0  10/10 = 1

            if (carry == 0) {//如果carry == 0 了说明加到头了
                break;
            }

        }
        if (carry == 1) { //说明 是 比如 99 + 1 = 100
            int[] newDigits = new int[digits.length + 1];//扩容1个size
            System.arraycopy(digits, 0, newDigits, 1, digits.length); //复制数组从目标数组index = 1 开始复制
            newDigits[0] = 1;
            return newDigits;
        } else {
            return digits;
        }
    }
}
