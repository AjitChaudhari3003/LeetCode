// 3194. Minimum Average of Smallest and Largest Elements
// You have an array of floating point numbers averages which is initially empty. You are given an array nums of n integers where n is even.
// You repeat the following procedure n / 2 times:
// Remove the smallest element, minElement, and the largest element maxElement, from nums.
// Add (minElement + maxElement) / 2 to averages.
// Return the minimum element in averages.
// Example 1:
// Input: nums = [7,8,3,4,15,13,4,1]
// Output: 5.5

//   CODE


  import java.util.*;

class Solution {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double firstAvg = Double.MAX_VALUE;
        int i=0 , j = nums.length-1;
        while(i<j){
            double avg= (nums[i] + nums[j])/2.0;
            firstAvg = Math.min(firstAvg, avg);
            i++;
            j--;
        }
        return firstAvg;
    }
}
