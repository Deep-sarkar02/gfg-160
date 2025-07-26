Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.

Examples:

Input: root[] = [10, 2, 10, 20, 1, N, -25, N, N, N, N, 3, 4]
Output: 42
Explanation: 

Max path sum is represented using green colour nodes in the above binary tree.
Input: root[] = [-17, 11, 4, 20, -2, 10]
Output: 31
Explanation: 

Max path sum is represented using green colour nodes in the above binary tree.
Constraints:
1 ≤ number of nodes ≤ 103
-104 ≤ node->data ≤ 104
/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    int maxsum = Integer.MIN_VALUE;
    int helper(Node root )
    {
        
        // base
        if(root == null)
        {
            return 0;
        }
        //now deo the work
        // we will do pass the value to the function only the pos value will be passed
        int left = Math.max(0,helper(root.left));
        int right = Math.max(0 , helper(root.right));
        // store the max value 
        maxsum = Math.max(maxsum , root.data+left+right);
        
        // now return the max of left and right and the root data
        return Math.max(left, right) + root.data;
       
    }
    // Function to return maximum path sum from any node in a tree.
    int findMaxSum(Node node) 
    {
        // your code goes here
        helper(node);
        return maxsum;
        
    }
}
