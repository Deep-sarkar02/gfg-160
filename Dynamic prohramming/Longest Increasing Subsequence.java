Given an array arr[] of non-negative integers, the task is to find the length of the Longest Strictly Increasing Subsequence (LIS).
A subsequence is strictly increasing if each element in the subsequence is strictly less than the next element.

Examples:

Input: arr[] = [5, 8, 3, 7, 9, 1]
Output: 3
Explanation: The longest strictly increasing subsequence could be [5, 7, 9], which has a length of 3.
Input: arr[] = [10, 6, 3, 11, 7, 15]
Output: 3
Explanation: One of the possible longest strictly increasing subsequences is [10, 11, 15], which has a length of 3.
Input: arr[] = [3, 10, 2, 1, 20]
Output: 3
Explanation: The longest strictly increasing subsequence could be [3, 10, 20], which has a length of 3.
Constraints:
1 ≤ arr.size() ≤ 103
0 ≤ arr[i] ≤ 106

class Solution {
    static int lis(int arr[]) {
        // code here
        // create the array to memoise
        int [] t = new int [arr.length];
        // loop over the array
        // i at 1
        // j at 0
        for(int i = 1 ; i<arr.length ; i++)
        {
            // i always atart at 1
            // now j will staart from 0 to i
            for(int j = 0 ; j< i ; j++)
            {
                // if the j value wll be less
                if(arr[j] < arr[i])
                {
                    // we will upate the  i th place in the array
                    if(t[j] + 1 > t[i]) // if t[i] +1 will be greater than the t[j]
                    {
                        t[i] = t[j]+1;
                    }
                }
            }
        }
        
        // find the max index
        int max = 0;
        // loop from the t
        for(int i = 0 ; i <t.length ; i++)
        {
            if(t[i] > t[max])
            {
                max = i; // get the max index
            }
        }
        return t[max] +1;
    }
}
