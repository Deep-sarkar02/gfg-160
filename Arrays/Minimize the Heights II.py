Given an array arr[] denoting heights of n towers and a positive integer k.

For each tower, you must perform exactly one of the following operations exactly once.

Increase the height of the tower by k
Decrease the height of the tower by k
Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.

You can find a slight modification of the problem here.
Note: It is compulsory to increase or decrease the height by k for each tower. After the operation, the resultant array should not contain any negative integers.

Examples :

Input: k = 2, arr[] = [1, 5, 8, 10]
Output: 5
Explanation: The array can be modified as [1+k, 5-k, 8-k, 10-k] = [3, 3, 6, 8]. The difference between the largest and the smallest is 8-3 = 5.
Input: k = 3, arr[] = [3, 9, 12, 16, 20]
Output: 11
Explanation: The array can be modified as [3+k, 9+k, 12-k, 16-k, 20-k] = [6, 12, 9, 13, 17].The difference between the largest and the smallest is 17-6 = 11. 
Constraints
1 ≤ k ≤ 107
1 ≤ n ≤ 105
1 ≤ arr[i] ≤ 107



#User function Template for python3

class Solution:
    def getMinDiff(self, arr,k):
        # code here
        # find the srted array
        arr.sort()
        # find the initial smallest and the largest and the difference
        small = arr[0]
        large = arr[len(arr)-1]
        diff = large - small
        # now trverse the loop 
        for i in range(1,len(arr)):
            # now find the new smallest and the largest
            smallest = min(arr[0]+k , arr[i]-k)
            largest = max(arr[len(arr)-1]-k , arr[i-1]+k)
            # if smallest <0 then continue
            if(smallest<0):
                continue
            # find the new diff
            diff = min(diff , largest-smallest)
        return diff
        
