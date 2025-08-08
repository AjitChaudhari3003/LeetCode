// 808. Soup Servings
// Medium
// Topics
// premium lock icon
// Companies
// You have two soups, A and B, each starting with n mL. On every turn, one of the following four serving operations is chosen at random, each with probability 0.25 independent of all previous turns:

// pour 100 mL from type A and 0 mL from type B
// pour 75 mL from type A and 25 mL from type B
// pour 50 mL from type A and 50 mL from type B
// pour 25 mL from type A and 75 mL from type B
// Note:

// There is no operation that pours 0 mL from A and 100 mL from B.
// The amounts from A and B are poured simultaneously during the turn.
// If an operation asks you to pour more than you have left of a soup, pour all that remains of that soup.
// The process stops immediately after any turn in which one of the soups is used up.

// Return the probability that A is used up before B, plus half the probability that both soups are used up in the same turn. Answers within 10-5 of the actual answer will be accepted.

 

// Example 1:

// Input: n = 50
// Output: 0.62500
// Explanation: 
// If we perform either of the first two serving operations, soup A will become empty first.
// If we perform the third operation, A and B will become empty at the same time.
// If we perform the fourth operation, B will become empty first.
// So the total probability of A becoming empty first plus half the probability that A and B become empty at the same time, is 0.25 * (1 + 1 + 0.5 + 0) = 0.625




class Solution {
    public double f(int a, int b, double[][] dp) {
        if (a <= 0 && b > 0) {
            return 1.0;
        }
        if (a == 0 && b == 0) {
            return 0.5;
        }
        if (a > 0 && b <= 0) {
            return 0.0;
        }
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (dp[a][b] != -1) {
            return dp[a][b];
        }

        double x = 0.25 * f(a - 100, b, dp);
        double y = 0.25 * f(a - 75, b - 25, dp);
        double z = 0.25 * f(a - 50, b - 50, dp);
        double w = 0.25 * f(a - 25, b - 75, dp);

        return dp[a][b] = x + y + z + w;
    }

    public double soupServings(int n) {
        if (n > 4800) {
            return 1.0;
        }
        double[][] dp = new double[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return f(n, n, dp);
    }
}
