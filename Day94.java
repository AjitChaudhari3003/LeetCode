// 3471. Find the Largest Almost Missing Integer
// You are given an integer array nums and an integer k.
// An integer x is almost missing from nums if x appears in exactly one subarray of size k within nums.
// Return the largest almost missing integer from nums. If no such integer exists, return -1.
// A subarray is a contiguous sequence of elements within an array.
// Example 1:
// Input: nums = [3,9,2,1,7], k = 3
// Output: 7

//   CODE


public class LargestAlmostMissing {
    public static int findLargestAlmostMissing(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i <= nums.length - k; i++) {
            Set<Integer> subarraySet = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                subarraySet.add(nums[j]);
            }
            for (int num : subarraySet) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
        }
        int result = -1;
        for (int num : countMap.keySet()) {
            if (countMap.get(num) == 1) {
                result = Math.max(result, num);
            }
        }

        return result;
    }
