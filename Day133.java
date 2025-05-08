// 3342. Find Minimum Time to Reach Last Room II
// Solved
// Medium
// Topics
// Companies
// Hint
// There is a dungeon with n x m rooms arranged as a grid.

// You are given a 2D array moveTime of size n x m, where moveTime[i][j] represents the minimum time in seconds when you can start moving to that room. You start from the room (0, 0) at time t = 0 and can move to an adjacent room. Moving between adjacent rooms takes one second for one move and two seconds for the next, alternating between the two.

// Return the minimum time to reach the room (n - 1, m - 1).

// Two rooms are adjacent if they share a common wall, either horizontally or vertically.

 

// Example 1:

// Input: moveTime = [[0,4],[4,4]]

// Output: 7

// Explanation:

// The minimum time required is 7 seconds.

// At time t == 4, move from room (0, 0) to room (1, 0) in one second.
// At time t == 5, move from room (1, 0) to room (1, 1) in two seconds.




import java.util.*;

public class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        int[][] bestTime = new int[n][m];
        for (int[] row : bestTime) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0, 0}); // time, i, j, nextMoveTime

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], i = curr[1], j = curr[2], nextMoveTime = curr[3];

            if (time >= bestTime[i][j]) continue;
            bestTime[i][j] = time;

            if (i == n - 1 && j == m - 1) return time;

            for (int[] d : directions) {
                int x = i + d[0], y = j + d[1];
                if (x >= 0 && x < n && y >= 0 && y < m) {
                    int wait = moveTime[x][y];
                    int futureMove = nextMoveTime == 1 ? 2 : 1;
                    int nextTime = wait > time ? wait + futureMove : time + futureMove;

                    if (i == 0 && j == 0 && wait <= time) {
                        nextTime = wait + futureMove;
                    }

                    if (nextTime < bestTime[x][y]) {
                        pq.offer(new int[]{nextTime, x, y, futureMove});
                    }
                }
            }
        }

        return -1;
    }
}
