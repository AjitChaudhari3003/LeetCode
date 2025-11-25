// 1015. Smallest Integer Divisible by K
// Given a positive integer k, you need to find the length of the smallest positive integer n such that n is divisible by k, and n only contains the digit 1.
// Return the length of n. If there is no such n, return -1.
// Note: n may not fit in a 64-bit signed integer.
// Example 1:
// Input: k = 1
// Output: 1
// Explanation: The smallest answer is n = 1, which has length 1.

class Solution {
  public int smallestRepunitDivByK(int k) {
    if (k % 10 != 1 && k % 10 != 3 && k % 10 != 7 && k % 10 != 9)
      return -1;

    Set<Integer> seen = new HashSet<>();
    int n = 0;

    for (int length = 1; length <= k; ++length) {
      n = (n * 10 + 1) % k;
      if (n == 0)
        return length;
      if (seen.contains(n))
        return -1;
      seen.add(n);
    }

    return -1;
  }
}
