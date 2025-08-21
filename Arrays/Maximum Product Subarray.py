Given an array arr[] that contains positive and negative integers (may contain 0 as well). Find the maximum product that we can get in a subarray of arr[].

Note: It is guaranteed that the answer fits in a 32-bit integer.

Examples

Input: arr[] = [-2, 6, -3, -10, 0, 2]
Output: 180
Explanation: The subarray with maximum product is [6, -3, -10] with product = 6 * (-3) * (-10) = 180.
Input: arr[] = [-1, -3, -10, 0, 6]
Output: 30
Explanation: The subarray with maximum product is [-3, -10] with product = (-3) * (-10) = 30.
Input: arr[] = [2, 3, 4] 
Output: 24 
Explanation: For an array with all positive elements, the result is product of all elements. 
Constraints:
1 ≤ arr.size() ≤ 106
-10  ≤  arr[i]  ≤  10

#User function Template for python3
class Solution:

    # Function to find maximum
    # product subarray
    def maxProduct(self,arr):
        # code here
        # we have to iterate from the left to right and then from right to left
        l = 1
        int_min = -2**31
        max_l =int_min
        # iterate from the left to right
        for i in range(len(arr)):
            l = l*arr[i]
            # store the max of them 
            max_l = max(max_l , l)
            # now if the l  == 0 then reset the val with 1
            if(l ==0):
                l = 1
        r = 1
        max_r =int_min
       
        # reverse the array:
        arr.reverse()
         # iterate from the right to left
        for i in range(len(arr)):
            r = r*arr[i]
            # store the max of them 
            max_r = max(max_r , r)
            # now if the l  == 0 then reset the val with 1
            if(r ==0):
                r = 1
        # now return the max of the both
        return max(max_r , max_l)
                
        
       
