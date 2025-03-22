// 3174. Clear Digits
// You are given a string s.
// Your task is to remove all digits by doing this operation repeatedly:
// Delete the first digit and the closest non-digit character to its left.
// Return the resulting string after removing all digits.
// Note that the operation cannot be performed on a digit that does not have any non-digit character to its left.
// Example 1:
// Input: s = "abc"
// Output: "abc"
// Explanation:
// There is no digit in the string.
// Example 2:
// Input: s = "cb34"
// Output: ""
// Explanation:
// First, we apply the operation on s[2], and s becomes "c4".
// Then we apply the operation on s[1], and s becomes "".

// CODE

class Solution {
    public String clearDigits(String s) {
        StringBuilder stc = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                stc.deleteCharAt(stc.length() - 1);
            }else{
                stc.append(s.charAt(i));
            }
        }

        return stc.toString();
    }
}
