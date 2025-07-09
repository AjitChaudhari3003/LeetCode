// 3439. Reschedule Meetings for Maximum Free Time I
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given an integer eventTime denoting the duration of an event, where the event occurs from time t = 0 to time t = eventTime.

// You are also given two integer arrays startTime and endTime, each of length n. These represent the start and end time of n non-overlapping meetings, where the ith meeting occurs during the time [startTime[i], endTime[i]].

// You can reschedule at most k meetings by moving their start time while maintaining the same duration, to maximize the longest continuous period of free time during the event.

// The relative order of all the meetings should stay the same and they should remain non-overlapping.

// Return the maximum amount of free time possible after rearranging the meetings.

// Note that the meetings can not be rescheduled to a time outside the event.

 

// Example 1:

// Input: eventTime = 5, k = 1, startTime = [1,3], endTime = [2,5]

// Output: 2

// Explanation:



// Reschedule the meeting at [1, 2] to [2, 3], leaving no meetings during the time [0, 2].



class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;

        List<Integer> gaps = new ArrayList<>();

        // calculating gaps
        gaps.add(startTime[0]);
        for (int i = 1; i < n; i++) {
            gaps.add(startTime[i] - endTime[i - 1]);
        }
        gaps.add(eventTime - endTime[n - 1]);

        int currentSum = 0, res = 0;

        // use sliding window on gaps array to find maximum possible gap
        // for K meetings there K+1 gaps, thus window size = K+1

        for (int i = 0; i < gaps.size(); ++i) {

            // form window of size k+1
            // if i >= k+1, add new element and remove i-(k+1) element
            currentSum += gaps.get(i) - ((i >= k + 1) ? gaps.get(i - (k + 1)) : 0);
            res = Math.max(res, currentSum);
        }

        return res;

    }
}
