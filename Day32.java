// 459. Repeated Substring Pattern
// Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
// Example 1:

// Input: s = "abab"
// Output: true
// Explanation: It is the substring "ab" twice

// CODE

class Solution { 
	public boolean repeatedSubstringPattern(String s) {
		String str=s+s;
		String str1=str.substring(1, str.length()-1); 
		return str1.contains(s);
	}
}
