// 2616. Minimize the Maximum Difference of Pairs
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given a 0-indexed integer array nums and an integer p. Find p pairs of indices of nums such that the maximum difference amongst all the pairs is minimized. Also, ensure no index appears more than once amongst the p pairs.

// Note that for a pair of elements at the index i and j, the difference of this pair is |nums[i] - nums[j]|, where |x| represents the absolute value of x.

// Return the minimum maximum difference among all p pairs. We define the maximum of an empty set to be zero.

 

// Example 1:

// Input: nums = [10,1,2,7,1,3], p = 2
// Output: 1
// Explanation: The first pair is formed from the indices 1 and 4, and the second pair is formed from the indices 2 and 5. 
// The maximum difference is max(|nums[1] - nums[4]|, |nums[2] - nums[5]|) = max(0, 1) = 1. Therefore, we return 1.



class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int low=0;
        int high=nums[nums.length-1]-nums[0];

       while (low < high) 
        {
            int mid = (low + high) >>> 1;

            if (canFormPairs(nums, p, mid)) 
            {
                high = mid;
            } 
            else 
            {
                low = mid + 1;
            }
        }

        
        return low;
    }

    
    public boolean canFormPairs(int[] nums, int p, int maxDiff) 
    {
        int count = 0;
        for (int i = 1; i < nums.length && count < p;) 
        {
            if (nums[i] - nums[i - 1] <= maxDiff) 
            {
                count++;
                i += 2;
            } 
            else 
            {
                i++;
            }
        }
        
        return count >= p;
    }
}
