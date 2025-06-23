Given a head of the singly linked list. If a loop is present in the list then return the first node of the loop else return NULL.

Custom Input format:
A head of a singly linked list and a pos (1-based index) which denotes the position of the node to which the last node points to. If pos = 0, it means the last node points to null, indicating there is no loop.

Examples:

Input:
 
Output: 3
Explanation: We can see that there exists a loop in the given linked list and the first node of the loop is 3.
Input:
 
Output: -1
Explanation: No loop exists in the above linked list.So the output is -1.
  class Solution {
    public static Node findFirstNode(Node head) {
        // code here
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null)
        {
            // increament
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
            {
                break;
            }
        }
        if(fast != slow) return new Node(-1);
        // now again initialise the slow to head
        slow = head;
        while(slow != fast)
        {
            // increament
            slow = slow.next;
            fast = fast.next;
        }
        // now we can return any of the pointer
        return slow;
    }
