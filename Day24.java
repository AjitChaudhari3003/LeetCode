// 58. Length of Last Word
// Given a string s consisting of words and spaces, return the length of the last word in the string.
// A word is a maximal substringconsisting of non-space characters only.
// Example 1:
// Input: s = "Hello World"
// Output: 5
// Explanation: The last word is "World" with length 5.

// CODE

class Solution {
    public int lengthOfLastWord(String s) {
        int length=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)!= ' '){
                length++;
            }else{
                if(length >0)
                    return length;
                
            }
        }
        return length;
    }
}
