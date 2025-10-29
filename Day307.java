// 3370. Smallest Number With All Set Bits
// Return the smallest number x greater than or equal to n, such that the binary representation of x contains only set bits
// Example 1:
// Input: n = 5
// Output: 7
// Explanation:
// The binary representation of 7 is "111".
// Example 2:
// Input: n = 10
// Output: 15
// Explanation:
// The binary representation of 15 is "1111".


class Solution {
    public int smallestNumber(int n) {
        int ajit=Integer.highestOneBit(n);
        return (ajit<<1)-1;
    }
}
