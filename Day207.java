// 1957. Delete Characters to Make Fancy String
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// A fancy string is a string where no three consecutive characters are equal.

// Given a string s, delete the minimum possible number of characters from s to make it fancy.

// Return the final string after the deletion. It can be shown that the answer will always be unique.

 

// Example 1:

// Input: s = "leeetcode"
// Output: "leetcode"
// Explanation:
// Remove an 'e' from the first group of 'e's to create "leetcode".
// No three consecutive characters are equal, so return "leetcode".


class Solution {
    public String makeFancyString(String s) {
        StringBuilder res = new StringBuilder();
        int count = 1;

        res.append(s.charAt(0)); 

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1; 
            }

            if (count < 3) {
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }
}
