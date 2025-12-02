// 3623. Count Number of Trapezoids I
// You are given a 2D integer array points, where points[i] = [xi, yi] represents the coordinates of the ith point on the Cartesian plane.
// A horizontal trapezoid is a convex quadrilateral with at least one pair of horizontal sides (i.e. parallel to the x-axis). Two lines are parallel if and only if they have the same slope.
// Return the number of unique horizontal trapezoids that can be formed by choosing any four distinct points from points.
// Since the answer may be very large, return it modulo 109 + 7.
// Example 1:
// Input: points = [[1,0],[2,0],[3,0],[2,2],[3,2]]
// Output: 3
// Explanation:
// There are three distinct ways to pick four points that form a horizontal trapezoid:
// Using points [1,0], [2,0], [3,2], and [2,2].
// Using points [2,0], [3,0], [3,2], and [2,2].
// Using points [1,0], [3,0], [3,2], and [2,2].


import java.util.*;

class Solution {
    public int countTrapezoids(int[][] points) {
        final long MOD = 1_000_000_007L;
        final long INV2 = (MOD + 1) / 2;

        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int[] p : points) {
            int y = p[1];
            freq.put(y, freq.getOrDefault(y, 0) + 1);
        }

        long sumF = 0;
        long sumF2 = 0;

        for (int c : freq.values()) {
            if (c >= 2) {
                long cc = c;
                long f = (cc * (cc - 1) / 2) % MOD;
                sumF = (sumF + f) % MOD;
                sumF2 = (sumF2 + f * f % MOD) % MOD;
            }
        }

        long ans = (sumF * sumF) % MOD;
        ans = (ans - sumF2 + MOD) % MOD;
        ans = ans * INV2 % MOD;

        return (int) ans;
    }
}
