/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Iteratively 
class Solution {
    public ListNode reverseList(ListNode head) {
        LinkedList<ListNode> ll = new LinkedList<>();
        
        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}

// thru recurrsion
class Solution {
    public ListNode reverseList(ListNode head) {
        // Base case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }
        
        // Recursively reverse the rest of the list
        ListNode newHead = reverseList(head.next);
        
        // Reverse the current node's pointer
        head.next.next = head;
        head.next = null;
        
        return newHead;
    }
}
