// 474. Ones and Zeroes
// You are given an array of binary strings strs and two integers m and n.
// Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
// A set x is a subset of a set y if all elements of x are also elements of y.
// Example 1:
// Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
// Output: 4
// Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
// Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
// {"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.


class Solution {

    // Helper function to count 0s and 1s in a string
    // and check if it fits within remaining m (zeros) and n (ones)
    private boolean isValid(String s, int m, int n, int[] count) {
        int zero = 0, one = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') one++;
            else zero++;
        }

        count[0] = zero;
        count[1] = one;

        return zero <= m && one <= n;
    }

    // Recursive function with memoization
    private int maxSubset(String[] strs, int m, int n, int idx, int[][][] dp) {
        // Base case: All strings processed
        if (idx < 0) {
            return 0;
        }

        // If already computed, return cached result
        if (dp[idx][m][n] != -1) {
            return dp[idx][m][n];
        }

        int pick = 0;
        int[] count = new int[2]; // count[0] -> zeros, count[1] -> ones

        // Option 1: Pick current string (if valid)
        if (isValid(strs[idx], m, n, count)) {
            pick = 1 + maxSubset(strs, m - count[0], n - count[1], idx - 1, dp);
        }

        // Option 2: Skip current string
        int notPick = maxSubset(strs, m, n, idx - 1, dp);

        // Store max of both options
        return dp[idx][m][n] = Math.max(pick, notPick);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int sz = strs.length;

        // 3D DP array: index, zeros left, ones left
        int[][][] dp = new int[sz][m + 1][n + 1];

        // Initialize with -1 (means not computed yet)
        for (int i = 0; i < sz; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return maxSubset(strs, m, n, sz - 1, dp);
    }
}
