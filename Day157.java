// 2929. Distribute Candies Among Children II
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given two positive integers n and limit.

// Return the total number of ways to distribute n candies among 3 children such that no child gets more than limit candies.

 

// Example 1:

// Input: n = 5, limit = 2
// Output: 3
// Explanation: There are 3 ways to distribute 5 candies such that no child gets more than 2 candies: (1, 2, 2), (2, 1, 2) and (2, 2, 1).

class Solution {
    public long distributeCandies(int n, int limit) {
        java.util.function.LongUnaryOperator C2 = x -> (x >= 2) ? (x * (x - 1) / 2) : 0L;
        long N = n, L = limit;
        long total = (N + 2) * (N + 1) / 2;
        long x1 = N - L + 1; 
        long t1 = C2.applyAsLong(x1);
        long x2 = N - 2 * L;
        long t2 = C2.applyAsLong(x2);
        long x3 = N - 3 * L - 1;
        long t3 = C2.applyAsLong(x3);
        return total - 3 * t1 + 3 * t2 - t3;
    }
}
