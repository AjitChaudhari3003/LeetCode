// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

// Input: nums = [1,2,3,1]
// Output: true
// Explanation:The element 1 occurs at the indices 0 and 3.

//CODE

class Solution {
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true; 
                }
            }
        }
        return false; 
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 1};

        boolean result = solution.containsDuplicate(nums);

        System.out.println(result); 
    }
}



// Maximum Subarray

// Given an integer array nums, find the subarraywith the largest sum, and return its sum.

// Example 1:
// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.
// Example 2:

// Input: nums = [1]
// Output: 1
// Explanation: The subarray [1] has the largest sum 1.
// Example 3:

// Input: nums = [5,4,-1,7,8]
// Output: 23
// Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

//CODE

class Solution {
    public int maxSubArray(int[] nums) {
        int maxCurrent = nums[0];
        int maxGlobal = nums[0];

        for(int i=1;i<nums.length;i++){

            maxCurrent =  Math.max(nums[i],maxCurrent+nums[i]);

            maxGlobal =  Math.max(maxGlobal , maxCurrent);
        }
        return maxGlobal;
    }

    public static void main(String args){

        Solution solution = new Solution();
        // int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        // System.out.println( solution.maxSubArray(nums));
        int[] nums1 = {1};
        System.out.println( + solution.maxSubArray(nums1));
    }
}
