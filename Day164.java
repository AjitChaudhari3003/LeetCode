// 386. Lexicographical Numbers
// Medium
// Topics
// premium lock icon
// Companies
// Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

// You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

 

// Example 1:

// Input: n = 13
// Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
// Example 2:

// Input: n = 2
// Output: [1,2]




class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int count=1;

        for(int i=0;i<n;i++){
            result.add(count);
            if(count*10 <=n){
                count *=10;
            }else{
                if(count >=n) count /=10;
                count++;
                while(count %10 ==0)
                  count /=10;
            }
        }
        return result;
    }
}
