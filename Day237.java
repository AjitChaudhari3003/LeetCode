// 1277. Count Square Submatrices with All Ones
// Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
// Example 1:
// Input: matrix =
// [
//   [0,1,1,1],
//   [1,1,1,1],
//   [0,1,1,1]
// ]
// Output: 15
// Explanation: 
// There are 10 squares of side 1.
// There are 4 squares of side 2.
// There is  1 square of side 3.
// Total number of squares = 10 + 4 + 1 = 15.


class Solution {
    public int countSquares(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length==0)
        return 0;

        int m=matrix.length;
        int n = matrix[0].length;
        int res=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1 && i>0 && j>0){
                    matrix[i][j]=Math.min(
                        matrix[i-1][j-1],
                        Math.min(matrix[i-1][j],matrix[i][j-1])
                    )+1;
                }
                res +=matrix[i][j];
            }
        }
        return res;
    }
}
