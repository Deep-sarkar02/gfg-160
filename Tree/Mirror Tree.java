Given a binary tree, convert the binary tree to its Mirror tree.

Mirror of a Binary Tree T is another Binary Tree M(T) with left and right children of all non-leaf nodes interchanged.     

Examples:

Input: root[] = [1, 2, 3, N, N, 4]
Output: [1, 3, 2, N, 4]
Explanation: 

In the inverted tree, every non-leaf node has its left and right child interchanged.
Input: root[] = [1, 2, 3, 4, 5]
Output: [1, 3, 2, N, N, 5, 4]
Explanation:

In the inverted tree, every non-leaf node has its left and right child interchanged.
Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)
   {
        data = item;
        left = right = null;
    }
} */

class Solution {
    Node helper(Node node)
    {
        // Your code here
        if(node == null)
        {
            return node ;
        }
        // pass the left sub tree
        Node left = helper(node.left);
        Node right= helper(node.right);
        
        node.right=left;
        node.left = right; 
        return node;
    }
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        helper(node);
        
    }
}

  
