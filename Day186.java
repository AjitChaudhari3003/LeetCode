// 594. Longest Harmonious Subsequence
// Easy
// Topics
// premium lock icon
// Companies
// We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.

// Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.

 

// Example 1:

// Input: nums = [1,3,2,2,5,2,3,7]

// Output: 5

// Explanation:

// The longest harmonious subsequence is [3,2,2,2,3].


class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> freq=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
        }

        int len=0;
        for(int num:freq.keySet()){
            if(freq.containsKey(num+1)){
                int currlen=freq.get(num)+freq.get(num+1);
                len=Math.max(len,currlen);
            }
        }
        return len;
    }
}
