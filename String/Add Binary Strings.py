Given two binary strings s1 and s2 consisting of only 0s and 1s. Find the resultant string after adding the two Binary Strings.
Note: The input strings may contain leading zeros but the output string should not have any leading zeros.

Input: s1 = "1101", s2 = "111"
Output: 10100
Explanation:
 1101
+ 111
10100
Input: s1 = "00100", s2 = "010"
Output: 110
Explanation: 
  100
+  10
  110
Constraints:
1 ≤s1.size(), s2.size()≤ 106

#User function Template for python3
class Solution:
    def addBinary(self, s1, s2):
        # code here
        # for iteration initilaise the i , j , ans string
        i = len(s1)-1 #last index
        j = len(s2)-1 # last index
        ans = ""# to store the answer
        carry = 0 # the count ones variable will be updated each step
        while(i>=0 or j >=0 ):
            c_ones = 0 #for each iteration count_ones = 0
            if(i>=0 and s1[i] == "1"):
                c_ones +=1
            if(j>=0 and s2[j] == "1"):
                c_ones +=1
                
                
                
                
            # now there will be set of rules:
            # for each iteration
            if(c_ones + carry == 0):
                ans = "0"+ ans
                carry = 0
            elif(c_ones + carry ==1):
                ans ="1"+ ans
                carry = 0
            elif(c_ones + carry ==2):
                ans ="0"+ ans
                carry = 1
            else:
                ans="1"+ ans
                carry = 1
            i-=1
            j-=1# for each step
            
        if(carry == 1):
            ans = "1"+ ans
            
       # now remove the leading 0
        i = 0
        while(i<len(ans) and ans[i]=="0"):
              i+=1
             
        ans = ans[i:]
        return ans
         
            


