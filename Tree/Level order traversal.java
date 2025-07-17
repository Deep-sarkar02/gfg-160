Given a root of a binary tree with n nodes, the task is to find its level order traversal. Level order traversal of a tree is breadth-first traversal for the tree.

Examples:

Input: root[] = [1, 2, 3]

Output: [[1], [2, 3]]
Input: root[] = [10, 20, 30, 40, 50]

Output: [[10], [20, 30], [40, 50]]
Input: root[] = [1, 3, 2, N, N, N, 4, 6, 5]

Output: [[1], [3, 2], [4], [6, 5]]
Constraints:

1 ≤ number of nodes ≤ 105
0 ≤ node->data ≤ 109

/*
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        // Your code here
        // start with a emplty queue
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<Node>t  = new LinkedList<>();
        // now we will add the first node to the queue
        t.add(root);
        // now we will pop the elem while it is != 0
        while(!t.isEmpty())
        {
            // fidn the size of the q at this level
            int level_size = t.size();
            
            ArrayList<Integer> level = new ArrayList<>();
            // now we will run a loop for this level and we will insert the value
            for(int i = 0 ; i < level_size ; i++)
            {
            // now we will pop
            Node temp = t.poll();
            // push the data to the level array
            level.add(temp.data);
            
            // now call for the left and the right
            // now push the left and the right 
            if(temp.left != null)
            {
                t.add(temp.left);
            }
            if(temp.right != null)
            {
                t.add(temp.right);
            }
            
            }
            // now  push the result to ans
            res.add(level);
            
        }
        
        return res;
        
        
    }
}
  
