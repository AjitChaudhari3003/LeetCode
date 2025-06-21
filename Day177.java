// 3085. Minimum Deletions to Make String K-Special
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given a string word and an integer k.

// We consider word to be k-special if |freq(word[i]) - freq(word[j])| <= k for all indices i and j in the string.

// Here, freq(x) denotes the frequency of the character x in word, and |y| denotes the absolute value of y.

// Return the minimum number of characters you need to delete to make word k-special.

 

// Example 1:

// Input: word = "aabcaba", k = 0

// Output: 3

// Explanation: We can make word 0-special by deleting 2 occurrences of "a" and 1 occurrence of "c". Therefore, word becomes equal to "baba" where freq('a') == freq('b') == 2.


class Solution {
    public int minimumDeletions(String word, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : word.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        List<Integer> counts = new ArrayList<>(freq.values());
        Collections.sort(counts);

        int n = counts.size();
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int range = counts.get(i) + k;
            int total = counts.get(i);

            for (int j = i + 1; j < n; j++) {
                if (counts.get(j) > range)
                    total += range;
                else
                    total += counts.get(j);
            }

            int remain = word.length() - total;
            ans = Math.min(ans, remain);
        }

        return ans;
    }
}
