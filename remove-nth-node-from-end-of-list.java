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
/**
 * Definition for singly-linked list.
 */
 
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode temp = dummy;
        ListNode ptr = dummy;

        int size = 0;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }

        for (int i = 0; i < size - n; i++) {
            ptr = ptr.next;
        }

        if (ptr.next != null) {
            ptr.next = ptr.next.next;  // In Java, garbage collection handles the memory.
        }

        return dummy.next;
    }
}
