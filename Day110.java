// 442. Find All Duplicates in an Array
// Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears at most twice, return an array of all the integers that appears twice.
// You must write an algorithm that runs in O(n) time and uses only constant auxiliary space, excluding the space needed to store the output
// Example 1:
// Input: nums = [4,3,2,7,8,2,3,1]
// Output: [2,3]
// Example 2:
// Input: nums = [1,1,2]
// Output: [1]

//   CODE



class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> duplicates = new ArrayList<>();

        for (int x : nums) {
            int freq = map.getOrDefault(x, 0) + 1;
            map.put(x, freq);

            if (freq == 2) {
                duplicates.add(x);
            }
        }

        return duplicates;
    }
}

