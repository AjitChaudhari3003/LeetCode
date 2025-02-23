// 506. Relative Ranks
// You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.
// The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:
// The 1st place athlete's rank is "Gold Medal".
// The 2nd place athlete's rank is "Silver Medal".
// The 3rd place athlete's rank is "Bronze Medal".
// For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
// Return an array answer of size n where answer[i] is the rank of the ith athlete.
// Example 1:

// Input: score = [5,4,3,2,1]
// Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
// Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th]

//   CODE

class Solution {
    public static String[] findRelativeRanks(int[] score) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for ( int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }
        Arrays.sort(score);
        String[] str = new String[score.length];
        for ( int i = score.length-1; i >= 0; i--) {
            if ( i == score.length-1) {
                str[map.get(score[i])] = "Gold Medal";
            }
            else if ( i == score.length-2) {
                str[map.get(score[i])] = "Silver Medal";
            }
            else if( i == score.length-3) {
                str[map.get(score[i])] = "Bronze Medal";
            }
            else {
                str[map.get(score[i])] = Integer.toString(score.length-i);
            }
        }
        return str;
    }
}
