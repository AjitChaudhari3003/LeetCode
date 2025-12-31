// 1970. Last Day Where You Can Still Cross
// There is a 1-based binary matrix where 0 represents land and 1 represents water. You are given integers row and col representing the number of rows and columns in the matrix, respectively.
// Initially on day 0, the entire matrix is land. However, each day a new cell becomes flooded with water. You are given a 1-based 2D array cells, where cells[i] = [ri, ci] represents that on the ith day, the cell on the rith row and cith column (1-based coordinates) will be covered with water (i.e., changed to 1).
// You want to find the last day that it is possible to walk from the top to the bottom by only walking on land cells. You can start from any cell in the top row and end at any cell in the bottom row. You can only travel in the four cardinal directions (left, right, up, and down).
// Return the last day where it is possible to walk from the top to the bottom by only walking on land cells.
// Example 1:
// Input: row = 2, col = 2, cells = [[1,1],[2,1],[1,2],[2,2]]
// Output: 2
// Explanation: The above image depicts how the matrix changes each day starting from day 0.
// The last day where it is possible to cross from top to bottom is on day 2.


class Solution {
    private int[] parent, rank;
    private int rows, cols;
    private int top, bottom;

    public int latestDayToCross(int row, int col, int[][] cells) {
        rows = row;
        cols = col;

        int n = row * col;
        parent = new int[n + 2];
        rank = new int[n + 2];

        top = n;
        bottom = n + 1;

        for (int i = 0; i < n + 2; i++) parent[i] = i;

        boolean[][] land = new boolean[row][col];

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int d = cells.length - 1; d >= 0; d--) {
            int r = cells[d][0] - 1;
            int c = cells[d][1] - 1;

            land[r][c] = true;
            int id = r * cols + c;

            for (int[] di : dir) {
                int nr = r + di[0], nc = c + di[1];
                if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && land[nr][nc]) {
                    union(id, nr * cols + nc);
                }
            }

            if (r == 0) union(id, top);
            if (r == rows - 1) union(id, bottom);

            if (find(top) == find(bottom)) return d;
        }

        return 0;
    }

    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        if (rank[a] < rank[b]) parent[a] = b;
        else if (rank[a] > rank[b]) parent[b] = a;
        else {
            parent[b] = a;
            rank[a]++;
        }
    }
}
