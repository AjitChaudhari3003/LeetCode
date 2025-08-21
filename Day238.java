// 1504. Count Submatrices With All Ones
// Given an m x n binary matrix mat, return the number of submatrices that have all ones.
// Example 1:
// Input: mat = [[1,0,1],[1,1,0],[1,1,0]]
// Output: 13
// Explanation: 
// There are 6 rectangles of side 1x1.
// There are 2 rectangles of side 1x2.
// There are 3 rectangles of side 2x1.
// There is 1 rectangle of side 2x2. 
// There is 1 rectangle of side 3x1.
// Total number of rectangles = 6 + 2 + 3 + 1 + 1 = 13.



class Solution {
    public int numSubmat(int[][] mat) {
        int m=mat.length, n=mat[0].length;
        int[] h=new int[n];
        int count=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                h[j]=mat[i][j]==1?h[j]+1:0;

                int mn=h[j];
                for(int k=j;k>=0 && mn>0;k--){
                    mn=Math.min(mn,h[k]);
                    count+=mn;
                }
            }
        }
        return count;
    }
}
