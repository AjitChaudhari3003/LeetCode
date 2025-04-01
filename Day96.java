// 3483. Unique 3-Digit Even Numbers
// You are given an array of digits called digits. Your task is to determine the number of distinct three-digit even numbers that can be formed using these digits.
// Note: Each copy of a digit can only be used once per number, and there may not be leading zeros.
// Example 1:
// Input: digits = [1,2,3,4]
// Output: 12
// Explanation: The 12 distinct 3-digit even numbers that can be formed are 124, 132, 134, 142, 214, 234, 312, 314, 324, 342, 412, and 432. 
// Note that 222 cannot be formed because there is only 1 copy of the digit 2.

//   CODE

class Solution {
    public int totalNumbers(int[] digits) {
        HashSet<Integer> set = new HashSet<>();
        int n = digits.length;
        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) continue;
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    if (digits[k] % 2 == 0) {
                        int number = digits[i] * 100 + digits[j] * 10 + digits[k];
                        set.add(number);
                    }
                }
            }
        }
        return set.size();
    }
}
