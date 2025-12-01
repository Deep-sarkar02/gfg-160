There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Your task is to count the number of ways, the person can reach the top (order does matter).

Examples:

Input: n = 1
Output: 1
Explanation: There is only one way to climb 1 stair. 
Input: n = 2
Output: 2
Explanation: There are 2 ways to reach 2th stair: {1, 1} and {2}.  
Input: n = 4
Output: 5
Explanation: There are five ways to reach 4th stair: {1, 1, 1, 1}, {1, 1, 2}, {2, 1, 1}, {1, 2, 1} and {2, 2}.
Constraints:
1 ≤ n ≤ 25


  class Solution {
    int countWays(int n) {
        // your code here
        // base case 
        
        // by recusraion
        // if(n == 0) return 0;
        // if(n== 1) return 1;
        // if(n==2) return 2;
        // return countWays(n- 1)+countWays(n-2);
        
        
        // by dp
        int[] arr = new int[n+1];
        arr[0] = 1;
        if(n>=1) arr[1] = 1;
        if(n>=2) arr[2] = 2;
        for(int i = 3 ; i<=n ; i++)
        {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
}

