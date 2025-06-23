You are given a special linked list with n nodes where each node has two pointers a next pointer that points to the next node of the singly linked list, and a random pointer that points to the random node of the linked list.

Construct a copy of this linked list. The copy should consist of the same number of new nodes, where each new node has the value corresponding to its original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list, such that it also represent the same list state. None of the pointers in the new list should point to nodes in the original list.

Return the head of the copied linked list.

NOTE : Original linked list should remain unchanged.

Examples:

Input: head = [[1, 3], [3, 3], [5, NULL], [9, 3]] 
      
Output: head = [[1, 3], [3, 3], [5, NULL], [9, 3]] 
Explanation: 
Node 1 points to Node 2 as its NEXT and Node 3 as its RANDOM.
Node 2 points to Node 3 as its NEXT and Node 3 as its RANDOM.
Node 3 points to Node 4 as its NEXT and NULL as its RANDOM.
Node 4 points to NULL as its NEXT and Node 3 as its RANDOM.
Input: head = [[1, 3], [2, 1], [3, 5], [4, 3], [5, 2]]
  
 
Output: head = [[1, 3], [2, 1], [3, 5], [4, 3], [5, 2]]
Explanation: 
Node 1 points to Node 2 as its NEXT and Node 3 as its RANDOM.
Node 2 points to Node 3 as its NEXT and Node 1 as its RANDOM.
Node 3 points to Node 4 as its NEXT and Node 5 as its RANDOM.
Node 4 points to Node 5 as its NEXT and Node 3 as its RANDOM.
Node 5 points to NULL as its NEXT and Node 2 as its RANDOM.
Input: head = [[7, NULL], [7, NULL]]
Output: head = [[7, NULL], [7, NULL]]
Explanation: 
Node 1 points to Node 2 as its NEXT and NULL as its RANDOM.
Node 2 points to NULL as its NEXT and NULL as its RANDOM.

class Solution {
    public Node cloneLinkedList(Node head) 
    {
        // edge case:=
        if(head == null)return null;
        // code here
        // create an undorderd map 
        HashMap<Node , Node>m = new HashMap<>();
        // now creaate a new new node to store the val of the old node
        Node newHead = new Node(head.data); // this will store the data in the old head
        
        // now we will make an old temp
        // it will point the next node of the old head
        Node oldtemp = head.next;
        // and a new temp will point to the new head
        Node newtemp = newHead;
        
        // store the first old and the new data in the map
        m.put(head , newHead);
        
        // now we will traveerse the loop  and copy the data
        while(oldtemp != null)
        {
            
            newtemp.next = new Node(oldtemp.data);
            
            // now store the oldtemp and the new temp in the map
            m.put(oldtemp,newtemp.next);
            // update the old temp and new temp
            oldtemp = oldtemp.next;
            newtemp = newtemp.next;
        }
        
        // after the loop we will again reassign the newtemp to the new head
        newtemp = newHead;
        // same the oldtemp to head
        oldtemp = head;
        // now we will again traverse the loop 
        while(oldtemp != null)
        {
            // important step
            newtemp.random =m.get(oldtemp.random); // it will give the new address
            // update the old and the new temp
            oldtemp = oldtemp.next;
            newtemp = newtemp.next;
        }
        
        // now we can return the newHead
        return newHead;
    }
}

  
