Given an array arr[] with non-negative integers representing the height of blocks. If the width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 

Examples:

Input: arr[] = [3, 0, 1, 0, 4, 0 2]
Output: 10
Explanation: Total water trapped = 0 + 3 + 2 + 3 + 0 + 2 + 0 = 10 units.

Input: arr[] = [3, 0, 2, 0, 4]
Output: 7
Explanation: Total water trapped = 0 + 3 + 1 + 3 + 0 = 7 units.
Input: arr[] = [1, 2, 3, 4]
Output: 0
Explanation: We cannot trap water as there is no height bound on both sides.
Input: arr[] = [2, 1, 5, 3, 1, 0, 4]
Output: 9
Explanation: Total water trapped = 0 + 1 + 0 + 1 + 3 + 4 + 0 = 9 units.
Constraints:
1 < arr.size() < 105
0 < arr[i] < 103




class Solution {
    public int maxWater(int arr[]) {
        // code here
        int leftMax[] = new int[arr.length];
        // find the left max
        leftMax[0] = arr[0];
        // now run the loop from i= 1
        for(int i = 1 ;i<arr.length ; i++)
        {
            leftMax[i] = Math.max(leftMax[i-1] , arr[i]);
        }
        
        // for the right max
        int rightMax[] = new int[arr.length];
        rightMax[arr.length-1] = arr[arr.length - 1];
        for(int i = arr.length-2 ; i>=0 ; i--)
        {
            rightMax[i] = Math.max(rightMax[i+1] , arr[i]);
        }
        int sum = 0 ;
        // now we will loop over the array
        for (int i = 0 ; i<arr.length ; i++)
        {
            sum += Math.min(leftMax[i] ,rightMax[i] )-arr[i];
        }
        return sum;
    }
}
