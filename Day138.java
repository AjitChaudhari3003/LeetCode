// 3335. Total Characters in String After Transformations I
// Medium
// Topics
// Companies
// Hint
// You are given a string s and an integer t, representing the number of transformations to perform. In one transformation, every character in s is replaced according to the following rules:

// If the character is 'z', replace it with the string "ab".
// Otherwise, replace it with the next character in the alphabet. For example, 'a' is replaced with 'b', 'b' is replaced with 'c', and so on.
// Return the length of the resulting string after exactly t transformations.

// Since the answer may be very large, return it modulo 109 + 7.

 

// Example 1:

// Input: s = "abcyy", t = 2

// Output: 7

// Explanation:

// First Transformation (t = 1):
// 'a' becomes 'b'
// 'b' becomes 'c'
// 'c' becomes 'd'
// 'y' becomes 'z'
// 'y' becomes 'z'
// String after the first transformation: "bcdzz"
// Second Transformation (t = 2):
// 'b' becomes 'c'
// 'c' becomes 'd'
// 'd' becomes 'e'
// 'z' becomes "ab"
// 'z' becomes "ab"
// String after the second transformation: "cdeabab"
// Final Length of the string: The string is "cdeabab", which has 7 characters.


class Solution {
  private static final int MOD = 1_000_000_007;
  public int lengthAfterTransformations(String s, int t) {
    int[] freq = new int[26];
    for (char c : s.toCharArray()) freq[c-'a']++;
    while (t-- > 0) {
      int[] temp = new int[26];
      for (int j=0; j<25; j++) temp[j+1] = freq[j];
      temp[0] = (temp[0] + freq[25]) % MOD;
      temp[1] = (temp[1] + freq[25]) % MOD;
      freq = temp;
    }
    long ans=0;
    for (int x: freq) ans=(ans+x)%MOD;
    return (int)ans;
  }
}
