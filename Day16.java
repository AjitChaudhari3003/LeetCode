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

// end

// 169. Majority Elements
// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

// Example 1:
// Input: nums = [3,2,3]
// Output: 3

// CODE

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    
    }
}
