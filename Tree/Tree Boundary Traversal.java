Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order: 

Left Boundary: This includes all the nodes on the path from the root to the leftmost leaf node. You must prefer the left child over the right child when traversing. Do not include leaf nodes in this section.

Leaf Nodes: All leaf nodes, in left-to-right order, that are not part of the left or right boundary.

Reverse Right Boundary: This includes all the nodes on the path from the rightmost leaf node to the root, traversed in reverse order. You must prefer the right child over the left child when traversing. Do not include the root in this section if it was already included in the left boundary.

Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary. 

Examples:

Input: root[] = [1, 2, 3, 4, 5, 6, 7, N, N, 8, 9, N, N, N, N]
Output: [1, 2, 4, 8, 9, 6, 7, 3]
Explanation:
 
Input: root[] = [1, 2, N, 4, 9, 6, 5, N, 3, N, N, N, N 7, 8]
Output: [1, 2, 4, 6, 5, 7, 8]
Explanation:
            
As the root doesn't have a right subtree, the right boundary is not included in the traversal.
Input: root[] = [1, N, 2, N, 3, N, 4, N, N] 
Output: [1, 4, 3, 2]
Explanation:

Left boundary: [1] (as there is no left subtree)
Leaf nodes: [4]
Right boundary: [3, 2] (in reverse order)
Final traversal: [1, 4, 3, 2]
Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105
/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    public void left(Node root , ArrayList<Integer> ans)
    {
        // point to the left 
        Node temp = root.left;
        // now we will check if the temp.left not = null
        while(temp != null)
        {
            // we will check if it is not the leaft node
            if(temp.left != null || temp.right!= null )
            {
                ans.add(temp.data);
            }
            // now upate temp
            if(temp.left != null)
            {
                temp = temp.left;
            }
            else
            {
                temp = temp.right;
            }
        }
    }
    public void leaf(Node root ,ArrayList<Integer> ans )
    {
        // base
        if(root == null)
        {
            return ;
        }
        // work
        // check if it is leaf
        if(root .left == null && root.right == null)
        {
            // then add this to ans
            ans.add(root.data);
        }
        // else we will call
        leaf(root.left ,ans);
        leaf(root.right , ans);
        
    }
    
    public void right(Node root , ArrayList<Integer> ans)
    {
        // point to the left 
        Node temp = root.right;
        // for reversal we willfirst push it in to temp array
        ArrayList<Integer> t = new ArrayList<>();
        
        // now we will check if the temp.left not = null
        while(temp != null)
        {
            // we will check if it is not the leaft node
            if(temp.left != null || temp.right!= null )
            {
                t.add(temp.data);
            }
            // now upate temp
            if(temp.right != null)
            {
                temp = temp.right;
            }
            else
            {
                temp = temp.left;
            }
        }
        // now we will reverse the temp array ans push to ans
        Collections.reverse(t);
        for (int i = 0 ; i<t.size() ; i++)
        {
            ans.add(t.get(i));
        }
       
    }
    
    public ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        // first put the root
        ans.add(node.data);
        // now we will call for the left and the right function
        left(node ,ans);
        // edge case--> if leaf node present then only call so that if one node preset it will not be passes
        if(node.left != null || node.right!= null )
        {
            leaf(node , ans);
        }
        
        right(node , ans);
        return ans;
    }
}
