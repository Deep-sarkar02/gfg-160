Given an array arr[], determine if it can be partitioned into two subsets such that the sum of elements in both parts is the same.

Note: Each element must be in exactly one subset.

Examples:

Input: arr = [1, 5, 11, 5]
Output: true
Explanation: The two parts are [1, 5, 5] and [11].
Input: arr = [1, 3, 5]
Output: false
Explanation: This array can never be partitioned into two such parts.
Constraints:
1 ≤ arr.size ≤ 100
1 ≤ arr[i] ≤ 200

class Solution {
    static boolean helper(int arr[]  , int n , int sum)
    {
        if(sum == 0 ) return true;
        if(n == 0 )return false;
        //  check for last eleemnt
        if(arr[n-1] <= sum)
        {
        return helper(arr , n-1 , sum-arr[n-1]) || helper(arr , n-1 , sum);
        }
        return helper(arr , n-1 , sum);
    }
    static boolean equalPartition(int arr[]) {
        // code here
        int n = arr.length;
        // find the sum of all the element of  the array
        int tsum = 0 ;
        for(int x : arr)
        {
            tsum += x;
        }
        // if the tsum is odd then return false
        if(tsum %2 != 0) return false;
        //  else
        int target = tsum /2;
        
        //pass it to the helper function
        return helper(arr , n , target );
    }
}
