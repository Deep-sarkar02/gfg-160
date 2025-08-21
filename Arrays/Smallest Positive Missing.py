You are given an integer array arr[]. Your task is to find the smallest positive number missing from the array.

Note: Positive number starts from 1. The array can have negative integers too.

Examples:

Input: arr[] = [2, -3, 4, 1, 1, 7]
Output: 3
Explanation: Smallest positive missing number is 3.
Input: arr[] = [5, 3, 2, 5, 1]
Output: 4
Explanation: Smallest positive missing number is 4.
Input: arr[] = [-8, 0, -1, -4, -3]
Output: 1
Explanation: Smallest positive missing number is 1.
Constraints:  
1 ≤ arr.size() ≤ 105
-106 ≤ arr[i] ≤ 106

#User function Template for python3

class Solution:
    
    #Function to find the smallest positive number missing from the array.
    def missingNumber(self,arr):
        #Your code here
        # now we will traverse the loop from 0 and checks if the no. >=1 , less then length of the array , and that no. is not in its correct index
        for i in range(len(arr)):
            while(arr[i]>=1 and arr[i]<=len(arr) and arr[i] != arr[arr[i]-1]): # we just want to put the element of the array to the index which they belong to
                # now swap the element to their correct index
                temp = arr[arr[i]-1]
                arr[arr[i]-1] = arr[i]
                arr[i] = temp
        # now we will find out the first misssing pos element
        # run a loop from 1 to the len of the arr
        for i in range(len(arr)):
            # check first missing pos element
            if(arr[i] != i+1):
                return (i+1) # if successfull
                break
        else:
            # now if all the element are at the correct index
            # then return the no.(len(arr)+1)
            return (len(arr)+1)
        
