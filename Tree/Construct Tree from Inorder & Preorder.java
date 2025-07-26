Given two arrays representing the inorder and preorder traversals of a binary tree, construct the tree and return the root node of the constructed tree.

Note: The output is written in postorder traversal.

Examples:

Input: inorder[] = [1, 6, 8, 7], preorder[] = [1, 6, 7, 8]
Output: [8, 7, 6, 1]
Explanation: The tree will look like

Input: inorder[] = [3, 1, 4, 0, 2, 5], preorder[] = [0, 1, 3, 4, 2, 5]
Output: [3, 4, 1, 5, 2, 0]
Explanation: The tree will look like

Input: inorder[] = [2, 5, 4, 1, 3], preorder[] = [1, 4, 5, 2, 3]
Output: [2, 5, 4, 3, 1]
Explanation: The tree will look like

Constraints:
1 ≤ number of nodes ≤ 103
0 ≤ nodes -> data ≤ 103
Both the inorder and preorder arrays contain unique values.



  /*
class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}
*/

class Solution {
    int preIndex =  0 ;
    public int search( int inorder[] , int val  ,int leftb_i , int rightb_i)
    {
        // search for the val in the array
        for(int i = leftb_i ; i <= rightb_i ; i++)
        {
            if(inorder[i] == val)
            {
                // return the index
                return i;
            }
        }
        // if not found return -1
        return -1;
    }
    public  Node helper(int inorder[], int preorder[] , int leftb_i , int rightb_i)
    {
        
        // base 
        if(leftb_i > rightb_i)
        {
            return null;
        }
        // do the work
        // create the root with the Index 
        Node root = new Node(preorder[preIndex]);
        // now go for next preIndex
        preIndex++;
        
        // fidn the index value in inorder list
        int inIndex = search(inorder , root.data ,leftb_i , rightb_i );
        
        //now call for the next left and the right subtree
        root.left = helper(inorder, preorder  ,leftb_i , inIndex-1 );
        root.right = helper(inorder , preorder  ,inIndex+1 , rightb_i );
        
        return root;
    }
    public  Node buildTree(int inorder[], int preorder[]) {
        
        return helper(inorder,  preorder,0 , inorder.length-1);
        // code here
        
        
    }
}
