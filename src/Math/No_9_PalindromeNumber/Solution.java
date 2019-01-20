package Math.No_9_PalindromeNumber;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-01-20 16:39
 * Description: Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 */

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        int reverseNum = 0;
        int originalNum = x;
        while (x != 0) {
            int y = reverseNum * 10 + x % 10;
            reverseNum = y;
            x = x / 10;
        }
        return reverseNum == originalNum;
    }
}
