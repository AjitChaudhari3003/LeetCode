// 440. K-th Smallest in Lexicographical Order
// Given two integers n and k, return the kth lexicographically smallest integer in the range [1, n].
// Example 1:
// Input: n = 13, k = 2
// Output: 10
// Explanation: The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.

class Solution {
    public int findKthNumber(int n, int k) {
        long res = 1;
        k = k - 1;

        while (k > 0) {
            int gap = getGap(n, res, res + 1);
            if (gap <= k) {
                res += 1;
                k -= gap;
            } else {
                res *= 10;
                k -= 1;
            }
        }

        return (int) res;
    }

    int getGap(int n, long a, long b) {
        int gap = 0;
        while (a <= n) {
            gap += Math.min(n + 1L, b) - a;
            a *= 10;
            b *= 10;
        }
        return gap;
    }
}
