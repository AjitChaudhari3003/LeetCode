// 1298. Maximum Candies You Can Get from Boxes
// Hard
// Topics
// premium lock icon
// Companies
// Hint
// You have n boxes labeled from 0 to n - 1. You are given four arrays: status, candies, keys, and containedBoxes where:

// status[i] is 1 if the ith box is open and 0 if the ith box is closed,
// candies[i] is the number of candies in the ith box,
// keys[i] is a list of the labels of the boxes you can open after opening the ith box.
// containedBoxes[i] is a list of the boxes you found inside the ith box.
// You are given an integer array initialBoxes that contains the labels of the boxes you initially have. You can take all the candies in any open box and you can use the keys in it to open new boxes and you also can use the boxes you find in it.

// Return the maximum number of candies you can get following the rules above.

 

// Example 1:

// Input: status = [1,0,1,0], candies = [7,5,4,100], keys = [[],[],[1],[]], containedBoxes = [[1,2],[3],[],[]], initialBoxes = [0]
// Output: 16
// Explanation: You will be initially given box 0. You will find 7 candies in it and boxes 1 and 2.
// Box 1 is closed and you do not have a key for it so you will open box 2. You will find 4 candies and a key to box 1 in box 2.
// In box 1, you will find 5 candies and box 3 but you will not find a key to box 3 so box 3 will remain closed.
// Total number of candies collected = 7 + 4 + 5 = 16 candy.


class Solution {
    public int maxCandies(int[] status,int[] candies,int[][] keys,int[][] containedBoxes,int[] initialBoxes) {

        int count=0; // Total candies collected
        boolean[] vis=new boolean[status.length]; // Track visited boxes
        for(int v:initialBoxes){
            dfs(v,status,keys,containedBoxes,vis);
        }

        for(int i=0;i<candies.length;i++){
            if(vis[i]&&status[i]==1){
                count+=candies[i];
            }
        }
        return count;
    }

    public void dfs(int v,int[] status,int[][] keys,int[][] containedBoxes,boolean[] vis){ 

        vis[v]=true; // Mark the current box as visited
        for(int vKey:keys[v]){
            if(vKey==v) continue; // Skip self-key
            status[vKey]=1; // Unlock the box
        }

        for(int vContained:containedBoxes[v]){
            if(!vis[vContained]){
                dfs(vContained,status,keys,containedBoxes,vis);
            }
        }
    }
}
