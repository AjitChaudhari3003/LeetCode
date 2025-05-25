// 2131. Longest Palindrome by Concatenating Two Letter Words
// Solved
// Medium
// Topics
// Companies
// Hint
// You are given an array of strings words. Each element of words consists of two lowercase English letters.

// Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.

// Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.

// A palindrome is a string that reads the same forward and backward.

 

// Example 1:

// Input: words = ["lc","cl","gg"]
// Output: 6
// Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of length 6.
// Note that "clgglc" is another longest palindrome that can be created.



import java.util.*;

class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        boolean hasCentralWord = false;

        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        for (String word : map.keySet()) {
            int freq = map.get(word);
            if (freq == 0) continue;

            String reversed = new StringBuilder(word).reverse().toString();
            if (word.equals(reversed)) {
                count += (freq / 2) * 4;
                if (freq % 2 == 1) hasCentralWord = true;
            } else if (map.containsKey(reversed)) {
                int pairs = Math.min(freq, map.get(reversed));
                count += pairs * 4;
                map.put(reversed, 0);
            }
            map.put(word, 0);
        }

        if (hasCentralWord) count += 2;
        return count;
    }
}
