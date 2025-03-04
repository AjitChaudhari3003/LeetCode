// 409. Longest Palindrome
// Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
// Letters are case sensitive, for example, "Aa" is not considered a palindrome.
// Example 1:
// Input: s = "abccccdd"
// Output: 7
// Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.

//   CODE

public class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int length = 0;
        for (char c : s.toCharArray()) {
            if (charSet.contains(c)) {
                charSet.remove(c);
                length += 2;
            } else {
                charSet.add(c);
            }
        }
        if (!charSet.isEmpty()) {
            length += 1;
        }
        return length;
    }
}
