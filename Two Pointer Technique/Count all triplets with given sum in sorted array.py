Given a sorted array arr[] and a target value, the task is to count triplets (i, j, k) of valid indices, such that arr[i] + arr[j] + arr[k] = target and i < j < k.

Examples:

Input: arr[] = [-3, -1, -1, 0, 1, 2], target = -2
Output: 4
Explanation: Four triplets that add up to -2 are:
arr[0] + arr[3] + arr[4] = (-3) + 0 + (1) = -2
arr[0] + arr[1] + arr[5] = (-3) + (-1) + (2) = -2
arr[0] + arr[2] + arr[5] = (-3) + (-1) + (2) = -2
arr[1] + arr[2] + arr[3] = (-1) + (-1) + (0) = -2
Input: arr[] = [-2, 0, 1, 1, 5], target = 1
Output: 0
Explanation: There is no triplet whose sum is equal to 1. 
Constraints:
3 ≤ arr.size() ≤ 104
-105 ≤ arr[i], target ≤ 105

Expected Complexities



class Solution:
    def countTriplets(self, arr, target):
        # code here
        count = 0
        n = len(arr)
        for i in range(0 , n-2): # from 0 to n-3
            # initialise the k and j
            j = i+1
            k = n-1
            # apply 2 pointer on the remaining array
            while(j<k):
                sum = arr[i]+arr[j]+arr[k]
                # nwo check th sum with the target
                if(sum > target):
                    k -=1
                elif(sum <target):
                    j +=1
                # now is both are same
               
                elif(sum == target):
                    #DUPLICATE CASE HANDLE
                    if(arr[j] == arr[k]): # all the elem will be same for the right and left
                        # find the length of the same
                        length = (k-j)+1
                        # fidn the count
                        count += (length * (length-1))//2
                        break
                    # find the duplicates for the left
                    leftcount = 1
                    while(j+1 <k and arr[j] == arr[j+1]):
                        # incrsea j
                        j+=1
                        leftcount+=1
                    #  for the right count
                    rightcount = 1
                    while(k-1 > j and arr[k] == arr[k-1]):
                        # incrsea j
                        k-=1
                        rightcount+=1
                    # now the count 
                    count += (leftcount * rightcount)
                    j+=1
                    k-=1
                
                   
        return count
