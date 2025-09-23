// 165. Compare Version Numbers
// Given two version strings, version1 and version2, compare them. A version string consists of revisions separated by dots '.'. The value of the revision is its integer conversion ignoring leading zeros.
// To compare version strings, compare their revision values in left-to-right order. If one of the version strings has fewer revisions, treat the missing revision values as 0.
// Return the following:
// If version1 < version2, return -1.
// If version1 > version2, return 1.
// Otherwise, return 0.
// Example 1:
// Input: version1 = "1.2", version2 = "1.10"
// Output: -1
// Explanation:
// version1's second revision is "2" and version2's second revision is "10": 2 < 10, so version1 < version2.


class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < v1.length || i < v2.length; i++) {
            int num1 = 0;
            int num2 = 0;
            if(i < v1.length) {
                num1 = Integer.parseInt(v1[i]);
            }
            if(i < v2.length) {
                num2 = Integer.parseInt(v2[i]);
            }
            if(num1 > num2) {
                return 1;
            }
            if(num1 < num2) {
                return -1;
            }
        }
        return 0;
            
    }
}
