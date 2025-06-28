// 2099. Find Subsequence of Length K With the Largest Sum
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// You are given an integer array nums and an integer k. You want to find a subsequence of nums of length k that has the largest sum.

// Return any such subsequence as an integer array of length k.

// A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

// Example 1:

// Input: nums = [2,1,3,3], k = 2
// Output: [3,3]
// Explanation:
// The subsequence has the largest sum of 3 + 3 = 6.


import java.util.*;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
            if (pq.size() > k) pq.poll();
        }
        int[][] indices = pq.toArray(new int[0][0]);
        Arrays.sort(indices, Comparator.comparingInt(a -> a[1]));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = nums[indices[i][1]];
        }
        return result;
    }
}
