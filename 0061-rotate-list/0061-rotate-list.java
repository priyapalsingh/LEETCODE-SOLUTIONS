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
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        // Find the length and tail of the list
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Make the list circular
        tail.next = head;

        // Calculate number of moves to reach new tail
        int moves = length - (k % length);
        for (int i = 0; i < moves; i++) {
            tail = tail.next;
        }
        
        // Break the ring and return new head
        head = tail.next;
        tail.next = null;
        return head;
    }
}
