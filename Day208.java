// 1695. Maximum Erasure Value
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

// Return the maximum score you can get by erasing exactly one subarray.

// An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).

 

// Example 1:

// Input: nums = [4,2,4,5,6]
// Output: 17
// Explanation: The optimal subarray here is [2,4,5,6].




class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet <Integer> set = new HashSet<>();

        int l=0, r=0, maxsum=0, curr=0;

        while(r<nums.length){
            while(set.contains(nums[r])){
                set.remove(nums[l]);
                curr -= nums[l];
                l++;
            }
            set.add(nums[r]);
            curr += nums[r];
            maxsum = Math.max(maxsum, curr);
            r++;
        }
        return maxsum;
    }
}
