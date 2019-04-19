package me.elvis.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     * <p>
     * *******************************************************************************************
     * * Given "abcabcbb", the answer is "abc", which the length is 3.                          **
     * * Given "bbbbb", the answer is "b", with the length of 1.                                **
     * * Given "pwwkew", the answer is "wke", with the length of 3.                             **
     * * Note that the answer must be a substring, "pwke" is a subsequence and not a substring. **
     * *******************************************************************************************
     *
     * @param args
     */
    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        System.out.println(longestSubstring.lengthOfLongestSubstringUsingLoop("asddsaffa"));
        System.out.println(longestSubstring.lengthOfLongestSubstringUsingLoop("bbbbb"));
        System.out.println(longestSubstring.lengthOfLongestSubstringUsingLoop("pwwkew"));

        System.out.println(longestSubstring.lengthOfLongestSubstringUsingHashMap("asddsaffa"));
        System.out.println(longestSubstring.lengthOfLongestSubstringUsingHashMap("bbbbb"));
        System.out.println(longestSubstring.lengthOfLongestSubstringUsingHashMap("pwwkew"));

        System.out.println(longestSubstring.lengthOfLongestSubstringUsingASCII("asddsaffa"));
        System.out.println(longestSubstring.lengthOfLongestSubstringUsingASCII("bbbbb"));
        System.out.println(longestSubstring.lengthOfLongestSubstringUsingASCII("pwwkew"));
    }

    /**
     * Use hashSet to get the longest length of subString which start with char at index i.
     * And use Math.max and loop to calculate the max value.
     *
     * Example:
     *
     * ---
     * xxx    The xxx means the data which is in set.
     * ---
     *
     * Process: loop
     *
     * i=0,j=2      i=0,j=3      i=1,j=3       i=2,j=3      i=3,j=3             i=3,j=6
     * ---3          --            -                           -                   ----4
     * asddsaffa -> asddsaffa -> asddsaffa ->  asddsaffa -> asddsaffa -> ... -> asddsaffa ->
     * ---           --            -                           -                   ----
     *
     * i=3,j=7      i=4,j=7       i=5,j=7
     *     ---           --
     * asddsaffa -> asddsaffa ->
     *     ---           --
     *
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringUsingLoop(String s) {
        int maxLength = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                // j++ means "get value of j,and j = j+1"
                set.add(s.charAt(j++));
                // so j - i is right length of subString
                maxLength = Math.max(maxLength, j - i);
            } else {
                // if contains,it means need to skip this loop
                set.remove(s.charAt(i++));
            }
        }
        System.out.println("i : " + i);
        System.out.println("j : " + j);
        return maxLength;
    }

    /**
     * Using hashMap(Char,Index) to reduce loop times.
     * Because when we find duplicate char, we can move index of header
     * to duplicate char first appear index + 1.Not header index + 1.
     *
     * Example:
     *
     * asddsaffa -> Map (a,1->6->9) (s,2->5) (d,3->4) (f,7->8)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringUsingHashMap(String s) {
        int n = s.length(), ans = 0;
        // current index of character
        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                // compare i with map.value(length of current sub string)
                // reduce loop times
                i = Math.max(map.get(s.charAt(j)), i);
            }

            // get the max length.
            ans = Math.max(ans, j - i + 1);

            // key: char  value: length(index + 1)
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    /**
     * Use ascii array to replace of hash map.
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringUsingASCII(String s) {
        int n = s.length(), ans = 0;

        // current index of character
        int[] index = new int[128];
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
