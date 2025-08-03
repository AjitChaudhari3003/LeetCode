// 2106. Maximum Fruits Harvested After at Most K Steps
// Hard
// Topics
// premium lock icon
// Companies
// Hint
// Fruits are available at some positions on an infinite x-axis. You are given a 2D integer array fruits where fruits[i] = [positioni, amounti] depicts amounti fruits at the position positioni. fruits is already sorted by positioni in ascending order, and each positioni is unique.

// You are also given an integer startPos and an integer k. Initially, you are at the position startPos. From any position, you can either walk to the left or right. It takes one step to move one unit on the x-axis, and you can walk at most k steps in total. For every position you reach, you harvest all the fruits at that position, and the fruits will disappear from that position.

// Return the maximum total number of fruits you can harvest.

 

// Example 1:


// Input: fruits = [[2,8],[6,3],[8,6]], startPos = 5, k = 4
// Output: 9
// Explanation: 
// The optimal way is to:
// - Move right to position 6 and harvest 3 fruits
// - Move right to position 8 and harvest 6 fruits
// You moved 3 steps and harvested 3 + 6 = 9 fruits in total.


class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int left = 0, sum = 0, max = 0;

        for (int right = 0; right < fruits.length; right++) {
            sum += fruits[right][1];

            while (left <= right && minSteps(fruits[left][0], fruits[right][0], startPos) > k) {
                sum -= fruits[left][1];
                left++;
            }

            max = Math.max(max, sum);
        }

        return max;
    }

    private int minSteps(int left, int right, int start) {
        // Two paths: left first or right first
        int goLeft = Math.abs(start - left) + (right - left);
        int goRight = Math.abs(start - right) + (right - left);
        return Math.min(goLeft, goRight);
    }
}

