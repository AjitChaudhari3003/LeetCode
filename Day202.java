// 3201. Find the Maximum Length of Valid Subsequence I
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given an integer array nums.
// A subsequence sub of nums with length x is called valid if it satisfies:

// (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2.
// Return the length of the longest valid subsequence of nums.

// A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

// Example 1:

// Input: nums = [1,2,3,4]

// Output: 4

// Explanation:

// The longest valid subsequence is [1, 2, 3, 4].


class Solution {
    public int maximumLength(int[] nums) {
        int cnt1 = 0, cnt2 = 0;
        for (int num : nums) {
            if (num % 2 == 0) cnt1++;
            else cnt2++;
        }

        int eve = 0, odd = 0;
        for (int num : nums) {
            if (num % 2 == 0)
                eve = Math.max(eve, odd + 1);
            else
                odd = Math.max(odd, eve + 1);
        }

        return Math.max(Math.max(cnt1, cnt2), Math.max(eve, odd));
    }
}
