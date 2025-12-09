// 3583. Count Special Triplets
// You are given an integer array nums.
// A special triplet is defined as a triplet of indices (i, j, k) such that:
// 0 <= i < j < k < n, where n = nums.length
// nums[i] == nums[j] * 2
// nums[k] == nums[j] * 2
// Return the total number of special triplets in the array.
// Since the answer may be large, return it modulo 109 + 7.
// Example 1:
// Input: nums = [6,3,6]
// Output: 1
// Explanation:
// The only special triplet is (i, j, k) = (0, 1, 2), where:
// nums[0] = 6, nums[1] = 3, nums[2] = 6
// nums[0] = nums[1] * 2 = 3 * 2 = 6
// nums[2] = nums[1] * 2 = 3 * 2 = 6


class Solution {
    public int specialTriplets(int[] nums) {
         final int MOD = 1_000_000_007;
        int maxVal = 100000;
        long ans=0;
        int [] right = new int[maxVal+1];
        int [] left = new int [maxVal+1];
        for(int num : nums){
            right[num]++;
        }
        for(int j=0;j<nums.length;j++){
            int mid= nums[j];
            long target =(long) mid*2;
            right[mid]--;
            if (target <= maxVal) {
                ans = (ans + ((long) left[(int) target] * right[(int) target]) % MOD) % MOD;
            }
            left[mid]++;
        }
        return (int)ans;
    }
}
