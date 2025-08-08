You are given a string s. You have to find the length of the longest substring with all distinct characters. 

Examples:

Input: s = "geeksforgeeks"
Output: 7
Explanation: "eksforg" is the longest substring with all distinct characters.
Input: s = "aaa"
Output: 1
Explanation: "a" is the longest substring with all distinct characters.
Input: s = "abcdefabcbb"
Output: 6
Explanation: The longest substring with all distinct characters is "abcdef", which has a length of 6.
Constraints:
1 ≤ s.size() ≤ 3*104
All the characters are in lowercase.



  

// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int [] arr = new int [26];
        for (int y = 0 ; y <26 ;y++)
        {
            arr[y] = -1;
        }
        int maxLen = 0;
        int i = 0;
        for (int j = 0 ; j <s.length() ; j++)
        {
            // find the char index for each of the charecter
            char ch = s.charAt(j);
            int charI = ch  - 'a';
            // if that char index val in the arr not = -1
            if(arr[charI] != -1)
            {
                // now we have to update the i
                i = Math.max(i ,  arr[charI] + 1);
            }
            // for the else case we have to updat the value of j
            arr[charI] = j;
            // now update the maxLen
            maxLen = Math.max(maxLen ,  (j-i)+1);
            
        }
        return maxLen;
    }
}
