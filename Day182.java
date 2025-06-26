// 2311. Longest Binary Subsequence Less Than or Equal to K
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given a binary string s and a positive integer k.

// Return the length of the longest subsequence of s that makes up a binary number less than or equal to k.

// Note:

// The subsequence can contain leading zeroes.
// The empty string is considered to be equal to 0.
// A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.
 

// Example 1:

// Input: s = "1001010", k = 5
// Output: 5
// Explanation: The longest subsequence of s that makes up a binary number less than or equal to 5 is "00010", as this number is equal to 2 in decimal.
// Note that "00100" and "00101" are also possible, which are equal to 4 and 5 in decimal, respectively.
// The length of this subsequence is 5, so 5 is returned.





public class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int zeros = 0;
        int ones = 0;
        long value = 0;
        long pow = 1;

        // Count all zeros
        for (char c : s.toCharArray()) {
            if (c == '0') zeros++;
        }

        // Process from right to left
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                if (value + pow > k) {
                    continue; // Skip this '1' as it would exceed k
                }
                value += pow;
                ones++;
            }
            pow <<= 1;
            // Prevent pow from overflowing; if pow is beyond k, no more '1's can be added
            if (pow > k) {
                // Once pow exceeds k, further bits can't be added as their value is too large
                break;
            }
        }
        return zeros + ones;
    }
}
