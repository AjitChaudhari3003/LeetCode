// 3372. Maximize the Number of Target Nodes After Connecting Trees I
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// There exist two undirected trees with n and m nodes, with distinct labels in ranges [0, n - 1] and [0, m - 1], respectively.

// You are given two 2D integer arrays edges1 and edges2 of lengths n - 1 and m - 1, respectively, where edges1[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the first tree and edges2[i] = [ui, vi] indicates that there is an edge between nodes ui and vi in the second tree. You are also given an integer k.

// Node u is target to node v if the number of edges on the path from u to v is less than or equal to k. Note that a node is always target to itself.

// Return an array of n integers answer, where answer[i] is the maximum possible number of nodes target to node i of the first tree if you have to connect one node from the first tree to another node in the second tree.

// Note that queries are independent from each other. That is, for every query you will remove the added edge before proceeding to the next query.

 

// Example 1:

// Input: edges1 = [[0,1],[0,2],[2,3],[2,4]], edges2 = [[0,1],[0,2],[0,3],[2,7],[1,4],[4,5],[4,6]], k = 2

// Output: [9,7,9,8,8]

// Explanation:

// For i = 0, connect node 0 from the first tree to node 0 from the second tree.
// For i = 1, connect node 1 from the first tree to node 0 from the second tree.
// For i = 2, connect node 2 from the first tree to node 4 from the second tree.
// For i = 3, connect node 3 from the first tree to node 4 from the second tree.
// For i = 4, connect node 4 from the first tree to node 4 from the second tree

class Solution {
    /*
       1. From second tree we will choose a node(maxTar), who will have max no of nodes at within k-1 edges bcz
          1 edge will get utilized in joining tree1 and tree2
       2. We will connect every node of tree1 to maxTar node of tree2
       3. For every Node of tree1 we will count the no of nodes within k edges in tree1 and add the value of maxTar node 
          of tree2 in it to get answer for node i of tree1
    */
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n=edges1.length+1, m=edges2.length+1;

        ArrayList<Integer>[] tree1 = formTree(edges1, n);
        ArrayList<Integer>[] tree2 = formTree(edges2, m);
        int[] answer = new int[n];

        int maxTar = 0;
        for(int i=0;i<m;i++){
          maxTar=Math.max(maxTar, maxTargetNodesHelper(i, tree2, k-1));
        }

        for(int i=0;i<n;i++){
            answer[i]=maxTargetNodesHelper(i, tree1, k)+maxTar;
        }

        return answer;
    }
    public ArrayList<Integer>[] formTree(int[][] edges, int n){
      ArrayList<Integer>[] tree = new ArrayList[n];
      for(int i=0;i<n;i++) tree[i]=new ArrayList<>();

      for(int i=0;i<edges.length;i++){
        int u=edges[i][0];
        int v=edges[i][1];
        tree[u].add(v);
        tree[v].add(u);
      }
      return tree;
    }
    public int maxTargetNodesHelper(int src, ArrayList<Integer>[] tree, int k){
      int n=tree.length;
      LinkedList<Pair> queue=new LinkedList<>();
      queue.add(new Pair(src, 0));
      int cnt=0;
      boolean[] visited=new boolean[n];
      while(queue.size()>0){
        Pair rem = queue.removeFirst();
        if(visited[rem.src] || rem.k>k)continue;
        visited[rem.src]=true;
        cnt++;
        for(int child:tree[rem.src]){
            queue.addLast(new Pair(child, rem.k+1));
        }
      }
      return cnt;
    }
}
class Pair{
    int src, k;
    Pair(int src, int k){
        this.src=src;
        this.k=k;
    }
}
