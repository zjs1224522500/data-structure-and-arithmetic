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
        return maxLength;
    }

    /**
     * Using hashMap(Char,Index) to reduce loop times.
     * Because when we find duplicate char, we can move index of header
     * to duplicate char first appear index + 1.Not header index + 1.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringUsingHashMap(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                // compare i with map.value(next index of char which is different from key)
                // reduce loop times
                i = Math.max(map.get(s.charAt(j)), i);
            }

            // get the max length.
            ans = Math.max(ans, j - i + 1);

            // next index of char which is different from charAt(j)
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
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
