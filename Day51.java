// 205. Isomorphic Strings
// Given two strings s and t, determine if they are isomorphic.
// Example 1:
// Input: s = "egg", t = "add"
// Output: true
// Explanation:
// The strings s and t can be made identical by:
// Mapping 'e' to 'a'.
// Mapping 'g' to 'd'.

// CODE

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] indexS = new int[200]; 
        int[] indexT = new int[200]; 
        
        int len = s.length();
        
        if(len != t.length()) {
            return false;
        }
        
        for(int i = 0; i < len; i++) {
            if(indexS[s.charAt(i)] != indexT[t.charAt(i)]) {
                return false; 
            }
            
            indexS[s.charAt(i)] = i + 1; 
            indexT[t.charAt(i)] = i + 1; 
        }
        
        return true;
    }
}
