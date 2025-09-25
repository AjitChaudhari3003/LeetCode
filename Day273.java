// 120. Triangle
// Given a triangle array, return the minimum path sum from top to bottom.
// For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
// Example 1:
// Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
// Output: 11
// Explanation: The triangle looks like:
//    2
//   3 4
//  6 5 7
// 4 1 8 3
// The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).



class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                int curr=triangle.get(i).get(j);
                int below=triangle.get(i+1).get(j);
                int blright=triangle.get(i+1).get(j+1);

                triangle.get(i).set(j,curr+Math.min(below,blright));
            }
        }
        return triangle.get(0).get(0);
    }
}
