// 66. Plus One
// You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. 
// The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

// Example 1:
// Input: digits = [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.
// Incrementing by one gives 123 + 1 = 124.
// Thus, the result should be [1,2,4].

// CODE

class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        
        for(int i=n-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
       int[] newNumber = new int [n+1];
        newNumber[0] = 1;
    
      return newNumber;
    }
}

// end

// 27. Remove Element
// Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. 
// Then return the number of elements in nums which are not equal to val.

// Example 1:
// Input: nums = [3,2,2,3], val = 3
// Output: 2, nums = [2,2,_,_]
// Explanation: Your function should return k = 2, with the first two elements of nums being 2.
// It does not matter what you leave beyond the returned k (hence they are underscores)

// CODE

class Solution {
    public int removeElement(int[] nums, int val) {
        int idx = 0; 
        
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=val){
               nums[idx]=nums[i];
               idx++;
            }
        }
        return idx;
    }
}
