// 414. Third Maximum Number
// Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.
// Example 1:
// Input: nums = [3,2,1]
// Output: 1
// Explanation:
// The first distinct maximum is 3.
// The second distinct maximum is 2.
// The third distinct maximum is 1.

// CODE
class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int distinctCount = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                distinctCount++;
                if (distinctCount == 3) {
                    return nums[i];
                }
            }
        }
        return nums[nums.length - 1];
    }
}
