// 3397. Maximum Number of Distinct Elements After Operations
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given an integer array nums and an integer k.

// You are allowed to perform the following operation on each element of the array at most once:

// Add an integer in the range [-k, k] to the element.
// Return the maximum possible number of distinct elements in nums after performing the operations.

 

// Example 1:

// Input: nums = [1,2,2,3,3,4], k = 2

// Output: 6

// Explanation:

// nums changes to [-1, 0, 1, 2, 3, 4] after performing operations on the first four elements.




class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);

        int count=1;

        int prev=nums[0]-k;

        for(int i=1;i<nums.length;i++){
            int min = nums[i]-k;
            int max=nums[i]+k;
            if(min >prev){
                count++;
                prev=min;
            }else if(prev<max){
                prev +=1;
                count++;
            }else
            continue;
        }
        return count;
    }
}
