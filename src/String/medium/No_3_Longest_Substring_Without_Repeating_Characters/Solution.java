package String.medium.No_3_Longest_Substring_Without_Repeating_Characters;


import java.util.*;

/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-05-11 09:10
 * Description: Degree of an Array
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class Solution {

    //有脑解题
    private Set<Character> mContainer = new HashSet<>();
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;

        while (j < s.length()) {
            //包含这个字母 则移除
            if (mContainer.contains(s.charAt(j))) {
                mContainer.remove(s.charAt(i++));
            } else {
                mContainer.add(s.charAt(j++));
                max = Math.max(max, mContainer.size());
            }
        }

        return max;
    }

    //无脑解题
    private HashMap<Integer, ArrayList<Character>> tableContainer = new HashMap<>();
    public int lengthOfLongestSubstring1(String s) {
        for (int i = 0; i < s.length(); i++) {
            ArrayList<Character> characters = new ArrayList<>();
            characters.add(s.charAt(i));
            tableContainer.put(i, characters);
            for (int j = i + 1; j < s.length(); j++) {
                if (tableContainer.get(i).contains(s.charAt(j))) {
                    break;
                }else {
                    tableContainer.get(i).add(s.charAt(j));
                }
            }
        }
        int max = 0;
        for (int i = 0; i < tableContainer.size(); i++){
            if (tableContainer.containsKey(i)) max = Math.max(max,tableContainer.get(i).size());
        }
        return max;
    }
}
