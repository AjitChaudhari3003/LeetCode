// 342. Power of Four
// Given an integer n, return true if it is a power of four. Otherwise, return false.
// An integer n is a power of four, if there exists an integer x such that n == 4x.
// Example 1:
// Input: n = 16
// Output: true
class Solution {
    public boolean isPowerOfFour(int n) {
        return n>0 && (n&(n-1))==0 && (n-1)%3==0;
    }
}
