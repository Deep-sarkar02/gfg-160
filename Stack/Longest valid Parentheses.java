Given a string s consisting of opening and closing parenthesis '(' and ')'. Find the length of the longest valid parenthesis substring.

A parenthesis string is valid if:

For every opening parenthesis, there is a closing parenthesis.
The closing parenthesis must be after its opening parenthesis.
Examples :

Input: s = "((()"
Output: 2
Explanation: The longest valid parenthesis substring is "()".
Input: s = ")()())"
Output: 4
Explanation: The longest valid parenthesis substring is "()()".
Input: s = "())()"
Output: 2
Explanation: The longest valid parenthesis substring is "()".
Constraints:
1 ≤ s.size() ≤ 106  
s consists of '(' and ')' only

class Solution {
    static int maxLength(String s) {
        // code here
        Stack<Integer> st = new Stack<>();
        // if the stack is push -1
        st.push(-1);
        // now we will travese by the string
        int maxLen = 0 ;
        for(int i = 0 ; i< s.length() ; i++)
        {
            // if it is the opeing bracket
            if(s.charAt(i) == '(')
            {
                // push the index to the stack
                st.push(i);
            }
            else
            {
                st.pop();
                // but after the pop is the stack will be empty
                
                // push the index
                if(st.isEmpty())
                {
                    st.push(i);
                }
                else
                {
                    // find the max length
                    maxLen = Math.max(maxLen , i - st.peek());
                }
                
            }
            
        }
        // now return the i value 
        return maxLen;
    }
}
