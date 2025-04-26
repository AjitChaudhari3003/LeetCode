// 2444. Count Subarrays With Fixed Bounds
// You are given an integer array nums and two integers minK and maxK.
// A fixed-bound subarray of nums is a subarray that satisfies the following conditions:
// The minimum value in the subarray is equal to minK.
// The maximum value in the subarray is equal to maxK.
// Return the number of fixed-bound subarrays.
// A subarray is a contiguous part of an array.
// Example 1:
// Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
// Output: 2
// Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
// CODE
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count=0;
        for(int i=0;i<nums.length;i++){
            int mini =Integer.MAX_VALUE,maxi=Integer.MIN_VALUE;
            for(int j=i;j<nums.length;j++){
                mini=Math.min(mini,nums[j]);
                maxi=Math.max(maxi,nums[j]);

                if(mini==minK && maxi==maxK)
                count++;
            }
        }
        return count;
    }
}
