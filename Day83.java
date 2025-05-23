// 3477. Fruits Into Baskets II
// You are given two arrays of integers, fruits and baskets, each of length n, where fruits[i] represents the quantity of the ith type of fruit, and baskets[j] represents the capacity of the jth basket.
// From left to right, place the fruits according to these rules:
// Each fruit type must be placed in the leftmost available basket with a capacity greater than or equal to the quantity of that fruit type.
// Each basket can hold only one type of fruit.
// If a fruit type cannot be placed in any basket, it remains unplaced.
// Return the number of fruit types that remain unplaced after all possible allocations are made.
// Example 1:
// Input: fruits = [4,2,5], baskets = [3,5,4]
// Output: 1
// Explanation:
// fruits[0] = 4 is placed in baskets[1] = 5.
// fruits[1] = 2 is placed in baskets[0] = 3.
// fruits[2] = 5 cannot be placed in baskets[2] = 4.
// Since one fruit type remains unplaced, we return 1.

// CODE

class Solution {
    public int numOfUnplacedFruits(int[] f, int[] b) {
        int n = f.length;
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(b[j] >= f[i] && !set.contains(j)) {
                    set.add(j);
                    count++;
                    break;
                }
            }
        }
        return n - count;
    }
}
