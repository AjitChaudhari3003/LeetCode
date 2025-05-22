// 3362. Zero Array Transformation III
// Medium
// Topics
// Companies
// Hint
// You are given an integer array nums of length n and a 2D array queries where queries[i] = [li, ri].

// Each queries[i] represents the following action on nums:

// Decrement the value at each index in the range [li, ri] in nums by at most 1.
// The amount by which the value is decremented can be chosen independently for each index.
// A Zero Array is an array with all its elements equal to 0.

// Return the maximum number of elements that can be removed from queries, such that nums can still be converted to a zero array using the remaining queries. If it is not possible to convert nums to a zero array, return -1.

 

// Example 1:

// Input: nums = [2,0,2], queries = [[0,2],[0,2],[1,1]]

// Output: 1


class Solution {
    public static int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length, q = queries.length;
        List<List<Integer>> qEnd = new ArrayList<>();
        for (int i = 0; i < n; i++) qEnd.add(new ArrayList<>());
        for (int[] query : queries) {
            qEnd.get(query[0]).add(query[1]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] cntQ = new int[n + 1];
        int dec = 0;

        for (int i = 0; i < n; i++) {
            dec += cntQ[i];
            for (int end : qEnd.get(i)) {
                pq.offer(end);
            }

            int x = nums[i];
            while (x > dec && !pq.isEmpty() && pq.peek() >= i) {
                int k = pq.poll();
                cntQ[k + 1]--;
                dec++;
            }

            if (x > dec) return -1;
        }

        return pq.size();
    }
}
