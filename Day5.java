// Sort Colors
// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
// Example 1:
// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]
// Example 2:
// Input: nums = [2,0,1]
// Output: [0,1,2]

// CODE

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
       int low=0, current=0, high=n-1;
       while(current<= high){
        if(nums[current]==0){
            int temp=nums[low];
            nums[low]= nums[current];
            nums[current]= temp;
            low++;
            current++;
        }else if(nums[current]==2){
            int temp =  nums[high];
            nums[high]= nums[current];
            nums[current]= temp;
            high--;
          
        }else{
            current++;
        }
       }
    }
}






