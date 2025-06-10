
// 3442. Maximum Difference Between Even and Odd Frequency I
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// You are given a string s consisting of lowercase English letters.

// Your task is to find the maximum difference diff = freq(a1) - freq(a2) between the frequency of characters a1 and a2 in the string such that:

// a1 has an odd frequency in the string.
// a2 has an even frequency in the string.
// Return this maximum difference.

 

// Example 1:

// Input: s = "aaaaabbc"

// Output: 3

// Explanation:

// The character 'a' has an odd frequency of 5, and 'b' has an even frequency of 2.
// The maximum difference is 5 - 2 = 3.

class Solution {
    public int maxDifference(String s) {

        int[] frequency = new int[26];
        
        for (char c : s.toCharArray()) {
            frequency[c - 'a']++; 
        }

        
        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int freq : frequency) {
            if (freq > 0) {  
                if (freq % 2 == 0) {
                    
                    if (freq < minEven) {
                        minEven = freq;
                    }
                } else {
                    
                    if (freq > maxOdd) {
                        maxOdd = freq;
                    }
                }
            }
        }

        
        if (maxOdd == Integer.MIN_VALUE || minEven == Integer.MAX_VALUE) {
            return 0; 
        }

        return maxOdd - minEven;
    }
}  
