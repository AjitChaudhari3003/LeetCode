//  Subarray Sum Equals K
// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
// Example 1:
// Input: nums = [1,1,1], k = 2
// Output: 2
// Example 2:
// Input: nums = [1,2,3], k = 3
// Output: 2

//CODE

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        for (int i=0;i<nums.length;i++){
            int sum=0;
            for (int j=i;j<nums.length;j++){
                sum +=nums[j];
                if(sum==k){
                    count++;
                }
            }
        }
        return count;
    }
}

// end

// Longest Sub-Array with Sum K
// Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray 
// where the sum of its elements is equal to the given value k. It is guaranteed that a valid subarray exists.
// Examples:
// Input: arr[] = [10, 5, 2, 7, 1, 9], k = 15
// Output: 4
// Explanation: The subarray [5, 2, 7, 1] has a sum of 15 and length 4.

//CODE

class Solution {
    public int lenOfLongestSubarr(int[] arr, int k) {
        int maxLength=0;
        int n=arr.length;
        for (int i=0;i<n;i++){
            int sum=0;
            for (int j=i;j<n;j++){
                sum +=arr[j];
                if(sum==k){
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
      return maxLength;  
    }
}
