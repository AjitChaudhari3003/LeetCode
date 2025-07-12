// 1900. The Earliest and Latest Rounds Where Players Compete
// Hard
// Topics
// premium lock icon
// Companies
// Hint
// There is a tournament where n players are participating. The players are standing in a single row and are numbered from 1 to n based on their initial standing position (player 1 is the first player in the row, player 2 is the second player in the row, etc.).

// The tournament consists of multiple rounds (starting from round number 1). In each round, the ith player from the front of the row competes against the ith player from the end of the row, and the winner advances to the next round. When the number of players is odd for the current round, the player in the middle automatically advances to the next round.

// For example, if the row consists of players 1, 2, 4, 6, 7
// Player 1 competes against player 7.
// Player 2 competes against player 6.
// Player 4 automatically advances to the next round.
// After each round is over, the winners are lined back up in the row based on the original ordering assigned to them initially (ascending order).

// The players numbered firstPlayer and secondPlayer are the best in the tournament. They can win against any other player before they compete against each other. If any two other players compete against each other, either of them might win, and thus you may choose the outcome of this round.

// Given the integers n, firstPlayer, and secondPlayer, return an integer array containing two values, the earliest possible round number and the latest possible round number in which these two players will compete against each other, respectively.

 

// Example 1:

// Input: n = 11, firstPlayer = 2, secondPlayer = 4
// Output: [3,4]
// Explanation:
// One possible scenario which leads to the earliest round number:
// First round: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
// Second round: 2, 3, 4, 5, 6, 11
// Third round: 2, 3, 4
// One possible scenario which leads to the latest round number:
// First round: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
// Second round: 1, 2, 3, 4, 5, 6
// Third round: 1, 2, 4
// Fourth round: 2, 4




class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int left = Math.min(firstPlayer, secondPlayer);
        int right = Math.max(firstPlayer, secondPlayer);

        if (left + right == n + 1) {
            return new int[] { 1, 1 };
        }

        if (n == 3 || n == 4) {
            return new int[] { 2, 2 };
        }

        if (left - 1 > n - right) {
            int temp = n + 1 - left;
            left = n + 1 - right;
            right = temp;
        }

        int nextRound = (n + 1) / 2;
        int minRound = n;
        int maxRound = 1;

        if (right * 2 <= n + 1) {
            int preLeft = left - 1;
            int midGap = right - left - 1;
            for (int i = 0; i <= preLeft; i++) {
                for (int j = 0; j <= midGap; j++) {
                    int[] res = earliestAndLatest(nextRound, i + 1, i + j + 2);
                    minRound = Math.min(minRound, 1 + res[0]);
                    maxRound = Math.max(maxRound, 1 + res[1]);
                }
            }
        } else {
            int mirrored = n + 1 - right;
            int preLeft = left - 1;
            int midGap = mirrored - left - 1;
            int innerGap = right - mirrored - 1;
            for (int i = 0; i <= preLeft; i++) {
                for (int j = 0; j <= midGap; j++) {
                    int[] res = earliestAndLatest(nextRound, i + 1, i + j + 1 + (innerGap + 1) / 2 + 1);
                    minRound = Math.min(minRound, 1 + res[0]);
                    maxRound = Math.max(maxRound, 1 + res[1]);
                }
            }
        }
        return new int[] { minRound, maxRound };
    }
}
