// 747. Largest Number At Least Twice of Others
// You are given an integer array nums where the largest integer is unique.
// Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, return the index of the largest element, or return -1 otherwise.
// Example 1:

// Input: nums = [3,6,1,0]
// Output: 1
// Explanation: 6 is the largest integer.
// For every other number in the array x, 6 is at least twice as big as x.
// The index of value 6 is 1, so we return 1.

//   CODE

class Solution {
    public int dominantIndex(int[] nums) {
        int idx=0;
        for(int i=0;i<nums.length;i++)
            if(nums[i]>nums[idx])
            idx=i;

        for(int i=0;i<nums.length;i++)
        if(i!=idx &&(nums[i]*2)>nums[idx])
        return -1;

        return idx;
    }

}
