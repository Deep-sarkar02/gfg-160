Given an integer array coins[ ] representing different denominations of currency and an integer sum, find the number of ways you can make sum by using different combinations from coins[ ]. 
Note: Assume that you have an infinite supply of each type of coin. Therefore, you can use any coin as many times as you want.
Answers are guaranteed to fit into a 32-bit integer. 

Examples:

Input: coins[] = [1, 2, 3], sum = 4
Output: 4
Explanation: Four Possible ways are: [1, 1, 1, 1], [1, 1, 2], [2, 2], [1, 3].
Input: coins[] = [2, 5, 3, 6], sum = 10
Output: 5
Explanation: Five Possible ways are: [2, 2, 2, 2, 2], [2, 2, 3, 3], [2, 2, 6], [2, 3, 5] and [5, 5].
Input: coins[] = [5, 10], sum = 3
Output: 0
Explanation: Since all coin denominations are greater than sum, no combination can make the target sum.
Constraints:
1 <= sum <= 103
1 <= coins[i] <= 104
1 <= coins.size() <= 103


class Solution {
    // helper function
    // with out dp code
    int dp[][];
    public int helper(int coins[] , int sum , int i)
    {
        
        // base case
        if(sum < 0) return 0;
        if(sum == 0) return 1;
        if(i == coins.length) return 0;
        // work
        // pick or no pick
        
        // if the dp[i][sum] != -1 
        if(dp[i][sum] != -1) return dp[i][sum];
        int pick = helper(coins , sum -  coins[i] , i); // the i  will not increse since , we can pick that i or that coin any no. of times since , of unlimited supply
        int np = helper(coins , sum , i+1) ; // go to next coin
        return dp[i][sum] = pick + np;
        
    }
    public int count(int coins[], int sum) {
        // code here.
        // go to the helper function
        // initialisse the dp mat with -1
        //  make the dp table
        dp = new int [coins.length+1][sum+1];
       for(int i = 0 ; i<=coins.length ; i++)
       {
           for(int j = 0 ; j<= sum ; j++)
           {
               dp[i][j] = -1;
           }
       }
        return helper(coins , sum , 0);
    }
}
