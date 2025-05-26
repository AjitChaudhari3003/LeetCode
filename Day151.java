// 1857. Largest Color Value in a Directed Graph
// Solved
// Hard
// Topics
// Companies
// Hint
// There is a directed graph of n colored nodes and m edges. The nodes are numbered from 0 to n - 1.

// You are given a string colors where colors[i] is a lowercase English letter representing the color of the ith node in this graph (0-indexed). You are also given a 2D array edges where edges[j] = [aj, bj] indicates that there is a directed edge from node aj to node bj.

// A valid path in the graph is a sequence of nodes x1 -> x2 -> x3 -> ... -> xk such that there is a directed edge from xi to xi+1 for every 1 <= i < k. The color value of the path is the number of nodes that are colored the most frequently occurring color along that path.

// Return the largest color value of any valid path in the given graph, or -1 if the graph contains a cycle.

 

// Example 1:



// Input: colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]]
// Output: 3
// Explanation: The path 0 -> 2 -> 3 -> 4 contains 3 nodes that are colored "a" (red in the above image)

class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n];

        // Build graph
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }

        // dp[node][color] stores max count of color in any path ending at node
        int[][] dp = new int[n][26];
        Queue<Integer> queue = new LinkedList<>();
        
        // Initialize queue with nodes having inDegree 0
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        int visited = 0;
        int maxColorValue = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;
            int colorIndex = colors.charAt(node) - 'a';
            dp[node][colorIndex]++;
            maxColorValue = Math.max(maxColorValue, dp[node][colorIndex]);

            for (int neighbor : graph.get(node)) {
                // Update dp for neighbor using current node's dp
                for (int c = 0; c < 26; c++) {
                    dp[neighbor][c] = Math.max(dp[neighbor][c], dp[node][c]);
                }
                // Decrease in-degree and add to queue if it becomes 0
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If not all nodes are visited, there's a cycle
        return visited == n ? maxColorValue : -1;
    }
}
