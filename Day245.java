// 3446. Sort Matrix by Diagonals
// You are given an n x n square matrix of integers grid. Return the matrix such that:
// The diagonals in the bottom-left triangle (including the middle diagonal) are sorted in non-increasing order.
// The diagonals in the top-right triangle are sorted in non-decreasing order.

// Example 1:
// Input: grid = [[1,7,3],[9,8,2],[4,5,6]]
// Output: [[8,2,3],[9,6,7],[4,5,1]]
// Explanation:
// The diagonals with a black arrow (bottom-left triangle) should be sorted in non-increasing order:
// [1, 8, 6] becomes [8, 6, 1].
// [9, 5] and [4] remain unchanged.
// The diagonals with a blue arrow (top-right triangle) should be sorted in non-decreasing order:
// [7, 2] becomes [2, 7].
// [3] remains unchanged.



class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        // Bottom-left diagonals (including main diagonal) → descending
        for (int startRow = n - 1; startRow >= 0; startRow--) {
            List<Integer> diagonal = new ArrayList<>();
            int r = startRow, c = 0;
            while (r < n && c < n) {
                diagonal.add(grid[r][c]);
                r++;
                c++;
            }
            // sort descending
            diagonal.sort((a, b) -> b - a);

            r = startRow; c = 0;
            int pos = 0;
            while (r < n && c < n) {
                grid[r][c] = diagonal.get(pos++);
                r++;
                c++;
            }
        }

        // Top-right diagonals → ascending
        for (int startCol = 1; startCol < n; startCol++) {
            List<Integer> diagonal = new ArrayList<>();
            int r = 0, c = startCol;
            while (r < n && c < n) {
                diagonal.add(grid[r][c]);
                r++;
                c++;
            }
            // sort ascending
            diagonal.sort(Integer::compareTo);

            r = 0; c = startCol;
            int pos = 0;
            while (r < n && c < n) {
                grid[r][c] = diagonal.get(pos++);
                r++;
                c++;
            }
        }

        return grid;
    }
}
