// 3479. Fruits Into Baskets III
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Hint
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



class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        int N = 1;
        while(N <= n) N <<= 1;
        // Build the segment tree
        int[] segTree = new int[N << 1];
        for (int i = 0; i < n; i++)
        segTree[N + i] = baskets[i];
        for (int i = N - 1; i > 0; i--) 
        segTree[i] = Math.max(segTree[2 * i], segTree[2 * i + 1]);
        int count = 0;
        for (int i = 0; i < n; ++i) {
            int x = fruits[i];
            int index = 1; // Start from the root of the segment tree
            if (segTree[index] < x) {
                count++;
                continue;
            }
            // Query the first valid basket
            while (index < N) {
                if (segTree[index * 2] >= x) 
                index *= 2;
                else
                index = index * 2 + 1;
            }
            // Mark the found basket as used and update the segment tree
            segTree[index] = -1;
            while (index > 1) {
                index >>= 1;
                segTree[index] = Math.max(segTree[2 * index], segTree[2 * index + 1]);
            }
        }
        return count;     
    }
}
