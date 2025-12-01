Given two arrays, val[] and wt[], where each element represents the value and weight of an item respectively, and an integer W representing the maximum capacity of the knapsack (the total weight it can hold).

The task is to put the items into the knapsack such that the total value obtained is maximum without exceeding the capacity W.

Note: You can either include an item completely or exclude it entirely — fractional selection of items is not allowed. Each item is available only once.

Examples :

Input: W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1]
Output: 3
Explanation: Choose the last item, which weighs 1 unit and has a value of 3.
Input: W = 3, val[] = [1, 2, 3], wt[] = [4, 5, 6] 
Output: 0
Explanation: Every item has a weight exceeding the knapsack's capacity (3).
Input: W = 5, val[] = [10, 40, 30, 50], wt[] = [5, 4, 2, 3] 
Output: 80
Explanation: Choose the third item (value 30, weight 2) and the last item (value 50, weight 3) for a total value of 80.
Constraints:
1 ≤ val.size() = wt.size() ≤ 103
1 ≤ W ≤ 103
1 ≤ val[i] ≤ 103
1 ≤ wt[i] ≤ 103


class Solution {
    // funct to solve the 
    // by recursion
    // static int helper(int w, int val[], int wt[] , int i)
    // {
    //     // base case
    //     if(i == wt.length)
    //     {
    //         return 0;
    //     }
    //     // 2 choise
    //     //pick
    //     int pick = 0;
    //     // if i pick it
    //     if(wt[i] <= w)
    //     {
    //         pick = val[i] + helper(w - wt[i] , val , wt , i+1);
    //     }
        
    //     int nopick = helper(w  , val , wt , i+1);
    //     //return the max of pick and no pick
    //     return Math.max(pick , nopick);
    // }
    static int knapsack(int w, int val[], int wt[]) {
        // code here
        // create the dp table
        int n = wt.length;
        int [][] dp = new int [n+1][w+1];
        // for loop 
        for(int i = 1 ; i<=n ; i++)
        {
            for(int j =0 ; j<=w ;j++ )
            {
                // take the prev row val to filll
                dp[i][j] = dp[i-1][j];
                
                // but for the other cases
                if(wt[i-1] <= j)
                {
                    dp[i][j] = Math.max(dp[i][j] , val[i-1]+dp[i-1][j-wt[i-1]]);
                }
                
            }
        }
        return dp[n][w];
        
    }
}
