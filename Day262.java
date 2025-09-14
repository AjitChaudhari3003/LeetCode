// 966. Vowel Spellchecker
// Given a wordlist, we want to implement a spellchecker that converts a query word into a correct word.
// For a given query word, the spell checker handles two categories of spelling mistakes:
// Capitalization: If the query matches a word in the wordlist (case-insensitive), then the query word is returned with the same case as the case in the wordlist.
// Example: wordlist = ["yellow"], query = "YellOw": correct = "yellow"
// Example: wordlist = ["Yellow"], query = "yellow": correct = "Yellow"
// Example: wordlist = ["yellow"], query = "yellow": correct = "yellow"
// Vowel Errors: If after replacing the vowels ('a', 'e', 'i', 'o', 'u') of the query word with any vowel individually, it matches a word in the wordlist (case-insensitive), then the query word is returned with the same case as the match in the wordlist.
// Example: wordlist = ["YellOw"], query = "yollow": correct = "YellOw"
// Example: wordlist = ["YellOw"], query = "yeellow": correct = "" (no match)
// Example: wordlist = ["YellOw"], query = "yllw": correct = "" (no match)
// In addition, the spell checker operates under the following precedence rules:
// When the query exactly matches a word in the wordlist (case-sensitive), you should return the same word back.
// When the query matches a word up to capitlization, you should return the first such match in the wordlist.
// When the query matches a word up to vowel errors, you should return the first such match in the wordlist.
// If the query has no matches in the wordlist, you should return the empty string.
// Given some queries, return a list of words answer, where answer[i] is the correct word for query = queries[i].
// Example 1:
// Input: wordlist = ["KiTe","kite","hare","Hare"], queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
// Output: ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]





import java.util.*;

class Solution {
    private boolean isVowel(char c) {
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
    private String maskVowels(String s) {
        char[] arr = s.toCharArray();
        for (int i=0;i<arr.length;i++) {
            if (isVowel(arr[i])) arr[i] = 'a';
        }
        return new String(arr);
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>(Arrays.asList(wordlist));
        Map<String,String> lowerMap = new HashMap<>();
        Map<String,String> vowelMap = new HashMap<>();

        for (String w : wordlist) {
            String wl = w.toLowerCase(Locale.ROOT);
            lowerMap.putIfAbsent(wl, w);
            String masked = maskVowels(wl);
            vowelMap.putIfAbsent(masked, w);
        }

        String[] ans = new String[queries.length];
        for (int i=0;i<queries.length;i++) {
            String q = queries[i];
            if (exact.contains(q)) {
                ans[i] = q;
                continue;
            }
            String ql = q.toLowerCase(Locale.ROOT);
            if (lowerMap.containsKey(ql)) {
                ans[i] = lowerMap.get(ql);
                continue;
            }
            String qMasked = maskVowels(ql);
            if (vowelMap.containsKey(qMasked)) {
                ans[i] = vowelMap.get(qMasked);
            } else {
                ans[i] = "";
            }
        }
        return ans;
    }
}
