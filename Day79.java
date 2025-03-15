// 1385. Find the Distance Value Between Two Arrays
// Given two integer arrays arr1 and arr2, and the integer d, return the distance value between the two arrays.
// The distance value is defined as the number of elements arr1[i] such that there is not any element arr2[j] where |arr1[i]-arr2[j]| <= d.
// Example 1:
// Input: arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
// Output: 2

//   CODE

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
       int count = 0;

        for (int num1 : arr1) {
            boolean isValid = true;

            for (int num2 : arr2) {
                if (Math.abs(num1 - num2) <= d) {
                    isValid = false;
                    break; 
                }
            }

            if (isValid) count++; 
        }

        return count;
    }
}
