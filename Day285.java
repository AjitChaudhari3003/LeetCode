// 1488. Avoid Flood in The City
// Your country has an infinite number of lakes. Initially, all the lakes are empty, but when it rains over the nth lake, the nth lake becomes full of water. If it rains over a lake that is full of water, there will be a flood. Your goal is to avoid floods in any lake.
// Given an integer array rains where:
// rains[i] > 0 means there will be rains over the rains[i] lake.
// rains[i] == 0 means there are no rains this day and you can choose one lake this day and dry it.
// Return an array ans where:
// ans.length == rains.length
// ans[i] == -1 if rains[i] > 0.
// ans[i] is the lake you choose to dry in the ith day if rains[i] == 0.
// If there are multiple valid answers return any of them. If it is impossible to avoid flood return an empty array.
// Notice that if you chose to dry a full lake, it becomes empty, but if you chose to dry an empty lake, nothing changes.
// Example 1:
// Input: rains = [1,2,3,4]
// Output: [-1,-1,-1,-1]
// Explanation: After the first day full lakes are [1]
// After the second day full lakes are [1,2]
// After the third day full lakes are [1,2,3]
// After the fourth day full lakes are [1,2,3,4]
// There's no day to dry any lake and there is no flood in any lake


class Solution {
    public int[] avoidFlood(int[] rains) {
        int n= rains.length;
        int[] ans= new int[n];
        Map<Integer, Integer> last_rain= new HashMap<>();
        int def= 5;
        TreeSet<Integer> dry_days= new TreeSet<>();
        for(int i=0; i<n; i++){
            int lake= rains[i];
            if(lake==0){
                dry_days.add(i);
                ans[i]= def;
            }else{
                ans[i]= -1;
                if(last_rain.containsKey(lake)){
                    Integer day= dry_days.higher(last_rain.get(lake));
                    //next dry day of last_rain.get(lake)
                    //[2 , 3, 4, 5, 9, 10]
                    //6
                    if(day==null) return new int[0];
                    ans[day]= lake;
                    dry_days.remove(day);
                }
                last_rain.put(lake, i);
            }
        }
        return ans;
    }
}
