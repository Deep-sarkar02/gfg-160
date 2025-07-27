Serialization is to store a tree in an array so that it can be later restored and deserialization is reading tree back from the array. Complete the functions

serialize() : stores the tree into an array a and returns the array.
deSerialize() : deserializes the array to the tree and returns the root of the tree.
Note: Multiple nodes can have the same data and the node values are always positive integers. Your code will be correct if the tree returned by deSerialize(serialize(input_tree)) is same as the input tree. Driver code will print the in-order traversal of the tree returned by deSerialize(serialize(input_tree)).

Examples :

Input: root = [1, 2, 3]
      
Output: [2, 1, 3]
Input: root = [10, 20, 30, 40, 60, N, N]
      
Output: [40, 20, 60, 10, 30]
Constraints:
1 <= Number of nodes <= 104
1 <= Data of a node <= 109



  /*Complete the given function
Node is as follows:
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}*/

class Tree {
    
    
    
      int ind = 0;
    // preorder fucntion
    public void preorder(Node root , ArrayList<Integer>a)
    {
        // base
        if(root == null)
        {
            // add -1 to the array for the leaf node
            a.add(-1);
            //System.out.println(a);
            return;
        }
        // for else case 
        // root 
        a.add(root.data);
        preorder(root.left , a);
        preorder(root.right , a);
    }
    // Function to serialize a tree and return a list containing nodes of tree.
    public ArrayList<Integer> serialize(Node root) {
        // code here
        ArrayList<Integer> a = new ArrayList<>();
        preorder(root , a);
       
        return a;
        
    }
    
    
    
    
    public Node build(ArrayList<Integer> arr )
    {
        // for the base case 
        // if the index >= arr.size
        // if val == -1
        if(ind >= arr.size()  || arr.get(ind) == -1)
        {
            ind++;
            return null;
        }
        // for the other case 
        //build the node
        Node root = new Node(arr.get(ind));
        // increament the index 
        ind++;
        // now we call for the left and the tight
        root.left = build(arr );
        root.right = build(arr );
        
        return root;
    }
    
    
    
  
    // Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> arr) {
        
        // code here
        // we will pass the arr index and the arr
         // start index
        ind = 0;
        return build(arr );
    }
};
