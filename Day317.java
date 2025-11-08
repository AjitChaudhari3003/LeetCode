// 1611. Minimum One Bit Operations to Make Integers Zero
// Given an integer n, you must transform it into 0 using the following operations any number of times:
// Change the rightmost (0th) bit in the binary representation of n.
// Change the ith bit in the binary representation of n if the (i-1)th bit is set to 1 and the (i-2)th through 0th bits are set to 0.
// Return the minimum number of operations to transform n into 0.
// Example 1:
// Input: n = 3
// Output: 2
// Explanation: The binary representation of 3 is "11".
// "11" -> "01" with the 2nd operation since the 0th bit is 1.
// "01" -> "00" with the 1st operation.


class Solution {
    public int minimumOneBitOperations(int n) {
        
        if(n==0) return 0;

        int msb=31-Integer.numberOfLeadingZeros(n);

        int mask=1<<msb;
        int range=(1<<(msb+1))-1;

        int next= n^mask;

        int resNext=minimumOneBitOperations(next);

        return range-resNext;
    }
}
