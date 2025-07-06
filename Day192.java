// 1865. Finding Pairs With a Certain Sum
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given two integer arrays nums1 and nums2. You are tasked to implement a data structure that supports queries of two types:

// Add a positive integer to an element of a given index in the array nums2.
// Count the number of pairs (i, j) such that nums1[i] + nums2[j] equals a given value (0 <= i < nums1.length and 0 <= j < nums2.length).
// Implement the FindSumPairs class:

// FindSumPairs(int[] nums1, int[] nums2) Initializes the FindSumPairs object with two integer arrays nums1 and nums2.
// void add(int index, int val) Adds val to nums2[index], i.e., apply nums2[index] += val.
// int count(int tot) Returns the number of pairs (i, j) such that nums1[i] + nums2[j] == tot.
 

// Example 1:

// Input
// ["FindSumPairs", "count", "add", "count", "count", "add", "add", "count"]
// [[[1, 1, 2, 2, 2, 3], [1, 4, 5, 2, 5, 4]], [7], [3, 2], [8], [4], [0, 1], [1, 1], [7]]
// Output
// [null, 8, null, 2, 1, null, null, 11]



class FindSumPairs {
    int[] n1, n2;
    Map<Integer, Integer> m = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        n1 = nums1;
        n2 = nums2;
        for (int x : n2) m.put(x, m.getOrDefault(x, 0) + 1);
    }

    public void add(int i, int v) {
        m.put(n2[i], m.get(n2[i]) - 1);
        n2[i] += v;
        m.put(n2[i], m.getOrDefault(n2[i], 0) + 1);
    }

    public int count(int t) {
        int c = 0;
        for (int x : n1) c += m.getOrDefault(t - x, 0);
        return c;
    }
}
