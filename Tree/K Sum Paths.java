Given a binary tree and an integer k, determine the number of downward-only paths where the sum of the node values in the path equals k. A path can start and end at any node within the tree but must always move downward (from parent to child).

Examples:

Input: k = 7   

Output: 3
Explanation: The following paths sum to k 
 
Input: k = 3

Output: 2 
Explanation: Path 1 : 1 -> 2 (Sum = 3) Path 2 : 3 (Sum = 3)

Constraints:
1 ≤ number of nodes ≤ 104
-100 ≤ node value ≤ 100
-109 ≤ k ≤ 109




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
    public int pathsum(Node root , int k , int currsum ,HashMap<Integer , Integer> pa)
    {
        if(root == null)
        {
            return 0;
        }
        // else
        // for the root
        currsum += root.data;
        //System.out.println(currsum);
        
        
        // and we will fidn that the target - currsum val is preset in the list 
        // since cout can not be neg;
        int count = pa.getOrDefault(currsum - k , 0);
        //System.out.println(count);
        
        
        // put the currsum in the hashmap
        if(pa.containsKey(currsum))
        {
            pa.put(currsum , pa.get(currsum)+1);
        }
        else
        {
            pa.put(currsum , 1);
        }
        // print 
        //System.out.println(pa);
        // for the left and the right subtree
        count += pathsum(root.left , k , currsum ,pa);
        count += pathsum(root.right , k , currsum,pa);
        
        // backtrack
        // delete the last elem val in the array
        pa.put(currsum , pa.get(currsum)-1);
        
        return count;
    }
    public int sumK(Node root, int k) {
        
        // code here
        
        // create an hashmap to store the prefix
        
        HashMap<Integer , Integer> pa = new HashMap<>();
        // inititalise the map \
        pa.put(0 ,1);
        return pathsum(root ,k , 0 ,pa);
    }
}
