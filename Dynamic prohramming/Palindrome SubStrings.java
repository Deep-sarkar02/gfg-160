Given a string s, count all palindromic sub-strings present in the string. The length of the palindromic sub-string must be greater than or equal to 2.

Note: A substring is palindromic if it reads the same forwards and backwards.

Examples:

Input: s = "abaab"
Output: 3
Explanation: All palindromic substrings (of length > 1) are: "aba", "aa", "baab".
Input: s = "aaa"
Output: 3
Explanation: All palindromic substrings (of length > 1) are: "aa", "aa", "aaa".
Input: s = "abbaeae"
Output: 4
Explanation: All palindromic substrings (of length > 1) are: "bb", "abba", "aea", "eae".
Constraints:
2 ≤ s.size() ≤ 5 * 103
s contains only lowercase english characters

class Solution {
    public int pal(String s , int l , int r)
    {
        int count = 0 ;
        
        // get the count
        while(l >= 0 && r <s.length() && s.charAt(l) == s.charAt(r) )
        {
            // if the len > 2
            if(r - l +1 >= 2)
            {
                count++;
            }
            
            l--;
            r++;
        }
        return count;
    }
    
    
    public int countPS(String s) {
        // code here
        int count = 0 ; 
        for(int i = 0 ; i < s.length() ; i++)
        {
            //get the odd 
        count += pal(s , i , i);
        
        // even
        count += pal(s , i , i+1);
        }
        
        return count;
        
    }
}
