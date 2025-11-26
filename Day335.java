// 2435. Paths in Matrix Whose Sum Is Divisible by K
// You are given a 0-indexed m x n integer matrix grid and an integer k. You are currently at position (0, 0) and you want to reach position (m - 1, n - 1) moving only down or right.
// Return the number of paths where the sum of the elements on the path is divisible by k. Since the answer may be very large, return it modulo 109 + 7.
// Example 1:
// Input: grid = [[5,2,4],[3,0,5],[0,7,2]], k = 3
// Output: 2
// Explanation: There are two paths where the sum of the elements on the path is divisible by k.
// The first path highlighted in red has a sum of 5 + 2 + 4 + 5 + 2 = 18 which is divisible by 3.
// The second path highlighted in blue has a sum of 5 + 3 + 0 + 5 + 2 = 15 which is divisible by 3.

class Solution {
  public int numberOfPaths(int[][] grid, int k) {
    Integer[][][] mem = new Integer[grid.length][grid[0].length][k];
    return numberOfPaths(grid, 0, 0, 0, k, mem);
  }

  private static final int MOD = 1_000_000_007;

  // Returns the number of paths to (i, j), where the sum / k == `sum`.
  private int numberOfPaths(int[][] grid, int i, int j, int sum, int k, Integer[][][] mem) {
    if (i == grid.length || j == grid[0].length)
      return 0;
    if (i == grid.length - 1 && j == grid[0].length - 1)
      return (sum + grid[i][j]) % k == 0 ? 1 : 0;
    if (mem[i][j][sum] != null)
      return mem[i][j][sum];
    final int newSum = (sum + grid[i][j]) % k;
    return mem[i][j][sum] = (numberOfPaths(grid, i + 1, j, newSum, k, mem) +
                             numberOfPaths(grid, i, j + 1, newSum, k, mem)) %
                            MOD;
  }
}
