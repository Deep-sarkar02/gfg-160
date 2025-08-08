Given an integer array arr[] and a number k. Find the count of distinct elements in every window of size k in the array.

Examples:

Input: arr[] = [1, 2, 1, 3, 4, 2, 3], k = 4
Output:  [3, 4, 4, 3]
Explanation: Window 1 of size k = 4 is [1, 2, 1, 3]. Number of distinct elements in this window are 3. 
Window 2 of size k = 4 is [2, 1, 3, 4]. Number of distinct elements in this window are 4.
Window 3 of size k = 4 is [1, 3, 4, 2]. Number of distinct elements in this window are 4.
Window 4 of size k = 4 is [3, 4, 2, 3]. Number of distinct elements in this window are 3.
Input: arr[] = [4, 1, 1], k = 2
Output: [2, 1]
Explanation: Window 1 of size k = 2 is [4, 1]. Number of distinct elements in this window are 2.
Window 2 of size k = 2 is [1, 1]. Number of distinct elements in this window is 1. 
Input: arr[] = [1, 1, 1, 1, 1], k = 3
Output: [1, 1, 1]
Explanation: Every window of size 3 in the array [1, 1, 1, 1, 1], contains only the element 1, so the number of distinct elements in each window is 1.
Constraints:
1 ≤ k ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 105



class Solution:
    def countDistinct(self, arr, k):
        # Code here
        d = defaultdict(int)
        ans = []
        for i in range(0 , k): # ie from 0 to 3 or 4 element
            d[arr[i]] +=1
        #now push the length of the dictionary
        ans.append(len(d))
        
        # now we will loop from k to n
        for m in range(k  , len(arr)):
            # we will delete the count of the elem arr[m - k] from the array
            d[arr[m-k]] -=1
            # now if the decreament makes the count == 0 then the delete the key from the dictonary
            if(d[arr[m-k]] == 0):
                del d[arr[m-k]]
            # increaase the arr[i] content in the dictionary
            d[arr[m]] +=1
            
            # push the size of dict in the array
            ans.append(len(d))
        return ans
        ''' i = 0
        j = (i+ k)-1
        d = {}
        ans = []
        while(i<=j  and j <len(arr)):
            for h in range(i , j+1):
                if arr[h] in d:
                    d[arr[h]] +=1
                else:
                    d[arr[h]] = 1
            i+=1
            j+=1
            ans.append(len(d))
            # after each step we will clear the dictioanry
            d.clear()
        return ans'''
