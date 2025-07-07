// 1353. Maximum Number of Events That Can Be Attended
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

// You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one event at any time d.

// Return the maximum number of events you can attend.

 

// Example 1:


// Input: events = [[1,2],[2,3],[3,4]]
// Output: 3
// Explanation: You can attend all the three events.
// One way to attend them all is as shown.
// Attend the first event on day 1.
// Attend the second event on day 2.
// Attend the third event on day 3.



class Solution {
    int search(int[] nextDay, int day) {
        if (nextDay[day] != day) {
            nextDay[day] = search(nextDay, nextDay[day]);
        }
        return nextDay[day];
    }

    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);

        int[] nextDay = new int[events[events.length - 1][1] + 2];
        for (int d = 0; d < nextDay.length; d++) {
            nextDay[d] = d;
        }

        int count = 0;
        for (int[] evt : events) {
            int start = evt[0];
            int end = evt[1];
            int day = search(nextDay, start);
            if (day <= end) {
                count++;
                nextDay[day] = search(nextDay, day + 1);
            }
        }

        return count;
    }

}
