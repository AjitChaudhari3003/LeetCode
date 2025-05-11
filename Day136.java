// 1550. Three Consecutive Odds
// Easy
// Topics
// Companies
// Hint
// Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.
 

// Example 1:

// Input: arr = [2,6,4,1]
// Output: false
// Explanation: There are no three consecutive odds

class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length <3) return false;
        for(int i=0;i<=arr.length-3 ;i++){
            if(arr[i]%2==1 && arr[i+1]%2==1 && arr[i+2]%2==1){
                return true;
            }
        }
        return false;
    }
}
