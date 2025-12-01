Given two strings s1 and s2, return the length of their longest common subsequence (LCS). If there is no common subsequence, return 0.

A subsequence is a sequence that can be derived from the given string by deleting some or no elements without changing the order of the remaining elements. For example, "ABE" is a subsequence of "ABCDE".

Examples:

Input: s1 = "ABCDGH", s2 = "AEDFHR"
Output: 3
Explanation: The longest common subsequence of "ABCDGH" and "AEDFHR" is "ADH", which has a length of 3.
Input: s1 = "ABC", s2 = "AC"
Output: 2
Explanation: The longest common subsequence of "ABC" and "AC" is "AC", which has a length of 2.
Input: s1 = "XYZW", s2 = "XYWZ"
Output: 3
Explanation: The longest common subsequences of "XYZW" and "XYWZ" are "XYZ" and "XYW", both of length 3.
Constraints:
1<= s1.size(), s2.size() <=103
Both strings s1 and s2 contain only uppercase English letters.


class Solution {
    static int lcs(String s1, String s2) {
        // code here
        //System.out.println(s1.length());
        
        
        //construct a dp matrix 
        // col and row
        int[][] dp = new int[s1.length()][s2.length()];
        // now loop over the matrix
        // for each of the row
        for(int i = 0 ; i< s1.length() ; i++)
        {
            // for each of the col
            for(int j = 0 ; j<s2.length() ; j++)
            {
                // if the last char if they are equal 
                if(s1.charAt(i) == s2.charAt(j))
                {
                    // for the row after 0 th row
                    if(i > 0 && j >0)
                    {
                         // then we will add the prev value
                        dp[i][j] = 1+dp[i-1][j-1];
                    }
                    
                    // else case for the 1st row the 0 th one
                    else
                    {
                        dp[i][j] = 1;
                    }
                   
                }
                
                //now if the char doesnot match
                // make the max 
                else
                {
                    // get the top and the left value
                    int top;
                    int left ;
                    
                    // if the row > 0 then get the top value
                    if(i >0)
                    {
                        top = dp[i-1][j];
                    }
                    else
                    {
                        top = 0;
                    }
                    // same for the left
                    // if the j > 0 then get the top value
                    if(j >0)
                    {
                        left = dp[i][j-1];
                    }
                    else
                    {
                        left = 0;
                    }
                    
                    
                    // fill with the max
                    dp[i][j] = Math.max(top , left);
                }
            }
           
        }
         return dp[s1.length()-1][s2.length()-1];
        
        
    }
}  
