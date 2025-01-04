// 14. Longest Common Prefix
// Write a function to find the longest common prefix string amongst an array of strings.
// If there is no common prefix, return an empty string "".
// Example 1:
// Input: strs = ["flower","flow","flight"]
// Output: "fl"
// Example 2:
// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.

// CODE

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n= strs.length;
        if(strs == null || n == 0 ){
            return " ";
        }

        String prefix= strs[0];

        for(int i=0;i<n;i++){
             while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return ""; 
                }
            }
        }

        return prefix;
    }
}

// end

// 242. Valid Anagram
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
// Example 1:
// Input: s = "anagram", t = "nagaram"
// Output: true
// Example 2:
// Input: s = "rat", t = "car"
// Output: false

// CODE

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] charCount =  new int[26];

        for(char c :s.toCharArray()){
           charCount[c - 'a']++;
        }
        for(char c : t.toCharArray()){
            charCount[c-'a']--;
        }

        for(int count : charCount ){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
}
