// 520. Detect Capital
// We define the usage of capitals in a word to be right when one of the following cases holds:
// Example 1:
// Input: word = "USA"
// Output: true

// CODE

class Solution {
    public boolean detectCapitalUse(String word) {
        int countUpper = 0;
        for(char ch: word.toCharArray()){
            if(Character.isUpperCase(ch)) countUpper++;
        }
        if(countUpper==word.length() || countUpper==0) return true;
        else if (countUpper==1 && Character.isUpperCase(word.charAt(0))) return true;

        return false;
    }
}
