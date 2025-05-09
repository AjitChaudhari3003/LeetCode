// 3162. Find the Number of Good Pairs I
// You are given 2 integer arrays nums1 and nums2 of lengths n and m respectively. You are also given a positive integer k.
// A pair (i, j) is called good if nums1[i] is divisible by nums2[j] * k (0 <= i <= n - 1, 0 <= j <= m - 1).
// Return the total number of good pairs.
// Example 1:
// Input: nums1 = [1,3,4], nums2 = [1,3,4], k = 1
// Output: 5
// Explanation:The 5 good pairs are (0, 0), (1, 0), (1, 1), (2, 0), and (2, 2).

//   CODE

class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
      int count=0;
      for(int i=0;i<nums1.length;i++){
        for(int j=0;j<nums2.length;j++){
            if(nums1[i]%(nums2[j]*k)==0){
                count++;
            }
        }
      }  
      return count;
    }
}
