// 136. Single Number
// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

// Example 1:
// Input: nums = [2,2,1]
// Output: 1

// CODE

class Solution {
    public int singleNumber(int[] nums) {
        int res=0;
        for(int i=0;i<nums.length;i++){
            res ^=nums[i];
        }
         return res;
    }
}
