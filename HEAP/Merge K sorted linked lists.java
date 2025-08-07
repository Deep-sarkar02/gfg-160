Given an array arr[] of n sorted linked lists of different sizes. You have to merge them in such a way that after merging they will be a single sorted linked list, then return the head of the merged linked list.

Examples:

Input: arr[] = [1 -> 2 -> 3, 4 -> 5, 5 -> 6, 7 -> 8]
Output: 1 -> 2 -> 3 -> 4 -> 5 -> 5 -> 6 -> 7 -> 8
Explanation:
The arr[] has 4 sorted linked list of size 3, 2, 2, 2.
1st list: 1 -> 2-> 3
2nd list: 4 -> 5
3rd list: 5 -> 6
4th list: 7 -> 8
The merged list will be:
 
Input: arr[] = [1 -> 3, 8, 4 -> 5 -> 6]
Output: 1 -> 3 -> 4 -> 5 -> 6 -> 8
Explanation:
The arr[] has 3 sorted linked list of size 2, 3, 1.
1st list: 1 -> 3
2nd list: 8
3rd list: 4 -> 5 -> 6
The merged list will be:

Constraints
1 ≤ total no. of nodes ≤ 105
1 ≤ node->data ≤ 103


/*class Node
{
    int data;
    Node next;

    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

// arr is an array of Nodes of the heads of linked lists

class pair
{
    int value; 
    Node node;
    pair(Node node ,int value)
    {
        this.node = node;
        this.value = value;
    }
}
class Solution {
    // Function to merge K sorted linked list.
    Node mergeKLists(List<Node> arr) {
        // Add your code here.
        // cretaer a min heap
        PriorityQueue<pair> mh = new PriorityQueue<>((a ,b)-> Integer.compare(a.value , b.value));
        //now we will loop over the arra and store the node or the head of the all the ll
        for(int i  = 0 ; i< arr.size() ; i++)
        {
            // take the ndoe in the temp 
            Node temp = arr.get(i);
            mh.add(new pair(temp ,temp.data));
            //so all the value willl be added to the min heap
        }
        //System.out.println(mh);
        // now we will create anew  head or new node
        // put -1
        Node head = new Node(-1);
        // and the temp will will point to head
        Node temp = head;
        // while pq will not empty
        while(!mh.isEmpty())
        {
            // we will pop the element from the pq
            // and put that to the curr node
            Node curr = mh.poll().node;
            // now the temp will point to curr
            temp.next = curr;
            // and temp will change
            temp = temp.next;
            // now we have polled it from the pq
            // so we need to push something
            if(curr.next != null)
            {
                mh.add(new pair(curr.next , curr.next.data));
            }
            
        }
        return head.next;
    }
}
