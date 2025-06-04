// 3403. Find the Lexicographically Largest String From the Box I
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given a string word, and an integer numFriends.

// Alice is organizing a game for her numFriends friends. There are multiple rounds in the game, where in each round:

// word is split into numFriends non-empty strings, such that no previous round has had the exact same split.
// All the split words are put into a box.
// Find the lexicographically largest string from the box after all the rounds are finished.

 

// Example 1:

// Input: word = "dbca", numFriends = 2

// Output: "dbc"

// Explanation: 

// All possible splits are:

// "d" and "bca".
// "db" and "ca".
// "dbc" and "a".


class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) return word;

        int n = word.length();
        int len = n - numFriends + 1;
        char maxChar = 'a';

        for (char ch : word.toCharArray()) {
            if (ch > maxChar) maxChar = ch;
        }

        String result = "";
        for (int i = 0; i < n; i++) {
            if (word.charAt(i) == maxChar) {
                if (i + len <= n) {
                    String sub = word.substring(i, i + len);
                    if (sub.compareTo(result) > 0) result = sub;
                } else {
                    String sub = word.substring(i);
                    if (sub.compareTo(result) > 0) result = sub;
                }
            }
        }

        return result;
    }
}
