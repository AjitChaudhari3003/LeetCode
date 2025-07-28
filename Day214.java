// 2044. Count Number of Maximum Bitwise-OR Subsets
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given an integer array nums, find the maximum possible bitwise OR of a subset of nums and return the number of different non-empty subsets with the maximum bitwise OR.

// An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b. Two subsets are considered different if the indices of the elements chosen are different.

// The bitwise OR of an array a is equal to a[0] OR a[1] OR ... OR a[a.length - 1] (0-indexed).

 

// Example 1:

// Input: nums = [3,1]
// Output: 2
// Explanation: The maximum possible bitwise OR of a subset is 3. There are 2 subsets with a bitwise OR of 3:
// - [3]
// - [3,1]
// Example 2:

// Input: nums = [2,2,2]
// Output: 7
// Explanation: All non-empty subsets of [2,2,2] have a bitwise OR of 2. There are 23 - 1 = 7 total subsets





class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int[] dp = new int[1 << 17];
        dp[0] = 1;
        int maxOr = 0;

        for (int num : nums) {
            for (int i = maxOr; i >= 0; i--) {
                dp[i | num] += dp[i];
            }
            maxOr |= num;
        }

        return dp[maxOr];
    }
}
