// 3024. Type of Triangle
// Easy
// Topics
// Companies
// Hint
// You are given a 0-indexed integer array nums of size 3 which can form the sides of a triangle.

// A triangle is called equilateral if it has all sides of equal length.
// A triangle is called isosceles if it has exactly two sides of equal length.
// A triangle is called scalene if all its sides are of different lengths.
// Return a string representing the type of triangle that can be formed or "none" if it cannot form a triangle.

 

// Example 1:

// Input: nums = [3,3,3]
// Output: "equilateral"
// Explanation: Since all the sides are of equal length, therefore, it will form an equilateral triangle.


import java.util.*;

class Solution {
    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        if (nums[0] + nums[1] <= nums[2]) return "none";
        if (set.size() == 1) return "equilateral";
        if (set.size() == 2) return "isosceles";
        return "scalene";
    }
}
