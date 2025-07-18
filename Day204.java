// 2163. Minimum Difference in Sums After Removal of Elements
// Solved
// Hard
// Topics
// premium lock icon
// Companies
// Hint
// You are given a 0-indexed integer array nums consisting of 3 * n elements.

// You are allowed to remove any subsequence of elements of size exactly n from nums. The remaining 2 * n elements will be divided into two equal parts:

// The first n elements belonging to the first part and their sum is sumfirst.
// The next n elements belonging to the second part and their sum is sumsecond.
// The difference in sums of the two parts is denoted as sumfirst - sumsecond.

// For example, if sumfirst = 3 and sumsecond = 2, their difference is 1.
// Similarly, if sumfirst = 2 and sumsecond = 3, their difference is -1.
// Return the minimum difference possible between the sums of the two parts after the removal of n elements.

 

// Example 1:

// Input: nums = [3,1,2]
// Output: -1
// Explanation: Here, nums has 3 elements, so n = 1. 
// Thus we have to remove 1 element from nums and divide the array into two equal parts.
// - If we remove nums[0] = 3, the array will be [1,2]. The difference in sums of the two parts will be 1 - 2 = -1.
// - If we remove nums[1] = 1, the array will be [3,2]. The difference in sums of the two parts will be 3 - 2 = 1.
// - If we remove nums[2] = 2, the array will be [3,1]. The difference in sums of the two parts will be 3 - 1 = 2.
// The minimum difference between sums of the two parts is min(-1,1,2) = -1. 


class Solution {
 public long minimumDifference(int[] nums) {
     int n = nums.length, k = n / 3;
     long[] leftMins = new long[n];   // sum of k smallest from left
     long[] rightMaxs = new long[n];  // sum of k largest from right
     long leftSum = 0, rightSum = 0, minDiff = Long.MAX_VALUE;

     PriorityQueue<Integer> maxLeftHeap = new PriorityQueue<>((a, b) -> b - a); // max-heap
     PriorityQueue<Integer> minRightHeap = new PriorityQueue<>();              // min-heap

     // Build leftMins
     for (int i = 0; i < k; i++) {
         maxLeftHeap.offer(nums[i]);
         leftSum += nums[i];
     }
     leftMins[k - 1] = leftSum;

     for (int i = k; i < n - k; i++) {
         int x = nums[i];
         if (x < maxLeftHeap.peek()) {
             leftSum += x - maxLeftHeap.poll();
             maxLeftHeap.offer(x);
         }
         leftMins[i] = leftSum;
     }

     // Build rightMaxs
     for (int i = n - 1; i >= n - k; i--) {
         minRightHeap.offer(nums[i]);
         rightSum += nums[i];
     }
     rightMaxs[n - k] = rightSum;

     for (int i = n - k - 1; i >= k - 1; i--) {
         int x = nums[i];
         if (x > minRightHeap.peek()) {
             rightSum += x - minRightHeap.poll();
             minRightHeap.offer(x);
         }
         rightMaxs[i] = rightSum;
     }

     // Find minimum difference
     for (int i = k - 1; i < n - k; i++) {
         minDiff = Math.min(minDiff, leftMins[i] - rightMaxs[i + 1]);
     }

     return minDiff;
 }
}
