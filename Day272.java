// 166. Fraction to Recurring Decimal
// Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
// If the fractional part is repeating, enclose the repeating part in parentheses.
// If multiple answers are possible, return any of them.
// It is guaranteed that the length of the answer string is less than 104 for all the given inputs.
// Example 1:
// Input: numerator = 1, denominator = 2
// Output: "0.5"
// Example 2:
// Input: numerator = 2, denominator = 1
// Output: "2"

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder res = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) res.append('-');

        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);

        res.append(n / d);
        long rem = n % d;
        if (rem == 0) return res.toString();

        res.append('.');
        Map<Long, Integer> seen = new HashMap<>();

        while (rem != 0) {
            if (seen.containsKey(rem)) {
                int pos = seen.get(rem);
                res.insert(pos, "(");
                res.append(')');
                break;
            }
            seen.put(rem, res.length());
            rem *= 10;
            res.append(rem / d);
            rem = rem % d;
        }
        return res.toString();
    }
}
