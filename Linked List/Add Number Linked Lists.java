Given the head of two singly linked lists num1 and num2 representing two non-negative integers. The task is to return the head of the linked list representing the sum of these two numbers.

For example, num1 represented by the linked list : 1 -> 9 -> 0, similarly num2 represented by the linked list: 2 -> 5. Sum of these two numbers is represented by 2 -> 1 -> 5.

Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.

Examples:

Input: num1 = 4 - > 5, num2 = 3 -> 4 -> 5
Output:  3 -> 9 -> 0
 
Explanation: Given numbers are 45 and 345. There sum is 390.
Input: num1 = 0 -> 0 -> 6 -> 3, num2 = 0 -> 7 
Output: 7 -> 0 

Explanation: Given numbers are 63 and 7. There sum is 70.

  class Solution {
    static Node removeZero(Node head)
    {
        while(head!= null && head.data == 0)
        {
            //traverse
            head = head.next;
        }
        return head;
    }
    
    static Node reverseList(Node head)
        {
            // write the script to reverse the list
        Node curr = head;
        Node next = null;
        Node prev = null;
        while(curr != null)
        {
            //next will be curr.ext
            next = curr.next;
            // reverrse the curr pointer
            curr.next = prev;
            //prev will point curr
            prev = curr;
            // curr will point next
            curr = next;
        }
        return prev;
        }
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        
        
        
        // now reverse the 2 list
        num1 = reverseList(num1);
        num2 = reverseList(num2);
        
        // now the list is reversed
        // we will create a new list for the result
        Node res = new Node(0); // with data 0
        // now c will point to res
        Node c = res;
        
        // we will traverse a loop over the list
        int carry = 0;
        while(num1!= null || num2 != null || carry != 0)
        {
            int sum = carry; // sum == 0
            if(num1  != null)
            {
                sum += num1.data;
                num1 = num1.next;
            }
            if(num2 != null)
            {
                sum += num2.data;
                num2  = num2.next;
                
            }
            // now find the digit and the carry
            carry = sum / 10;
            int digit = sum %10;
            // now push the digit to the lsit
            c.next = new Node(digit);
            // and curr will move to curr.next
            c = c.next;
        }
        // return the result
        Node ans =  reverseList(res.next);
        return removeZero(ans);
        
        
    }
}
