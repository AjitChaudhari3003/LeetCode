// 70. Climbing Stairs
// You are climbing a staircase. It takes n steps to reach the top.
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
// Example 1:

// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps

// CODE

class Solution {
    public int climbStairs(int n) {
        if(n==0 || n==1){
            return 1;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }
}
