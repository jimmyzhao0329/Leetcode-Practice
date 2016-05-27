//https://leetcode.com/problems/remove-nth-node-from-end-of-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n == 0){
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode end = head;
        ListNode front = dummy;
        while(n > 0){
            end = end.next;
            n--;
        }
        while(end != null){
            front = front.next;
            end = end.next;
        }
        front.next = front.next.next;
        return dummy.next;
    }
}