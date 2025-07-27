Given a Binary Search Tree(BST) and a target. Check whether there's a pair of Nodes in the BST with value summing up to the target. 

Examples:

Input: root = [7, 3, 8, 2, 4, N, 9], target = 12
       bst
Output: True
Explanation: In the binary tree above, there are two nodes (8 and 4) that add up to 12.
Input: root = [9, 5, 10, 2, 6, N, 12], target = 23
          bst-3
Output: False
Explanation: In the binary tree above, there are no such two nodes exists that add up to 23.
Constraints:

1 ≤ Number of Nodes ≤ 105
1 ≤ target ≤ 106

/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/
class Solution {
    boolean findTarget(Node root, int target) {
        // Write your code here
        Set<Integer> s= new HashSet<>();
        return helper(root , target , s);
        
    }
    public boolean helper(Node root , int target , Set<Integer>s )
    {
        // base
        if(root == null)
        {
            return false;
        }
        // for the left
        if(helper( root.left ,  target ,s ))
        {
            return true;
        }
        // for the root val
        // find the diff in the set if found then return true else add the root.data to the set
        if(s.contains(target - root.data))
        {
            return true;
        }
        s.add(root.data);
        
        // for the right 
        return  helper( root.right ,  target ,s );
    }
}

  
