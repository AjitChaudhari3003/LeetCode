// 1089. Duplicate Zeros
// Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
// Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.
// Example 1:
// Input: arr = [1,0,2,3,0,4,5,0]
// Output: [1,0,0,2,3,0,0,4]
// Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]

// CODE


class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int temp[]=new int[n];
        int j=0;
        
        for(int i=0;i<n && j<n;i++){
            temp[j++]=arr[i];
            if(arr[i]==0 && j<n){
                temp[j++]=0;
                
            }
        }
        for(int i=0;i<n;i++)
         arr[i]=temp[i];
    }
}
