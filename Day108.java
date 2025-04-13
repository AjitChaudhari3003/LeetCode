// 3499. Maximize Active Section with Trade I
// You are given a binary string s of length n, where:
// '1' represents an active section.
// '0' represents an inactive section.
// You can perform at most one trade to maximize the number of active sections in s. In a trade, you:
// Convert a contiguous block of '1's that is surrounded by '0's to all '0's.
// Afterward, convert a contiguous block of '0's that is surrounded by '1's to all '1's.
// Return the maximum number of active sections in s after making the optimal trade.
// Note: Treat s as if it is augmented with a '1' at both ends, forming t = '1' + s + '1'. The augmented '1's do not contribute to the final count.
// Example 1:
// Input: s = "01"
// Output: 1

class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        char arr[] = s.toCharArray();
        int n=arr.length;
        int left=0;
        int right=0;
        int middle=0;
        int asum=0;
        int sum=0;
        int i=0;
        for(char c:arr){
            if(c=='1'){
                asum++;
            }
        }
        while(i<n){
            left=0;
            while(i<n && arr[i]=='1'){
                i++;
            }
            while(i<n && arr[i]=='0'){
                left++;
                i++;
            }
            middle=0;
            while(i<n && arr[i]=='1'){
                middle++;
                i++;
            }
            right=0;
            while(i<n && arr[i]=='0'){
                right++;
                i++;
            }
            if(i>=n && left==0 ){
                return Math.max(sum,asum);
            }
            if(i>=n && right==0 ){
                return Math.max(sum,asum);
            }
            sum=Math.max(sum,asum+left+right);
            i=i-right;
            
        }
        
        return sum;
    }
}
