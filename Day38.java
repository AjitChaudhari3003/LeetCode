// 15. 3Sum
// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Example 1:

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]

// CODE

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> op = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int current_sum = nums[left] + nums[right];
                if (current_sum == target) {
                    op.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (current_sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return op;
    }
}
  
