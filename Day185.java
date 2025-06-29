// 1498. Number of Subsequences That Satisfy the Given Sum Condition
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given an array of integers nums and an integer target.

// Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less or equal to target. Since the answer may be too large, return it modulo 109 + 7.

 

// Example 1:

// Input: nums = [3,5,6,7], target = 9
// Output: 4
// Explanation: There are 4 subsequences that satisfy the condition.
// [3] -> Min value + max value <= target (3 + 3 <= 9)
// [3,5] -> (3 + 5 <= 9)
// [3,5,6] -> (3 + 6 <= 


class Solution {
    int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums); // Sort to enable two pointer traversal

        // Precompute powers of 2 up to n
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % MOD;
        }

        int left = 0, right = n - 1, ans = 0;

        // Two pointers: shrink window from both sides
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                // All subsequences from left to right are valid
                ans = (ans + power[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }
}
