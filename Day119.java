// 2799. Count Complete Subarrays in an Array
// You are given an array nums consisting of positive integers.
// We call a subarray of an array complete if the following condition is satisfied:
// The number of distinct elements in the subarray is equal to the number of distinct elements in the whole array.
// Return the number of complete subarrays.
// A subarray is a contiguous non-empty part of an array.
// Example 1:
// Input: nums = [1,3,1,2,2]
// Output: 4
// Explanation: The complete subarrays are the following: [1,3,1,2], [1,3,1,2,2], [3,1,2] and [3,1,2,2].

// CODE

public class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> distinctElements = new HashSet<>();
        for (int num : nums) {
            distinctElements.add(num);
        }
        int totalDistinct = distinctElements.size();
        int count = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            Set<Integer> currentSet = new HashSet<>();
            for (int j = i; j < n; j++) {
                currentSet.add(nums[j]);
                if (currentSet.size() == totalDistinct) {
                    count += (n - j);
                    break;
                }
            }
        }
        return count;
    }
}
