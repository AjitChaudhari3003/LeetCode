// 3186. Maximum Total Damage With Spell Casting
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// A magician has various spells.

// You are given an array power, where each element represents the damage of a spell. Multiple spells can have the same damage value.

// It is a known fact that if a magician decides to cast a spell with a damage of power[i], they cannot cast any spell with a damage of power[i] - 2, power[i] - 1, power[i] + 1, or power[i] + 2.

// Each spell can be cast only once.

// Return the maximum possible total damage that a magician can cast.

 

// Example 1:

// Input: power = [1,1,3,4]

// Output: 6

// Explanation:

// The maximum possible damage of 6 is produced by casting spells 0, 1, 3 with damage 1, 1, 4.


import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
        if (power.length == 0) return 0;

        Arrays.sort(power);
        List<Integer> vals = new ArrayList<>();
        List<Long> earn = new ArrayList<>();

        for (int i = 0; i < power.length; ) {
            int v = power[i];
            long sum = 0;
            while (i < power.length && power[i] == v) {
                sum += v;
                i++;
            }
            vals.add(v);
            earn.add(sum);
        }

        int n = vals.size();
        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int nextIdx = Collections.binarySearch(vals, vals.get(i) + 3);
            if (nextIdx < 0) nextIdx = -nextIdx - 1;
            long take = earn.get(i) + dp[nextIdx];
            long skip = dp[i + 1];
            dp[i] = Math.max(take, skip);
        }

        return dp[0];
    }
}
