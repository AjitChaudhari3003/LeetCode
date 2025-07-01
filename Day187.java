// 3330. Find the Original Typed String I
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// Alice is attempting to type a specific string on her computer. However, she tends to be clumsy and may press a key for too long, resulting in a character being typed multiple times.

// Although Alice tried to focus on her typing, she is aware that she may still have done this at most once.

// You are given a string word, which represents the final output displayed on Alice's screen.

// Return the total number of possible original strings that Alice might have intended to type.

 

// Example 1:

// Input: word = "abbcccc"

// Output: 5

// Explanation:

// The possible strings are: "abbcccc", "abbccc", "abbcc", "abbc", and "abcccc".


class Solution {
    public int possibleStringCount(String word) {
        int ans=1;
        int cnt=1;
        char ch=word.charAt(0);

        for(int i=1;i<word.length();i++){
            if(word.charAt(i)==ch)
            cnt++;
            else{
                ans +=(cnt-1);
                ch=word.charAt(i);
                cnt=1;
            }
        }
        ans += cnt-1;
        return ans;
    }
}
