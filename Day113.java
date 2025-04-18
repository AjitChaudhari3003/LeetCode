// 438. Find All Anagrams in a String
// Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
// Example 1:
// Input: s = "cbaebabacd", p = "abc"
// Output: [0,6]
// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".


//   CODE

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
     List<Integer> result = new ArrayList<>();
     if(s.length()<p.length())return result;

       int[] pCount = new int[26];
       int[] sCount = new int[26]; 

        for(char c:p.toCharArray()){
            pCount[c-'a']++;
        }

        for(int i=0;i<p.length();i++){
            sCount[s.charAt(i)-'a']++;
        }
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (Arrays.equals(pCount, sCount)) {
                result.add(i);
            }

        if (i + p.length() < s.length()) {
                sCount[s.charAt(i) - 'a']--;   
                sCount[s.charAt(i + p.length()) - 'a']++;  
            }
        }

        return result;
    }
}
