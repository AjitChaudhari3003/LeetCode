// 757. Set Intersection Size At Least Two
// You are given a 2D integer array intervals where intervals[i] = [starti, endi] represents all the integers from starti to endi inclusively.
// A containing set is an array nums where each interval from intervals has at least two integers in nums.
// For example, if intervals = [[1,3], [3,7], [8,9]], then [1,2,4,7,8,9] and [2,3,4,8,9] are containing sets.
// Return the minimum possible size of a containing set.
// Example 1:
// Input: intervals = [[1,3],[3,7],[8,9]]
// Output: 5
// Explanation: let nums = [2, 3, 4, 8, 9].
// It can be shown that there cannot be any containing array of size 4.

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int prev1 = intervals[0][1] - 1;
        int prev2 = intervals[0][1];
        int count = 2;
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end   = intervals[i][1];
            if (prev2 < start) {
                prev1 = end - 1;
                prev2 = end;
                count += 2;
            }
            else if (prev1 < start) {
                if (end == prev2) {
                    prev1 = end - 1;
                } else {
                    prev1 = end;
                }
                if (prev1 > prev2) {
                    int temp = prev1;
                    prev1 = prev2;
                    prev2 = temp;
                }
                count += 1;
            }
        }
        return count;
    }
}
