Given the root of a Binary search tree(BST), where exactly two nodes were swapped by mistake. Your task is to fix (or correct) the BST by swapping them back. Do not change the structure of the tree.
Note: It is guaranteed that the given input will form BST, except for 2 nodes that will be wrong. All changes must be reflected in the original Binary search tree(BST).
 
Examples :
Input: root = [10, 5, 8, 2, 20]
     
Output: 1
       

Explanation: The nodes 20 and 8 were swapped. 
Input: root = [5, 10, 20, 2, 8]
     
Output: 1 
     
Explanation: The nodes 10 and 5 were swapped.
Constraints:
1 ≤ Number of nodes ≤ 103


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
    Node prev = null;
    Node first = null;
    Node last = null;
    public void helper(Node root )
    {
        // base
        if(root == null)
        {
            return;
        }
        // for the left
        helper(root.left );
        // for the root
        
        if(prev != null)
        {
            if(prev.data > root.data)
            {
                if(first == null)
                {
                    first = prev;
                }
                last = root;
            }
        }
        prev  = root;
        
        // for the right 
        helper(root.right);
    }
    void correctBST(Node root) {
        // code here.
        
        helper(root );
        // swap the first and last
        //swap(first.data , last.data);
        if(first != null && last!= null)
        {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        }
    }
}
