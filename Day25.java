// 125. Valid Palindrome
// A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
// Example 1:
// Input: s = "A man, a plan, a canal: Panama"
// Output: true
// Explanation: "amanaplanacanalpanama" is a palindrome.
// Example 2:
// Input: s = "race a car"
// Output: false
// Explanation: "raceacar" is not a palindrome.

// CODE

class Solution {
    public boolean isPalindrome(String s) {
        
     StringBuilder normalized = new StringBuilder();

      for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isLetterOrDigit(c)) {
        normalized.append(Character.toLowerCase(c));
    }
}
      int start=0;
      int end=normalized.length()-1;

       while(start< end){
        if(normalized.charAt(start) != normalized.charAt(end)){
            return false;
        }
            start++;
            end--;
        
       }
       return true;

    }
}
