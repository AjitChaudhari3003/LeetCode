// 812. Largest Triangle Area
// Given an array of points on the X-Y plane points where points[i] = [xi, yi], return the area of the largest triangle that can be formed by any three different points. Answers within 10-5 of the actual answer will be accepted.
// Example 1:
// Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
// Output: 2.00000
// Explanation: The five points are shown in the above figure. The red triangle is the largest.
// Example 2:
// Input: points = [[1,0],[0,0],[0,1]]
// Output: 0.50000

class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double maxArea = 0;

        for (int i = 0; i < n - 2; i++) {
            int a0 = points[i][0], a1 = points[i][1];
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    double area = 0.5 * ((points[j][0] - a0) * (points[k][1] - a1)
                                       - (points[j][1] - a1) * (points[k][0] - a0));
                    if (area < 0) area = -area;  // absolute value
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }
}
