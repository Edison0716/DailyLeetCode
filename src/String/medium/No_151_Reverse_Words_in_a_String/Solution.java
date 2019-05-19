package String.medium.No_151_Reverse_Words_in_a_String;


/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-05-19 13:14
 * Description: Reverse Words in a String
 * Given an input string, reverse the string word by word.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 * <p>
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 * <p>
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 * <p>
 * <p>
 * Note:
 * <p>
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 * <p>
 * <p>
 * Follow up:
 * <p>
 * For C programmers, try to solve it in-place in O(1) extra space.
 */

public class Solution {
    public String reverseWords(String s) {
        //按照空格切割字符串
        String[] words = s.split("\\s");
        StringBuilder sb = new StringBuilder();
        //合并
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].equals("")) continue;
            if (i == 0)
                sb.append(words[i]);
            else
                sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
