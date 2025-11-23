// 1262. Greatest Sum Divisible by Three
// Given an integer array nums, return the maximum possible sum of elements of the array such that it is divisible by three.
// Example 1:
// Input: nums = [3,6,5,1,8]
// Output: 18
// Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).


class Solution {
    public int maxSumDivThree(int[] nums) {
        int[]dp=new int[3];
        dp[0]=0;
        dp[1]=Integer.MIN_VALUE;
        dp[2]=dp[1];
        for(int val:nums){
            int[]curr=dp.clone();
            for(int i=0;i<dp.length;i++){
                curr[(i+val)%3]=Math.max(curr[(i+val)%3],dp[i]+val);
            }
            dp=curr;
        }
        return dp[0];
    }
}
