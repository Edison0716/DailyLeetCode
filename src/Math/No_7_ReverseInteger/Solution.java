package Math.No_7_ReverseInteger;


/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-01-20 15:30
 * Description: Given a 32-bit signed integer, reverse digits of an integer.
 */

public class Solution {
    public int reverse(int x) {
        int resultNum = 0;
        while (x != 0) {
            int y = resultNum * 10 + x % 10;
            if (y / 10 != resultNum) return 0;
            resultNum = y;
            x = x / 10;
        }
        return resultNum;
    }
}
