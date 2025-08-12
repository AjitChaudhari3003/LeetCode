// 2787. Ways to Express an Integer as Sum of Powers
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given two positive integers n and x.

// Return the number of ways n can be expressed as the sum of the xth power of unique positive integers, in other words, the number of sets of unique integers [n1, n2, ..., nk] where n = n1x + n2x + ... + nkx.

// Since the result can be very large, return it modulo 109 + 7.

// For example, if n = 160 and x = 3, one way to express n is n = 23 + 33 + 53.

 

// Example 1:

// Input: n = 10, x = 2
// Output: 1
// Explanation: We can express n as the following: n = 32 + 12 = 10.
// It can be shown that it is the only way to express 10 as the sum of the 2nd power of unique integers.



class Solution {
    static final int M = (int)1e9 + 7;

    private int func(int n, int sum, int x, int num) {
        if (sum == n) { return 1; }
        int tmp = (int) Math.pow(num, x);

        if (sum + tmp > n) { return 0; }

        int take = func(n, sum + tmp, x, num + 1);
        int notTake = func(n, sum, x, num + 1);

        return (take + notTake) % M;
    }

    public int numberOfWays(int n, int x) {
        return func(n, 0, x, 1);
    }
}
