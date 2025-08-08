You are given an integer target and an array arr[]. You have to find number of pairs in arr[] which sums up to target. It is given that the elements of the arr[] are in sorted order.
Note: pairs should have elements of distinct indexes. 

Examples :

Input: arr[] = [-1, 1, 5, 5, 7], target = 6
Output: 3
Explanation: There are 3 pairs which sum up to 6 : {1, 5}, {1, 5} and {-1, 7}.
Input: arr[] = [1, 1, 1, 1], target = 2
Output: 6
Explanation: There are 6 pairs which sum up to 2 : {1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1} and {1, 1}.
Input: arr[] = [-1, 10, 10, 12, 15], target = 125
Output: 0
Explanation: There is no such pair which sums up to 125.
Constraints:
-105 <= target <=105
 2 <= arr.size() <= 105
-105 <= arr[i] <= 105

#User function Template for python3


class Solution:
    def countPairs (self, arr, target) : 
        #Complete the function
        i = 0
        j = len(arr)-1
        ans = 0
        while(i<j):
            if(arr[i] +arr[j] == target):
                if(arr[i] == arr[j]):
                    l = (j -i)+1
                    ans += (l *(l-1))//2
                    break
                else:
                    lc = 1
                    while(i+1<j  and arr[i] == arr[i+1]):
                        lc +=1
                        i+=1
                    rc=1
                    while(j-1 > i and arr[j] == arr[j-1]):
                        rc+=1
                        j-=1
                    ans +=(lc *rc)
                i+=1
                j-=1
            elif(arr[i] + arr[j] > target):
                j-=1
            else:
                i+=1
        return ans

