Given a string s, your task is to find the longest palindromic substring within s.

A substring is a contiguous sequence of characters within a string, defined as s[i...j] where 0 ≤ i ≤ j < len(s).

A palindrome is a string that reads the same forward and backward. More formally, s is a palindrome if reverse(s) == s.

Note: If there are multiple palindromic substrings with the same length, return the first occurrence of the longest palindromic substring from left to right.

Examples :

Input: s = “forgeeksskeegfor” 
Output: “geeksskeeg”
Explanation: There are several possible palindromic substrings like “kssk”, “ss”, “eeksskee” etc. But the substring “geeksskeeg” is the longest among all.
Input: s = “Geeks” 
Output: “ee”
Explanation: "ee" is the longest palindromic substring of "Geeks". 
Input: s = “abc” 
Output: “a”
Explanation: "a", "b" and "c" are longest palindromic substrings of same length. So, the first occurrence is returned.
Constraints:
1 ≤ s.size() ≤ 103
s consist of only lowercase English letters.


class Solution {
    static int len(int l , int r , String s)
    {
        // now make the inital length = 0 
        int length = 0 ;
        // if the  left and the right are same
        while( l >= 0 && r <s.length())
        {
            // check  if the left and the right elem are same
            if(s.charAt(l) == s.charAt(r))
            {
                length +=2;
                l--;
                r++;
            }
            //else
            else
            {
                break;
            }
        }
        return length;
    }
    static String longestPalindrome(String s) {
        // code here
        // get the size of the length
        int n = s.length();
        int m_l = 1; //max length
        int start = 0 ; // staring point
        
        
        // odd plindromne
        for(int i = 0 ; i < n ; i++)
        {
            // for the odd length we will find the palindrome 
            int l = 1+ len(i-1 , i+1 ,s); // wew ill find the i-1 , i+1  and the length of the substring
            // update the maxlenght
           if(l>m_l)
           {
               m_l = l;
                // get the starting point
                start = (i - l/2);
           }
           
        } 
        //even palindrome
        for(int i = 1 ; i < n ; i++)
        {
            // for the odd length we will find the palindrome 
            int l = len(i-1 , i ,s); // we will find the i-1 , i+1  and the length of the substring
            // update the maxlenght
            
            
            if(l>m_l)
           {
               m_l = l;
                // get the starting point
                start = (i - l/2);
           }
        }
          // reurn the substring
    return s.substring(start , start + m_l);
    }
  
}
  
