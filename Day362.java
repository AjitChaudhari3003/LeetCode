// 2054. Two Best Non-Overlapping Events
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// You are given a 0-indexed 2D integer array of events where events[i] = [startTimei, endTimei, valuei]. The ith event starts at startTimei and ends at endTimei, and if you attend this event, you will receive a value of valuei. You can choose at most two non-overlapping events to attend such that the sum of their values is maximized.

// Return this maximum sum.

// Note that the start time and end time is inclusive: that is, you cannot attend two events where one of them starts and the other ends at the same time. More specifically, if you attend an event with end time t, the next event must start at or after t + 1.

 

// Example 1:


// Input: events = [[1,3,2],[4,5,2],[2,4,3]]
// Output: 4
// Explanation: Choose the green events, 0 and 1 for a sum of 2 + 2 = 4.



class Solution {
    public int maxTwoEvents(int[][] events) {
        int n=events.length;
        Arrays.sort(events,(a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        int ans=events[0][2];
        for(int x[]:events) ans=Math.max(ans,x[2]);
        int dp[]=new int[n];
        dp[n-1]=events[n-1][2];
        for(int i=n-2;i>=0;i--){
            dp[i]=Math.max(dp[i+1], events[i][2]);
        }
        for(int i=0;i<n;i++){
            int end=events[i][1];
            int l=i+1,r=n-1, pos=-1;
            while(l<=r){
                int mid=l+(r-l)/2;
                if(events[mid][0]>end){
                    pos=mid;
                    r=mid-1;
                }
                else l=mid+1;
            }
            if(pos!=-1) ans=Math.max(ans,events[i][2]+dp[pos]);
        }
        return ans;
    }
}
