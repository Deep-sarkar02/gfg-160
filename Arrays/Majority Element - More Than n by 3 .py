Given an array arr[] consisting of n integers, the task is to find all the array elements which occurs more than floor(n/3) times.

Note: The returned array of majority elements should be sorted.

Examples:

Input: arr[] = [2, 2, 3, 1, 3, 2, 1, 1]
Output: [1, 2]
Explanation: The frequency of 1 and 2 is 3, which is more than floor n/3 (8/3 = 2).
Input:  arr[] = [-5, 3, -5]
Output: [-5]
Explanation: The frequency of -5 is 2, which is more than floor n/3 (3/3 = 1).
Input:  arr[] = [3, 2, 2, 4, 1, 4]
Output: []
Explanation: There is no majority element.
Constraint:
1 ≤ arr.size() ≤ 106
-105 ≤ arr[i] ≤ 105

class Solution:
    # Function to find the majority elements in the array
    def findMajority(self, arr):
        #Your Code goes here.
        # brute force approach
        '''
        # find the pivot
        p = len(arr)/3
        # traverse a loop over the array and calculate the count of of each of the element
        c = 0
        # initailise an array to return the elemnt
        d = []
        # loop the array
        for i in range(len(arr)):
            c = arr.count(arr[i])
            if c>p :
                # if the element is not in d then append the element to d
                if(arr[i] not in d):
                    d.append(arr[i])
        # sort the array
        d.sort()
        # return d
        return d'''
        # boyre moores algorithm..
        # optimal approach
        # initaite 2 variable for the each of the element
        f1 = 0 
        el1 = 0
        f2 = 0
        el2 = 0
        
        #loop over the array:
        for i in range(len(arr)):
            # if f1 ==0 and that element not in el2 then
            if(f1 == 0 and arr[i]!= el2):
                f1 = 1
                el1 = arr[i]
            elif(f2 == 0 and arr[i] != el1):
                f2 = 1
                el2 = arr[i]
            elif(arr[i] == el1):
                f1 = f1 +1
            elif(arr[i] == el2):
                f2 = f2 +1
            else:
                f1 = f1-1
                f2 = f2 -1
        # now check the condition of the majoruty element
        # initiate array to retunr element
        a = []
        # check the count of both the element
        if(arr.count(el1) > len(arr)/3):
            a.append(el1)
        if(arr.count(el2) >len(arr)/3):
            a.append(el2)
        a.sort()
        # now return the array
        return  a
        

