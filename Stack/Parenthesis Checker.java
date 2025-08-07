Given a string s, composed of different combinations of '(' , ')', '{', '}', '[', ']', verify the validity of the arrangement.
An input string is valid if:

         1. Open brackets must be closed by the same type of brackets.
         2. Open brackets must be closed in the correct order.

Examples :

Input: s = "[{()}]"
Output: true
Explanation: All the brackets are well-formed.
Input: s = "[()()]{}"
Output: true
Explanation: All the brackets are well-formed.
Input: s = "([]"
Output: false
Explanation: The expression is not balanced as there is a missing ')' at the end.
Input: s = "([{]})"
Output: false
Explanation: The expression is not balanced as there is a closing ']' before the closing '}'.
Constraints:
1 ≤ s.size() ≤ 106
s[i] ∈ {'{', '}', '(', ')', '[', ']'}


class Solution {
    static boolean isBalanced(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        // now we will loop over to the string and push the opern bracket tor the stack
        for (int i = 0 ; i <s.length() ; i++)
        {
            if(s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(')
            {
                // push that char to stack
                st.push(s.charAt(i));
            }
            else
            {
                // for the closing bracket
                // if  the st.is empty
                if(st.isEmpty())
                {
                    return false;
                }
                // for tthe oterh caase
                // peek the top
                char t = st.peek();
                if((t == '(' && s.charAt(i) != ')') ||
                (t == '{' && s.charAt(i) != '}') ||
                (t == '[' && s.charAt(i) != ']'))
                {
                    return false;
                }
                // for the else case
                // pop 
                st.pop();
                
            }
        }
        return st.isEmpty();
    }
}
