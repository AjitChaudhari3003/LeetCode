// 3337. Total Characters in String After Transformations II
// Hard
// Topics
// Companies
// Hint
// You are given a string s consisting of lowercase English letters, an integer t representing the number of transformations to perform, and an array nums of size 26. In one transformation, every character in s is replaced according to the following rules:

// Replace s[i] with the next nums[s[i] - 'a'] consecutive characters in the alphabet. For example, if s[i] = 'a' and nums[0] = 3, the character 'a' transforms into the next 3 consecutive characters ahead of it, which results in "bcd".
// The transformation wraps around the alphabet if it exceeds 'z'. For example, if s[i] = 'y' and nums[24] = 3, the character 'y' transforms into the next 3 consecutive characters ahead of it, which results in "zab".
// Return the length of the resulting string after exactly t transformations.

// Since the answer may be very large, return it modulo 109 + 7.

 

// Example 1:

// Input: s = "abcyy", t = 2, nums = [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2]

// Output: 7


import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;
    
    // Matrix multiplication
    private long[][] multiply(long[][] a, long[][] b) {
        long[][] res = new long[26][26];
        for (int i = 0; i < 26; ++i) {
            for (int k = 0; k < 26; ++k) {
                if (a[i][k] == 0) continue;
                for (int j = 0; j < 26; ++j) {
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        return res;
    }
    
    // Matrix exponentiation
    private long[][] matrixPow(long[][] mat, int power) {
        long[][] result = new long[26][26];
        for (int i = 0; i < 26; ++i) {
            result[i][i] = 1;
        }
        while (power > 0) {
            if (power % 2 == 1) {
                result = multiply(result, mat);
            }
            mat = multiply(mat, mat);
            power /= 2;
        }
        return result;
    }
    
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        // Initialize the transition matrix
        long[][] transition = new long[26][26];
        for (int c = 0; c < 26; ++c) {
            int num = nums.get(c);
            for (int j = 1; j <= num; ++j) {
                int nextChar = (c + j) % 26;
                transition[c][nextChar]++;
            }
        }
        
        // Raise the transition matrix to the t-th power
        long[][] matPow = matrixPow(transition, t);
        
        // Initialize the initial count vector
        long[] cnt = new long[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        
        // Multiply the count vector by the matrix^t
        long[] newCnt = new long[26];
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < 26; ++j) {
                newCnt[j] = (newCnt[j] + cnt[i] * matPow[i][j]) % MOD;
            }
        }
        
        // Sum all the counts
        long total = 0;
        for (long x : newCnt) {
            total = (total + x) % MOD;
        }
        return (int)total;
    }
}
