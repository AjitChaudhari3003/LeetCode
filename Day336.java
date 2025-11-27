// 3381. Maximum Subarray Sum With Length Divisible by K
// You are given an array of integers nums and an integer k.
// Return the maximum sum of a subarray of nums, such that the size of the subarray is divisible by k.
// Example 1:
// Input: nums = [1,2], k = 1
// Output: 3
// Explanation:
// The subarray [1, 2] with sum 3 has length equal to 2 which is divisible by 1.

class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long prefSum = 0;
        long subMax = Long.MIN_VALUE;
        long[] minSoFar = new long[k];
        Arrays.fill(minSoFar, Long.MAX_VALUE / 2);
        minSoFar[(k - 1) % k] = 0;

        for (int i = 0; i < nums.length; i++) {
            prefSum += nums[i];
            subMax = Math.max(subMax, prefSum - minSoFar[i % k]);
            minSoFar[i % k] = Math.min(minSoFar[i % k], prefSum);
        }

        return subMax;
    }
}
