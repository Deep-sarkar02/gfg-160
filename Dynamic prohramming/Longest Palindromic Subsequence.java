Given a string s, return the length of the longest palindromic subsequence.
A subsequence is a sequence that can be derived from the given sequence by deleting some or no elements without changing the order of the remaining elements.
A palindromic sequence is a sequence that reads the same forward and backward.

Examples:

Input: s = "bbabcbcab"
Output: 7
Explanation: Subsequence "babcbab" is the longest subsequence which is also a palindrome.
Input: s = "abcd"
Output: 1
Explanation: "a", "b", "c" and "d" are palindromic and all have a length 1.
Input: s = "agbdba"
Output: 5
Explanation: The longest palindromic subsequence is "abdba", which has a length of 5. The characters in this subsequence are taken from the original string "agbdba", and they maintain the order of the string while forming a palindrome.
Constraints:
1 ≤ s.size() ≤ 1000
The string contains only lowercase letters.

// User function Template for Java

class Solution {
    public int helper(String s1 , String s2)
    {
        // dp matrix
        int[][] dp = new int[s1.length()][s2.length()];
        for(int i = 0 ; i<s1.length() ; i++)
        {
            // for each of the col
            for(int j = 0 ; j<s2.length() ; j++)
            {
                if(s1.charAt(i) == s2.charAt(j))
                {
                    if(i > 0  && j>0)
                    {
                        dp[i][j] = 1+dp[i-1][j-1];
                    }
                    else
                    {
                        dp[i][j] = 1;
                    }
                }
                else
                {
                    int top;
                    int left;
                    
                    
                    if( i > 0)
                    {
                        top = dp[i-1][j];
                    }
                    else
                    {
                        top = 0;
                    }
                    if(j > 0 )
                    {
                        left = dp[i][j-1];
                    }
                    else
                    {
                        left = 0 ;
                    }
                    dp[i][j] = Math.max(top , left);
                }
            }
        }
        return dp[s1.length()-1][s2.length()-1];
    }
    public int longestPalinSubseq(String s) {
        // code here
        // do the reverse of the string
        String rs = new StringBuilder(s).reverse().toString();
        // now pass the rs and the s to the helper function
        return helper(rs , s);
        
    }
}
