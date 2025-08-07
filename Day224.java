// 3363. Find the Maximum Number of Fruits Collected
// Solved
// Hard
// Topics
// premium lock icon
// Companies
// Hint
// There is a game dungeon comprised of n x n rooms arranged in a grid.

// You are given a 2D array fruits of size n x n, where fruits[i][j] represents the number of fruits in the room (i, j). Three children will play in the game dungeon, with initial positions at the corner rooms (0, 0), (0, n - 1), and (n - 1, 0).

// The children will make exactly n - 1 moves according to the following rules to reach the room (n - 1, n - 1):

// The child starting from (0, 0) must move from their current room (i, j) to one of the rooms (i + 1, j + 1), (i + 1, j), and (i, j + 1) if the target room exists.
// The child starting from (0, n - 1) must move from their current room (i, j) to one of the rooms (i + 1, j - 1), (i + 1, j), and (i + 1, j + 1) if the target room exists.
// The child starting from (n - 1, 0) must move from their current room (i, j) to one of the rooms (i - 1, j + 1), (i, j + 1), and (i + 1, j + 1) if the target room exists.
// When a child enters a room, they will collect all the fruits there. If two or more children enter the same room, only one child will collect the fruits, and the room will be emptied after they leave.

// Return the maximum number of fruits the children can collect from the dungeon.

 

// Example 1:

// Input: fruits = [[1,2,3,4],[5,6,8,7],[9,10,11,12],[13,14,15,16]]

// Output: 100

// Explanation:



// In this example:

// The 1st child (green) moves on the path (0,0) -> (1,1) -> (2,2) -> (3, 3).
// The 2nd child (red) moves on the path (0,3) -> (1,2) -> (2,3) -> (3, 3).
// The 3rd child (blue) moves on the path (3,0) -> (3,1) -> (3,2) -> (3, 3).
// In total they collect 1 + 6 + 11 + 16 + 4 + 8 + 12 + 13 + 14 + 15 = 100 fruits.



class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int total = 0;

        // Collect main diagonal fruits (top-left to bottom-right)
        for (int i = 0; i < n; i++) {
            total += fruits[i][i];
        }

        int[] rightPath = new int[3];
        rightPath[0] = fruits[0][n - 1];

        int[] bottomPath = new int[3];
        bottomPath[0] = fruits[n - 1][0];

        int window = 2;

        for (int step = 1; step < n - 1; step++) {
            int[] newRight = new int[window + 2];
            int[] newBottom = new int[window + 2];

            for (int dist = 0; dist < window; dist++) {
                // Bounds check for array access
                int left = (dist - 1 >= 0) ? rightPath[dist - 1] : 0;
                int mid = rightPath[dist];
                int right = (dist + 1 < rightPath.length) ? rightPath[dist + 1] : 0;
                newRight[dist] = Math.max(left, Math.max(mid, right)) + fruits[step][n - 1 - dist];

                left = (dist - 1 >= 0) ? bottomPath[dist - 1] : 0;
                mid = bottomPath[dist];
                right = (dist + 1 < bottomPath.length) ? bottomPath[dist + 1] : 0;
                newBottom[dist] = Math.max(left, Math.max(mid, right)) + fruits[n - 1 - dist][step];
            }

            rightPath = newRight;
            bottomPath = newBottom;

            if (window - n + 4 + step <= 1) {
                window += 1;
            } else if (window - n + 3 + step > 1) {
                window -= 1;
            }
        }

        return total + rightPath[0] + bottomPath[0];
    }
}
