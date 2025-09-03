// 3027. Find the Number of Ways to Place People II
// You are given a 2D array points of size n x 2 representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
// We define the right direction as positive x-axis (increasing x-coordinate) and the left direction as negative x-axis (decreasing x-coordinate). Similarly, we define the up direction as positive y-axis (increasing y-coordinate) and the down direction as negative y-axis (decreasing y-coordinate)
// You have to place n people, including Alice and Bob, at these points such that there is exactly one person at every point. Alice wants to be alone with Bob, so Alice will build a rectangular fence with Alice's position as the upper left corner and Bob's position as the lower right corner of the fence (Note that the fence might not enclose any area, i.e. it can be a line). If any person other than Alice and Bob is either inside the fence or on the fence, Alice will be sad.
// Return the number of pairs of points where you can place Alice and Bob, such that Alice does not become sad on building the fence.
// Note that Alice can only build a fence with Alice's position as the upper left corner, and Bob's position as the lower right corner. For example, Alice cannot build either of the fences in the picture below with four corners (1, 1), (1, 3), (3, 1), and (3, 3), because:
// With Alice at (3, 3) and Bob at (1, 1), Alice's position is not the upper left corner and Bob's position is not the lower right corner of the fence.
// With Alice at (1, 3) and Bob at (1, 1), Bob's position is not the lower right corner of the fence.
// Example 1:
// Input: points = [[1,1],[2,2],[3,3]]
// Output: 0
// Explanation: There is no way to place Alice and Bob such that Alice can build a fence with Alice's position as the upper left corner and Bob's position as the lower right corner. Hence we return 0. 


import java.util.*;

class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int cnt = 0;

        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        Map<Integer, Integer> mpx = new HashMap<>();
        Map<Integer, Integer> mpy = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mpx.put(points[i][0], mpx.getOrDefault(points[i][0], 0) + 1);
            mpy.put(points[i][1], mpy.getOrDefault(points[i][1], 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];

                if (p1[0] < p2[0] && p1[1] < p2[1]) continue;
                if (p1[0] == p2[0] || p1[1] == p2[1]) continue;

                boolean check = true;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    int[] p = points[k];
                    int px = p[0], py = p[1];
                    if (px >= p1[0] && px <= p2[0] && py >= p2[1] && py <= p1[1]) {
                        check = false;
                        break;
                    }
                }
                if (check) cnt++;
            }
        }

        for (int val : mpx.values()) {
            cnt += val - 1;
        }
        for (int val : mpy.values()) {
            cnt += val - 1;
        }

        return cnt;
    }
}
