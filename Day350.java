// 3531. Count Covered Buildings
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given a positive integer n, representing an n x n city. You are also given a 2D grid buildings, where buildings[i] = [x, y] denotes a unique building located at coordinates [x, y].

// A building is covered if there is at least one building in all four directions: left, right, above, and below.

// Return the number of covered buildings.

 

// Example 1:



// Input: n = 3, buildings = [[1,2],[2,2],[3,2],[2,1],[2,3]]

// Output: 1

// Explanation:

// Only building [2,2] is covered as it has at least one building:
// above ([1,2])
// below ([3,2])
// left ([2,1])
// right ([2,3])
// Thus, the count of covered buildings is 1.





import java.util.*;

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int m = buildings.length;
        Map<Integer, List<Integer>> row = new HashMap<>();
        Map<Integer, List<Integer>> col = new HashMap<>();
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            row.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            col.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }

        for (List<Integer> ys : row.values()) Collections.sort(ys);
        for (List<Integer> xs : col.values()) Collections.sort(xs);

        int ans = 0;
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            List<Integer> ys = row.get(x);
            List<Integer> xs = col.get(y);

            int posY = Collections.binarySearch(ys, y);
            int posX = Collections.binarySearch(xs, x);
            boolean insideRow = (posY > 0 && posY < ys.size() - 1);
            boolean insideCol = (posX > 0 && posX < xs.size() - 1);

            if (insideRow && insideCol) ans++;
        }
        return ans;
    }
}
