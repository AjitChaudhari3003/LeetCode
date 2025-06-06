// 2434. Using a Robot to Print the Lexicographically Smallest String
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given a string s and a robot that currently holds an empty string t. Apply one of the following operations until s and t are both empty:

// Remove the first character of a string s and give it to the robot. The robot will append this character to the string t.
// Remove the last character of a string t and give it to the robot. The robot will write this character on paper.
// Return the lexicographically smallest string that can be written on the paper.

 

// Example 1:

// Input: s = "zza"
// Output: "azz"
// Explanation: Let p denote the written string.
// Initially p="", s="zza", t="".
// Perform first operation three times p="", s="", t="zza".
// Perform second operation three times p="azz", s="", t="".

import java.util.*;

class Solution {
    public String robotWithString(String s) {
        Stack<Character> stack = new Stack<>();
        int[] freq = new int[26];
        
        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        StringBuilder t = new StringBuilder();

        for (char ch : s.toCharArray()) {
            stack.push(ch);
            freq[ch - 'a']--;

            // Check if we can pop the top of the stack
            while (!stack.isEmpty() && stack.peek() <= smallestChar(freq)) {
                t.append(stack.pop());
            }
        }

        // Append remaining characters from stack
        while (!stack.isEmpty()) {
            t.append(stack.pop());
        }

        return t.toString();
    }

    // Helper function to find the smallest character still available
    private char smallestChar(int[] freq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                return (char) ('a' + i);
            }
        }
        return 'a';
    }
}
