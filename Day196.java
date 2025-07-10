// 3440. Reschedule Meetings for Maximum Free Time II
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given an integer eventTime denoting the duration of an event. You are also given two integer arrays startTime and endTime, each of length n.

// These represent the start and end times of n non-overlapping meetings that occur during the event between time t = 0 and time t = eventTime, where the ith meeting occurs during the time [startTime[i], endTime[i]].

// You can reschedule at most one meeting by moving its start time while maintaining the same duration, such that the meetings remain non-overlapping, to maximize the longest continuous period of free time during the event.

// Return the maximum amount of free time possible after rearranging the meetings.

// Note that the meetings can not be rescheduled to a time outside the event and they should remain non-overlapping.

// Note: In this version, it is valid for the relative ordering of the meetings to change after rescheduling one meeting.

 

// Example 1:

// Input: eventTime = 5, startTime = [1,3], endTime = [2,5]

// Output: 2

// Explanation:



// Reschedule the meeting at [1, 2] to [2, 3], leaving no meetings during the time [0, 2].




class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int[] gap = new int[startTime.length + 1];
        gap[0] = startTime[0];
        for (int i = 1; i < startTime.length; i++) {
            gap[i] = startTime[i] - endTime[i - 1];
        }
        gap[startTime.length] = eventTime - endTime[endTime.length - 1];

        int[] largestRight = new int[gap.length];
        for (int i = gap.length - 2; i >= 0; i--) {
            largestRight[i] = Math.max(largestRight[i + 1], gap[i + 1]);
        }

        int ans = 0, largestLeft = 0;
        for (int i = 1; i < gap.length; i++) {
            int curGap = endTime[i - 1] - startTime[i - 1];
            if (curGap <= Math.max(largestLeft, largestRight[i])) {
                ans = Math.max(ans, gap[i - 1] + gap[i] + curGap);
            }
            ans = Math.max(ans, gap[i - 1] + gap[i]);
            largestLeft = Math.max(largestLeft, gap[i - 1]);
        }
        return ans;
    }
}
