// 3307. Find the K-th Character in String Game II
// Hard
// Topics
// premium lock icon
// Companies
// Hint
// Alice and Bob are playing a game. Initially, Alice has a string word = "a".

// You are given a positive integer k. You are also given an integer array operations, where operations[i] represents the type of the ith operation.

// Now Bob will ask Alice to perform all operations in sequence:

// If operations[i] == 0, append a copy of word to itself.
// If operations[i] == 1, generate a new string by changing each character in word to its next character in the English alphabet, and append it to the original word. For example, performing the operation on "c" generates "cd" and performing the operation on "zb" generates "zbac".
// Return the value of the kth character in word after performing all the operations.

// Note that the character 'z' can be changed to 'a' in the second type of operation.

 

// Example 1:

// Input: k = 5, operations = [0,0,0]

// Output: "a"

// Explanation:

// Initially, word == "a". Alice performs the three operations as follows:

// Appends "a" to "a", word becomes "aa".
// Appends "aa" to "aa", word becomes "aaaa".
// Appends "aaaa" to "aaaa", word becomes "aaaaaaaa".


class Solution {
    //to cal next char for given char
    char next(char c){
        int next = (c-'a'+1)%26;
        return (char) (next+'a');
    }

    //cal max possible x such that 2^x < num
    int getLowerPower2(long num){
        long p = 1;
        int x = 0;
        while(p*2 < num){
            p *= 2;;
            x++;
        }
        return x;
    }
    char solve(long k,int[] op){
        //base case k == 1 means first char 'a'
        if(k == 1)     return 'a';

        //get the lower power of 2 such that 2^l < k
        int l = getLowerPower2(k);

        long p = ((long) 1<<l);
        //if the operation at index l is 0 next the char is taken same from last string
        if(op[l]==0)
            return solve(k-p,op);
        //else next char is taken from prev string
        return next(solve(k-p,op));
    }
    public char kthCharacter(long k, int[] operations) {
        return solve(k,operations);
    }
}
