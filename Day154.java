// 3373. Maximize the Number of Target Nodes After Connecting Trees II
// Hard
// Topics
// premium lock icon
// Companies
// Hint
// There exist two undirected trees with n and m nodes, labeled from [0, n - 1] and [0, m - 1], respectively.

// You are given two 2D integer arrays edges1 and edges2 of lengths n - 1 and m - 1, respectively, where edges1[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the first tree and edges2[i] = [ui, vi] indicates that there is an edge between nodes ui and vi in the second tree.

// Node u is target to node v if the number of edges on the path from u to v is even. Note that a node is always target to itself.

// Return an array of n integers answer, where answer[i] is the maximum possible number of nodes that are target to node i of the first tree if you had to connect one node from the first tree to another node in the second tree.

// Note that queries are independent from each other. That is, for every query you will remove the added edge before proceeding to the next query.

 

// Example 1:

// Input: edges1 = [[0,1],[0,2],[2,3],[2,4]], edges2 = [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]]

// Output: [8,7,7,8,8]

// Explanation:

// For i = 0, connect node 0 from the first tree to node 0 from the second tree.
// For i = 1, connect node 1 from the first tree to node 4 from the second tree.
// For i = 2, connect node 2 from the first tree to node 7 from the second tree.
// For i = 3, connect node 3 from the first tree to node 0 from the second tree.
// For i = 4, connect node 4 from the first tree to node 4 from the second tree



import java.util.*;

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> tree1 = buildGraph(edges1, n);
        List<List<Integer>> tree2 = buildGraph(edges2, m);

        int[] color1 = new int[2];
        int[] nodeColor1 = new int[n];
        bfs(tree1, color1, nodeColor1);

        int[] color2 = new int[2];
        int[] nodeColor2 = new int[m];
        bfs(tree2, color2, nodeColor2);

        int maxColor2 = Math.max(color2[0], color2[1]);

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = color1[nodeColor1[i]] + maxColor2;
        }

        return result;
    }

    private List<List<Integer>> buildGraph(int[][] edges, int size) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < size; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }

    private void bfs(List<List<Integer>> graph, int[] colorCount, int[] nodeColor) {
        int n = graph.size();
        boolean[] visited = new boolean[n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0], color = curr[1];
            nodeColor[node] = color;
            colorCount[color]++;

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, 1 - color});
                }
            }
        }
    }
}
