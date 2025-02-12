// 3432. Count Partitions with Even Sum Difference
// You are given an integer array nums of length n.
// Example 1:
// Input: nums = [10,10,3,7,6]
// Output: 4

// CODE

  class Solution {
    public int countPartitions(int[] nums) {
        int totalSum = 0;
        for (int i=0;i<nums.length;i++) {
            totalSum += nums[i]; 
        }

        int leftSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) { 
            leftSum += nums[i]; 
            int rightSum = totalSum - leftSum; 
  
            if ((leftSum % 2) == (rightSum % 2)) {
                count++; 
            }
        }
        return count; 
    }
    }
