// 2224. Minimum Number of Operations to Convert Time
// You are given two strings current and correct representing two 24-hour times.
// 24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM is between 00 and 59. The earliest 24-hour time is 00:00, and the latest is 23:59.
// In one operation you can increase the time current by 1, 5, 15, or 60 minutes. You can perform this operation any number of times.
// Return the minimum number of operations needed to convert current to correct.
// Example 1:
// Input: current = "02:30", correct = "04:35"
// Output: 3

//   CODE

  class Solution {
    public int convertTime(String current, String correct) {
        String[] curr = current.split(":");
        String[] corr = correct.split(":");
        int cur = Integer.parseInt(curr[0]) * 60 + Integer.parseInt(curr[1]);
        int cor = Integer.parseInt(corr[0]) * 60 + Integer.parseInt(corr[1]);
        int count = 0;
        
        while(cur + 60 <= cor) {
            ++count;
            cur += 60;
        }
        
         while(cur + 15 <= cor) {
            ++count;
            cur += 15;
        }
        
         while(cur + 5 <= cor) {
            ++count;
            cur += 5;
        }
        
         while(cur + 1 <= cor) {
            ++count;
            cur += 1;
        }
        
        return count;
        
    }
}
