// 2536. Increment Submatrices by One
// You are given a positive integer n, indicating that we initially have an n x n 0-indexed integer matrix mat filled with zeroes.
// You are also given a 2D integer array query. For each query[i] = [row1i, col1i, row2i, col2i], you should do the following operation:
// Add 1 to every element in the submatrix with the top left corner (row1i, col1i) and the bottom right corner (row2i, col2i). That is, add 1 to mat[x][y] for all row1i <= x <= row2i and col1i <= y <= col2i.
// Return the matrix mat after performing every query.
// Example 1:

// Input: n = 3, queries = [[1,1,2,2],[0,0,1,1]]
// Output: [[1,1,0],[1,2,1],[0,1,1]]
// Explanation: The diagram above shows the initial matrix, the matrix after the first query, and the matrix after the second query.
// - In the first query, we add 1 to every element in the submatrix with the top left corner (1, 1) and bottom right corner (2, 2).
// - In the second query, we add 1 to every element in the submatrix with the top left corner (0, 0) and bottom right corner (1, 1).

// Just add 1 to the matrix following the operation
class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = 0;
            }
        }
        // Iterating each query
        for(int[] query : queries){
            // Taking the submatrix's boundary
            int x1 = query[0]; 
            int y1 = query[1];
            int x2 = query[2];
            int y2 = query[3];
            // Adding 1 to the matrix following the operation
            for(int i = x1; i <= x2; i++){
                for(int j = y1 ; j <= y2; j++){
                    matrix[i][j] += 1;
                }
            }
        }
        // Return the final result
        return matrix;
    }
}
