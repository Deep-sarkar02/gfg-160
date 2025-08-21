You are given a circular array arr[] of integers, find the maximum possible sum of a non-empty subarray. In a circular array, the subarray can start at the end and wrap around to the beginning. Return the maximum non-empty subarray sum, considering both non-wrapping and wrapping cases.

Examples:

Input: arr[] = [8, -8, 9, -9, 10, -11, 12]
Output: 22
Explanation: Starting from the last element of the array, i.e, 12, and moving in a circular fashion, we have max subarray as 12, 8, -8, 9, -9, 10, which gives maximum sum as 22.
Input: arr[] = [10, -3, -4, 7, 6, 5, -4, -1]
Output: 23
Explanation: Maximum sum of the circular subarray is 23. The subarray is [7, 6, 5, -4, -1, 10].
Input: arr[] = [5, -2, 3, 4]
Output: 12
Explanation: The circular subarray [3, 4, 5] gives the maximum sum of 12.
Constraints:
1 ≤ arr.size() ≤ 105
-104 ≤ arr[i] ≤ 104

#User function Template for python3

#Complete this function
#Function to find maximum circular subarray sum.
def circularSubarraySum(arr):
    ##Your code here
    # now we will find the min sum subarray and the max sum subarray and the total sum of the array
    # variable for the min sum subarray
    i_min = 0
    int_max = 2**31
    sum_min = int_max
    # variable for the max sum subarray
    i_max = 0
    int_min = -2**31
    sum_max = int_min
    # total
    total = 0
    # now trverse over the loop to find the total sum, min sum subarray , max sum sub array
    for i in range(len(arr)):
        # find the total element
        total = total + arr[i]
        # find the max sum subarray
        i_max = i_max+arr[i]
        sum_max = max(sum_max , i_max)
        if i_max < 0:
            i_max = 0 #rexet the value
        # find the min sum subarray
        i_min = i_min+arr[i]
        sum_min = min(sum_min , i_min)
        if i_min > 0:
            i_min = 0 #reset the value
    # return the max of the max_sum ,  total-min_sum
    return (max(sum_max , total-sum_min))
        
        
