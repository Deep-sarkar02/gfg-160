Given a binary tree, the diameter (also known as the width) is defined as the number of edges on the longest path between two leaf nodes in the tree. This path may or may not pass through the root. Your task is to find the diameter of the tree.

Examples:

Input: root[] = [1, 2, 3]

Output: 2
Explanation: The longest path has 2 edges (node 2 -> node 1 -> node 3).

Input: root[] = [5, 8, 6, 3, 7, 9]

Output: 4
Explanation: The longest path has 4 edges (node 3 -> node 8 -> node 5 -> node 6 -> node 9).

Constraints:
1 ≤ number of nodes ≤ 105
0 ≤ node->data ≤ 105


/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    // just by doing some edit on the height function we can get the code 
    // gloabal value called ans
    // then we willl form the lh + rh in the function
    // and compare with the ans;
    // return the height ie , max(lh , rh)+1;
    int ans = 0 ;
    public int height(Node root)
    {
        // base 
        if(root == null)
        {
            return 0;
        }
        // for all the case
        int lh = height(root.left);
        int rh = height(root.right);
        ans = Math.max(ans , (lh+rh));
        
        
        // return ans
        return Math.max(lh , rh)+1;
    }
    
    public int diameter(Node root) {
       
        height(root);
        return ans;
        
    }
}
