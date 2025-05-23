// 3068. Find the Maximum Sum of Node Values
// Hard
// Topics
// Companies
// Hint
// There exists an undirected tree with n nodes numbered 0 to n - 1. You are given a 0-indexed 2D integer array edges of length n - 1, where edges[i] = [ui, vi] indicates that there is an edge between nodes ui and vi in the tree. You are also given a positive integer k, and a 0-indexed array of non-negative integers nums of length n, where nums[i] represents the value of the node numbered i.

// Alice wants the sum of values of tree nodes to be maximum, for which Alice can perform the following operation any number of times (including zero) on the tree:

// Choose any edge [u, v] connecting the nodes u and v, and update their values as follows:
// nums[u] = nums[u] XOR k
// nums[v] = nums[v] XOR k
// Return the maximum possible sum of the values Alice can achieve by performing the operation any number of times.

 

// Example 1:


// Input: nums = [1,2,1], k = 3, edges = [[0,1],[0,2]]
// Output: 6
// Explanation: Alice can achieve the maximum sum of 6 using a single operation:
// - Choose the edge [0,2]. nums[0] and nums[2] become: 1 XOR 3 = 2, and the array nums becomes: [1,2,1] -> [2,2,2].
// The total sum of values is 2 + 2 + 2 = 6.
// It can be shown that 6 is the maximum achievable sum of values.

class Solution 
{
    public long maximumValueSum(int[] nums, int k, int[][] edges) 
    {
        // Step 1: Compute the base sum
        long baseSum = 0;
        List<Integer> gains = new ArrayList<>();

        // Step 2: Compute gain for each node if XORed with k
        for (int num : nums) 
        {
            int xorVal = num ^ k;
            int gain = xorVal - num;
            baseSum += num;
            gains.add(gain);
        }

        // Step 3: Sort gains in descending order
        gains.sort(Collections.reverseOrder());

        // Step 4: Try taking top even number of gains to maximize gain
        long maxGain = 0, currentGain = 0;
        int count = 0;

        for (int g : gains) 
        {
            currentGain += g;
            count++;
        
            // Step 5: Only accept the gain if we have added even number of gains
            if (count % 2 == 0) 
            {
                maxGain = Math.max(maxGain, currentGain);
            }
        }

        // Step 6: Return final result
        return baseSum + maxGain;
    }
}
