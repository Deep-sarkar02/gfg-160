Given the head a linked list, the task is to reverse every k node in the linked list. If the number of nodes is not a multiple of k then the left-out nodes in the end, should be considered as a group and must be reversed.

Examples:

Input: head = 1 -> 2 -> 2 -> 4 -> 5 -> 6 -> 7 -> 8, k = 4
Output: 4 -> 2 -> 2 -> 1 -> 8 -> 7 -> 6 -> 5

Explanation: The first 4 elements 1, 2, 2, 4 are reversed first and then the next 4 elements 5, 6, 7, 8. Hence, the resultant linked list is 4 -> 2 -> 2 -> 1 -> 8 -> 7 -> 6 -> 5.
Input: head = 1 -> 2 -> 3 -> 4 -> 5, k = 3
Output: 3 -> 2 -> 1 -> 5 -> 4

Explanation: The first 3 elements 1, 2, 3 are reversed first and then left out elements 4, 5 are reversed. Hence, the resultant linked list is 3 -> 2 -> 1 -> 5 -> 4.

class Solution {
    public static Node reverseKGroup(Node head, int k) {
        // code here
        /*
        // find if the k nodes exist
        int c = 0 ;
        Node temp = head;
        while(c < k) // 3<4 
        {
            if(temp == null)
            {
                return head;
            }
            temp = temp.next; // so this will stop at k +1 node
        }
        
        // now we will make this recursive
        // or call the recursive function
        // here we will pass the next part of the list
        Node prev = reverseKGroup(temp , k);
        
        // now it is the time to reverse the nodes
        Node t = head;
        // now loop it to k
        int count = 0;
        while(count < k)
        {
            // store the next of the t
            Node next = t.next;
            // now the t will point to prev
            t.next = prev;
            // now prev will be the new t
            prev = t;
            // now temp will point to next
            t = next ;
            
            // increase the count
            count++;
        }
        // now at last the prev will be returned
        return prev;*/
        
        // this code is same as reverse a grp
        // base case
        if(head == null) return null;
        
        Node prev = null;
        Node curr = head ; 
        Node next = null;
        int count = 0;
        while(curr != null   && count < k)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        // if the next node is available then we will again do this
        if(next!= null)
        {
            // now head is the last node
            head.next = reverseKGroup(next , k);
        }
        // now we will return prev;
        return prev;
        
        
    }
}
