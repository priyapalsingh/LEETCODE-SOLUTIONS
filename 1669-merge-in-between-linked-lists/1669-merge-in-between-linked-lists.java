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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prevA=list1;
        for(int i=0;i<a-1;i++){
            prevA=prevA.next;
        }
        //saving node B
        ListNode nodeB=prevA.next;
        for(int i=a;i<b;i++){
            nodeB=nodeB.next;
        }
        //connecting to list2
        prevA.next=list2;
        ListNode tail1=list2;
        while(tail1.next!=null){
            tail1=tail1.next;
        }
        tail1.next=nodeB.next;
        nodeB.next=null;
        return list1;
    }
}