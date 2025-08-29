Given a string s consisting of lowercase English Letters. return the first non-repeating character in s. If there is no non-repeating character, return '$'.

Examples:

Input: s = "geeksforgeeks"
Output: 'f'
Explanation: In the given string, 'f' is the first character in the string which does not repeat.
Input: s = "racecar"
Output: 'e'
Explanation: In the given string, 'e' is the only character in the string which does not repeat.
Input: s = "aabbccc"
Output: '$'
Explanation: All the characters in the given string are repeating.
Constraints:
1 ≤ s.size() ≤ 105

#User function Template for python3

class Solution:
    
    #Function to find the first non-repeating character in a string.
    def nonRepeatingChar(self,s):
        #code here
        freq = {}
        ans = "$"
        for i in range(len(s)):
            if(s[i] not in freq):
                freq[s[i]] = 1
            else:
                freq[s[i]] += 1
        #now loop over the dict to find the answer
        for j in freq:
            if(freq[j] == 1):
                ans = j
                break
        return ans
    
    
