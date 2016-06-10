// https://leetcode.com/problems/reverse-linked-list-ii/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
       for(int i = 0; i < m - 1; i++){
            pre = pre.next;
        }
        ListNode cur = pre.next;
        while(n - m > 0){
            ListNode nxt = cur.next;
            cur.next = nxt.next;
            nxt.next = pre.next;
            pre.next = nxt;
            n--;
        }
        return dummy.next;
    }
}