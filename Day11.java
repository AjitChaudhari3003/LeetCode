// 3. Longest Substring Without Repeating Characters
// Given a string s, find the length of the longest substringwithout repeating characters.
// Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:
// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.

// CODE

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlength=0;
        int left=0;
        HashSet<Character> set = new HashSet<>(); 
     
        for(int right=0;right<s.length();right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxlength = Math.max(maxlength, right - left + 1);
        }
        return maxlength;
    }
}
