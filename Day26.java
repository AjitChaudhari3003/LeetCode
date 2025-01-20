// 290. Word Pattern
// Given a pattern and a string s, find if s follows the same pattern.
// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:

// Each letter in pattern maps to exactly one unique word in s.
// Each unique word in s maps to exactly one letter in pattern.
// No two letters map to the same word, and no two words map to the same letter.

// Example 1:
// Input: pattern = "abba", s = "dog cat cat dog"
// Output: true

// CODE

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
    if (words.length != pattern.length())
        return false;

    Map index = new HashMap();

    for (Integer i=0; i<words.length; i++)
        if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
            return false;
    return true;
    }
}
