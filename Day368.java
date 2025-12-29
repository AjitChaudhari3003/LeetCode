// 756. Pyramid Transition Matrix
// You are stacking blocks to form a pyramid. Each block has a color, which is represented by a single letter. Each row of blocks contains one less block than the row beneath it and is centered on top.
// To make the pyramid aesthetically pleasing, there are only specific triangular patterns that are allowed. A triangular pattern consists of a single block stacked on top of two blocks. The patterns are given as a list of three-letter strings allowed, where the first two characters of a pattern represent the left and right bottom blocks respectively, and the third character is the top block.
// For example, "ABC" represents a triangular pattern with a 'C' block stacked on top of an 'A' (left) and 'B' (right) block. Note that this is different from "BAC" where 'B' is on the left bottom and 'A' is on the right bottom.
// You start with a bottom row of blocks bottom, given as a single string, that you must use as the base of the pyramid.
// Given bottom and allowed, return true if you can build the pyramid all the way to the top such that every triangular pattern in the pyramid is in allowed, or false otherwise.
// Example 1:

// Input: bottom = "BCD", allowed = ["BCC","CDE","CEA","FFF"]
// Output: true
// Explanation: The allowed triangular patterns are shown on the right.
// Starting from the bottom (level 3), we can build "CE" on level 2 and then build "A" on level 1.
// There are three triangular patterns in the pyramid, which are "BCC", "CDE", and "CEA". All are allowed.


class Solution {
    Map<String, Boolean> memo = new HashMap<>();
    private boolean backtrack(int i, StringBuilder current,StringBuilder base, int n,Set<String> allowed) {
        if (n == 0) return true;
        if (i == 0) {
            String key = base.toString();
            if (memo.containsKey(key)) {
                return memo.get(key);
            }
        }
        if (i == n) {
            boolean res = backtrack(0, new StringBuilder(), current, n-1, allowed);
            memo.put(base.toString(), res);
            return res;
        }
        for (char ch = 'A'; ch <= 'F'; ++ch) {
            current.append(ch);
            StringBuilder block = new StringBuilder(base.substring(i, i + 2));
            block.append(ch);
            if (allowed.contains(block.toString()))
                if (backtrack(i + 1, current, base, n, allowed))
                    return true;
            current.deleteCharAt(current.length() - 1);
        }
        memo.put(base.toString(), false);
        return false;
    }
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Set<String> hset = new HashSet<>(allowed);
        return backtrack(0, new StringBuilder(),new StringBuilder(bottom),bottom.length() - 1,hset);
    }
}
