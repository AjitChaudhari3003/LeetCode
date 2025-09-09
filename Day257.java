// 2327. Number of People Aware of a Secret
// On day 1, one person discovers a secret.
// You are given an integer delay, which means that each person will share the secret with a new person every day, starting from delay days after discovering the secret. You are also given an integer forget, which means that each person will forget the secret forget days after discovering it. A person cannot share the secret on the same day they forgot it, or on any day afterwards.
// Given an integer n, return the number of people who know the secret at the end of day n. Since the answer may be very large, return it modulo 109 + 7.
// Example 1:
// Input: n = 6, delay = 2, forget = 4
// Output: 5
// Explanation:
// Day 1: Suppose the first person is named A. (1 person)
// Day 2: A is the only person who knows the secret. (1 person)
// Day 3: A shares the secret with a new person, B. (2 people)
// Day 4: A shares the secret with a new person, C. (3 people)
// Day 5: A forgets the secret, and B shares the secret with a new person, D. (3 people)
// Day 6: B shares the secret with E, and C shares the secret with F. (5 people)


class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        final int MOD = 1000000007;
        
        long know = 1;
        long spread = 0;
        
        Map<Integer, Integer> forgetOnDay = new HashMap<>();
        Map<Integer, Integer> beginSpreadOnDay = new HashMap<>();
        
        beginSpreadOnDay.put(delay + 1, 1);
        forgetOnDay.put(forget + 1, 1);
        
        for (int day = 2; day <= n; day++) {
            spread = (spread + beginSpreadOnDay.getOrDefault(day, 0) 
                     - forgetOnDay.getOrDefault(day, 0) + MOD) % MOD;
            know = (know + spread - forgetOnDay.getOrDefault(day, 0) + MOD) % MOD;
            
            beginSpreadOnDay.put(day + delay, (int)spread);
            forgetOnDay.put(day + forget, (int)spread);
        }
        
        return (int)know;
    }
}
