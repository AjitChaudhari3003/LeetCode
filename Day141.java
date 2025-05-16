// 2901. Longest Unequal Adjacent Groups Subsequence II
// Solved
// Medium
// Topics
// Companies
// Hint
// You are given a string array words, and an array groups, both arrays having length n.

// The hamming distance between two strings of equal length is the number of positions at which the corresponding characters are different.

// You need to select the longest subsequence from an array of indices [0, 1, ..., n - 1], such that for the subsequence denoted as [i0, i1, ..., ik-1] having length k, the following holds:

// For adjacent indices in the subsequence, their corresponding groups are unequal, i.e., groups[ij] != groups[ij+1], for each j where 0 < j + 1 < k.
// words[ij] and words[ij+1] are equal in length, and the hamming distance between them is 1, where 0 < j + 1 < k, for all indices in the subsequence.
// Return a string array containing the words corresponding to the indices (in order) in the selected subsequence. If there are multiple answers, return any of them.

// Note: strings in words may be unequal in length.

 

// Example 1:

// Input: words = ["bab","dab","cab"], groups = [1,2,2]

// Output: ["bab","cab"]


class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        Map<String, List<String>> memo = new HashMap<>();
        int n = words.length;
        List<String> best = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<String> res = new ArrayList<>();
            res.add(words[i]);
            res.addAll(helper(i + 1, groups[i], words[i], words, groups, memo));
            if (res.size() > best.size()) best = res;
        }

        return best;
    }

    private List<String> helper(int i, int lastGroup, String lastWord,
                                String[] words, int[] groups, Map<String, List<String>> memo) {
        if (i >= words.length) return new ArrayList<>();
        String key = i + "|" + lastGroup + "|" + lastWord;
        if (memo.containsKey(key)) return memo.get(key);

        List<String> take = new ArrayList<>();
        if (words[i].length() == lastWord.length() &&
            hamming(words[i], lastWord) &&
            groups[i] != lastGroup) {
            take.add(words[i]);
            take.addAll(helper(i + 1, groups[i], words[i], words, groups, memo));
        }

        List<String> skip = helper(i + 1, lastGroup, lastWord, words, groups, memo);
        List<String> result = take.size() > skip.size() ? take : skip;
        memo.put(key, result);
        return result;
    }

    private boolean hamming(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff == 1;
    }
}
