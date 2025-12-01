Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[] with sum equal to given sum. 

Examples:

Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
Output: true 
Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.
Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 30
Output: false
Explanation: There is no subset with target sum 30.
Input: arr[] = [1, 2, 3], sum = 6
Output: true
Explanation: The entire array can be taken as a subset, giving 1 + 2 + 3 = 6.
Constraints:
1 <= arr.size() <= 200
1<= arr[i] <= 200
1<= sum <= 104

class Solution {
    static boolean helper(int arr[] , int n ,int sum)
    {
         // code here
         if(sum == 0) return true;
        if(n == 0) return false;
        
        // chek for last element
        if(arr[n - 1] <=sum) 
        {
            // take the last element or leasve it
            return 
            helper(arr , n-1, sum-arr[n-1]) || helper(arr , n-1 ,sum);
        }
        
        
            return helper(arr , n-1 , sum);
        
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        return helper(arr , n , sum);
       
        
    }
}
