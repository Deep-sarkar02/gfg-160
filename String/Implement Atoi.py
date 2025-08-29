Implement Atoi
Difficulty: MediumAccuracy: 32.58%Submissions: 286K+Points: 4Average Time: 15m
Given a string s, the objective is to convert it into integer format without utilizing any built-in functions. Refer the below steps to know about atoi() function.

Cases for atoi() conversion:

Skip any leading whitespaces.
Check for a sign (‘+’ or ‘-‘), default to positive if no sign is present.
Read the integer by ignoring leading zeros until a non-digit character is encountered or end of the string is reached. If no digits are present, return 0.
If the integer is greater than 231 – 1, then return 231 – 1 and if the integer is smaller than -231, then return -231.
Examples:

Input: s = "-123"
Output: -123
Explanation: It is possible to convert -123 into an integer so we returned in the form of an integer
Input: s = "  -"
Output: 0
Explanation: No digits are present, therefore the returned answer is 0.
Input: s = " 1231231231311133"
Output: 2147483647
Explanation: The converted number will be greater than 231 – 1, therefore print 231 – 1 = 2147483647.
Input: s = "-999999999999"
Output: -2147483648
Explanation: The converted number is smaller than -231, therefore print -231 = -2147483648.
Input: s = "  -0012gfg4"
Output: -12
Explanation: After ignoring leading zeros nothing is read after -12 as a non-digit character ‘g’ was encountered.
Constraints:
1 ≤ |s| ≤ 15


#User function template for Python
class Solution:
    def myAtoi(self, s):
        # Code here
        INT_MAX = 2**31-1
        INT_MIN = -2**31
        ans = 0
        # sign 
        sign  = 1 # by default posetive
        #iteration through while loop
        i = 0
        # loop over the list and skip the spaces
        while(i<len(s)  and s[i] == " "):
            # skip the spaces
            i+=1
        # loop over the list and checks for + and -
        while(i<len(s)):
            # if pos:
            if(s[i] == "+"):
                sign = 1
                i+=1
            elif(s[i] == "-"):
                sign = -1
                i+=1
            else:
                break
        # now checks for the integer numbers only 
        while(i<len(s) and s[i]>="0" and s[i]<= "9"):
            # find the answer
            ans = 10*ans+int(s[i])*sign
            i+=1
        # check s the number is > 2**31-1 
        if(ans > INT_MAX):
            return INT_MAX
        elif(ans <INT_MIN ):
            return INT_MIN
        else:
            return (ans)
            
        
                
               
        
