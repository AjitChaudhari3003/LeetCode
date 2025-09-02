// 3025. Find the Number of Ways to Place People I
// You are given a 2D array points of size n x 2 representing integer coordinates of some points on a 2D plane, where points[i] = [xi, yi].
// Count the number of pairs of points (A, B), where
// A is on the upper left side of B, and
// there are no other points in the rectangle (or line) they make (including the border).
// Return the count.
// Example 1:
// Input: points = [[1,1],[2,2],[3,3]]
// Output: 0
// Explanation:
// There is no way to choose A and B so A is on the upper left side of B.


import java.util.*;

class Solution {
    public int numberOfPairs(int[][] points) {
        // Sort by x ascending, y descending
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });

        int n = points.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int top = points[i][1];
            int bot = Integer.MIN_VALUE;

            for (int j = i + 1; j < n; j++) {
                int y = points[j][1];
                if (bot < y && y <= top) {
                    result++;
                    bot = y;
                    if (bot == top) break;
                }
            }
        }

        return result;
    }
}
