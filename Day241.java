// 1493. Longest Subarray of 1's After Deleting One Element
// Given a binary array nums, you should delete one element from it.
// Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
// Example 1:
// Input: nums = [1,1,0,1]
// Output: 3
// Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.

class Solution {
    public int longestSubarray(int[] nums) {
        int i=0,j=0, count=0, maxi=0 ,n=nums.length;
        
        while(j<n){
            if(nums[j]==0)
            count++;

            while(count>1){
                if(nums[i]==0)
                count--;

                i++;
            }
           

            maxi=Math.max(maxi,j-i);
            j++;
        }
        return maxi;
    }
}
