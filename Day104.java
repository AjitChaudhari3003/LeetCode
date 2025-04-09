// 844. Backspace String Compare
// Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
// Note that after backspacing an empty text, the text will continue empty.
// Example 1:
// Input: s = "ab#c", t = "ad#c"
// Output: true
// Explanation: Both s and t become "ac".

//   CODE

class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        int skipS = 0;
        int skipT = 0;

        while(i >=0 || j>=0){
           while(i>=0){
            if(s.charAt(i)=='#'){
                skipS++;i--;
            }else if(skipS >0){
                skipS--;i--;
            }else {
                break;
            }
           }

            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

           if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }
             if ((i >= 0) != (j >= 0)) {
                return false;
            }
            i--; j--;
        }

        return true;
        }
   }
