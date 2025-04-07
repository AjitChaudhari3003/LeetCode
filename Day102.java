// 383. Ransom Note
// Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
// Each letter in magazine can only be used once in ransomNote.
// Example 1:
// Input: ransomNote = "a", magazine = "b"
// Output: false

//   CODE


class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counter = new int[128];
        for (final char ch : magazine.toCharArray())
            ++counter[ch];
        for (final char ch : ransomNote.toCharArray())
            if (--counter[ch] < 0)
                return false;
        return true;      
    }
}
