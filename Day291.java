// 2273. Find Resultant Array After Removing Anagrams
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// You are given a 0-indexed string array words, where words[i] consists of lowercase English letters.

// In one operation, select any index i such that 0 < i < words.length and words[i - 1] and words[i] are anagrams, and delete words[i] from words. Keep performing this operation as long as you can select an index that satisfies the conditions.

// Return words after performing all operations. It can be shown that selecting the indices for each operation in any arbitrary order will lead to the same result.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase using all the original letters exactly once. For example, "dacb" is an anagram of "abdc".


class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        List<Map<Character, Integer>> freq = new ArrayList<>();
        for (String w : words) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : w.toCharArray())
                map.put(c, map.getOrDefault(c, 0) + 1);
            freq.add(map);
        }

        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        for (int i = 1; i < n; i++) {
            if (!freq.get(i).equals(freq.get(i - 1)))
                ans.add(words[i]);
        }
        return ans;
    }
}
