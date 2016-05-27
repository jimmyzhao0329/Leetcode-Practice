//https://leetcode.com/problems/swap-nodes-in-pairs/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        
        while(p.next != null && p.next.next != null){
            ListNode p1 = p.next;
            ListNode p2 = p.next.next;
            p1.next = p2.next;
            p.next = p2;
            p2.next = p1;
            p = p1;
        }
        return dummy.next;
    }
}