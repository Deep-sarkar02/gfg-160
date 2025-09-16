 given an integer array arr[]. You need to find the maximum sum of a subarray (containing at least one element) in the array arr[].

Note : A subarray is a continuous part of an array.

Examples:

Input: arr[ = [2, 3, -8, 7, -1, 2, 3]
Output: 11
Explanation: The subarray [7, -1, 2, 3] has the largest sum 11.
Input: arr[] = [-2, -4]
Output: -2
Explanation: The subarray [-2] has the largest sum -2.
Input: arr[] = [5, 4, 1, 7, 8]
Output: 25
Explanation: The subarray [5, 4, 1, 7, 8] has the largest sum 25.
Constraints:
1 ≤ arr.size() ≤ 105
-104 ≤ arr[i] ≤ 104

#User function Template for python3

class Solution:
    ##Complete this function
    #Function to find the sum of contiguous subarray with maximum sum.
    def maxSubArraySum(self,arr):
        ##Your code here
        # start 2 variables:
        curr_sum = 0
        # the max_sum will store the largest neg no. or to the largest
        int_min = -2**31 # it is the loweest no. possible
        max_sum = int_min # answer will be  stored here
        
        
        
        # start a loop over the array and then add each element with the curr_sum
        for i in range(len(arr)):
            # add all the element with curr_sum
            curr_sum = curr_sum + arr[i]
            # now store the max of the curr_sum and the max_sum in the max_sum
            max_sum = max(max_sum , curr_sum)
            # if any time during the iteration the curr_sum <0 then reset the value of the currentsum to 0
            if(curr_sum <0 ):
                curr_sum = 0
        # now return the max_sum
        return  max_sum
