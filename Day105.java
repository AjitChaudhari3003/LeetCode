// 3503. Longest Palindrome After Substring Concatenation I
// You are given two strings, s and t.
// You can create a new string by selecting a substring from s (possibly empty) and a substring from t (possibly empty), then concatenating them in order.
// Return the length of the longest palindrome that can be formed this way.
// Example 1:
// Input: s = "a", t = "a"
// Output: 2
// Explanation:
// Concatenating "a" from s and "a" from t results in "aa", which is a palindrome of length 2.

//   CODE

class Solution {
    public int longestPalindrome(String s, String t) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        fun(s, list1);
        fun(t, list2);
        String sb = "";
        for(int i = 0; i < list1.size(); i++) {
            for(int j = 0; j < list2.size(); j++) {
                String s1 = list1.get(i);
                String s2 = list2.get(j);
                String k = s1 + s2;
                if(isPali(s1) && sb.length() < s1.length()) sb = s1;
                if(isPali(s2) && sb.length() < s2.length()) sb = s2;
                if(isPali(k) && sb.length() < k.length()) sb = k;
            }
        }
        return sb.length();
    }
    static boolean isPali(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    static void fun(String s, List<String> list) {
        for(int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = i; j < s.length(); j++) {
                sb.append(s.charAt(j));
                list.add(sb.toString());
            }
        }
    }
}
