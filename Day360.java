// 955. Delete Columns to Make Sorted II
// Medium
// Topics
// premium lock icon
// Companies
// You are given an array of n strings strs, all of the same length.

// We may choose any deletion indices, and we delete all the characters in those indices for each string.

// For example, if we have strs = ["abcdef","uvwxyz"] and deletion indices {0, 2, 3}, then the final array after deletions is ["bef", "vyz"].

// Suppose we chose a set of deletion indices answer such that after deletions, the final array has its elements in lexicographic order (i.e., strs[0] <= strs[1] <= strs[2] <= ... <= strs[n - 1]). Return the minimum possible value of answer.length.

 

// Example 1:

// Input: strs = ["ca","bb","ac"]
// Output: 1
// Explanation: 
// After deleting the first column, strs = ["a", "b", "c"].
// Now strs is in lexicographic order (ie. strs[0] <= strs[1] <= strs[2]).
// We require at least 1 deletion since initially strs was not in lexicographic order, so the answer is 1.




class Solution {
    public int minDeletionSize(String[] strs) {
        int n=strs.length;
        int m=strs[0].length();

        boolean sorted[]=new boolean[n-1];
        int del=0;

        for(int i=0;i<m;i++){
            boolean needdel=false;

            for(int j=0;j<n-1;j++){
                if(!sorted[j] && strs[j].charAt(i)>strs[j+1].charAt(i)){
                    needdel=true;
                    break;
                }
            }
            if(needdel){
                del++;
                continue;
            }
            for(int j=0;j<n-1;j++){
                if(!sorted[j] && strs[j].charAt(i) < strs[j + 1].charAt(i))
                sorted[j]=true;
            }
        }
        return del;
    }
}
