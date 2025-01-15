// 349. Intersection of Two Arrays
// Given two integer arrays nums1 and nums2, return an array of their 
// intersection
// Each element in the result must be unique and you may return the result in any order.
// Example 1:
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]
// Example 2:
// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]
// Explanation: [4,9] is also accepted.

// CODE

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
       HashSet<Integer> set = new HashSet<>();
        List<Integer> common = new ArrayList<>();
        
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                common.add(num);
                set.remove(num); 
            }
        }
        int[] result = new int[common.size()];
        for (int i = 0; i < common.size(); i++) {
            result[i] = common.get(i);
        }
        return result;
    }
}
