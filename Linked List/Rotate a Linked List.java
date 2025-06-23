Given the head of a singly linked list, your task is to left rotate the linked list k times.

Examples:

Input: head = 10 -> 20 -> 30 -> 40 -> 50, k = 4
Output: 50 -> 10 -> 20 -> 30 -> 40
Explanation:
Rotate 1: 20 -> 30 -> 40 -> 50 -> 10
Rotate 2: 30 -> 40 -> 50 -> 10 -> 20
Rotate 3: 40 -> 50 -> 10 -> 20 -> 30
Rotate 4: 50 -> 10 -> 20 -> 30 -> 40

Input: head = 10 -> 20 -> 30 -> 40 , k = 6
Output: 30 -> 40 -> 10 -> 20 

class Solution {
    public Node rotate(Node head, int k) {
        // add code here
        if(k  == 0 || head == null || head.next == null)
        {
            return head;
        }
        // fidn the length of thelist
        int l  = 1;
        Node temp = head;
        while(temp.next != null)
        {
            temp= temp.next;
            l++;
        }
        // fidn the actual no. of rotation
        k = k %l ;
        if( k == 0)
        {
            return head;
        }
        //now we will make the list circular
        temp.next = head;
        // now we will make the final touch
        Node tail = head;
        for(int i = 1 ; i<k ; i++)
        {
            tail = tail.next;
        }
        Node newhead = tail.next;
        tail.next = null;
        return newhead;
    }
}

  
