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
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode previous = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        previous.next = null;
        ListNode leftPart = sortList(head);
        ListNode rightPart = sortList(slow);
        return mergeLinkedList(leftPart, rightPart);
    }
    
    private ListNode mergeLinkedList(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;
        ListNode result = new ListNode(0);
        ListNode current = result;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        current.next = (left != null) ? left : right;
        return result.next;
    }
}
