Given an encoded string s, the task is to decode it. The encoding rule is :

k[encodedString], where the encodedString inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer, and encodedString contains only lowercase english alphabets.
Note: The test cases are generated so that the length of the output string will never exceed 105 .

Examples:

Input: s = "1[b]"
Output: "b"
Explanation: "b" is present only one time.
Input: s = "3[b2[ca]]"
Output: "bcacabcacabcaca"
Explanation:
1. Inner substring “2[ca]” breakdown into “caca”.
2. Now, new string becomes “3[bcaca]”
3. Similarly “3[bcaca]” becomes “bcacabcacabcaca ” which is final result.
Constraints:
1 ≤ |s| ≤ 105 
1 <= k <= 100



class Solution {
    static String decodeString(String s) {
        // code here
        //  number stack and the String stack
        //Stack<Integer> stn = new Stack<>();
        // STRING STACK
        Stack<Character> st = new Stack<>();
        
        // loop throught the string
        for(int i = 0 ; i<s.length() ; i++)
        {
           // when closing brack is not coming push
           if(s.charAt(i) != ']') st.push(s.charAt(i));
           
           else
           {
               // form the string
               StringBuilder word = new StringBuilder();
               while(!st.isEmpty() && st.peek()!= '[')
               {
                   // form the string in the reversed order
                   word.insert(0 , st.pop());
                   
               }
               
               // pop the open bracket
               st.pop();
               
               // also get the number
               StringBuilder k = new StringBuilder();
               while(!st.isEmpty() && Character.isDigit(st.peek()))
               {
                   k.insert(0 , st.pop()); // in the reversed order
                 
               }
               
               // convert from string to int
               // and from stringbuilder to string
               int num = Integer.parseInt(k.toString());
               
               
               
               
               // now repeat the string
               String repeated = word.toString().repeat(num);
               
               // covert string to char array
               for (char c :repeated.toCharArray() )
               {
                   //push the char to stack
                   st.push(c);
               }
               
           }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty())
        {
            ans.insert( 0 , st.pop());
            //st.peek();
        }
        
        return ans.toString();
    }
}
