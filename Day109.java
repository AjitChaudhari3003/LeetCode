// 3438. Find Valid Pair of Adjacent Digits in String
// You are given a string s consisting only of digits. A valid pair is defined as two adjacent digits in s such that:
// The first digit is not equal to the second.
// Each digit in the pair appears in s exactly as many times as its numeric value.
// Return the first valid pair found in the string s when traversing from left to right. If no valid pair exists, return an empty string.
// Example 1:
// Input: s = "2523533"
// Output: "23"

//   CODE

class Solution {
    public String findValidPair(String s) {
       HashMap<Integer,Integer> map=new HashMap<>();
       StringBuilder ss=new StringBuilder();

       for(int i=0; i<s.length(); i++){
        int x=s.charAt(i)-'0';
        map.put(x,map.getOrDefault(x,0)+1);
       }

       for(int i=1; i<s.length(); i++){
            int fst=s.charAt(i-1)-'0';
            int scnd=s.charAt(i)-'0';

            if(fst != scnd && map.get(fst)==fst && map.get(scnd)==scnd){
                ss.append(fst);
                ss.append(scnd);
                break; 
            } 
       }
       return ss.toString();
    }
}
