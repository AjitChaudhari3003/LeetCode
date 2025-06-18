// 2966. Divide Array Into Arrays With Max Difference
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given an integer array nums of size n where n is a multiple of 3 and a positive integer k.

// Divide the array nums into n / 3 arrays of size 3 satisfying the following condition:

// The difference between any two elements in one array is less than or equal to k.
// Return a 2D array containing the arrays. If it is impossible to satisfy the conditions, return an empty array. And if there are multiple answers, return any of them.

 

// Example 1:

// Input: nums = [1,3,4,8,7,9,3,5,1], k = 2

// Output: [[1,1,3],[3,4,5],[7,8,9]]

// Explanation:

// The difference between any two elements in each array is less than or equal to 2.



class Solution 
{
    public int[][] divideArray(int[] nums, int k) 
    {
        // Step 1: Sort the array to group close elements together
        Arrays.sort(nums);

        // Step 2: Prepare list to collect valid triplets
        List<int[]> result = new ArrayList<>();

        // Step 3: Traverse in steps of 3
        for (int i = 0; i < nums.length; i += 3) 
        {
            int a = nums[i];
            int b = nums[i + 1];
            int c = nums[i + 2];

            // Step 3.1: Check if the max difference in this group is ≤ k
            if (c - a > k) 
            {
                return new int[0][];
            }

            // Step 3.2: Add the group to result
            result.add(new int[]{a, b, c});
        }

        // Step 4: Convert list to array and return
        return result.toArray(new int[result.size()][]);
    }
}
