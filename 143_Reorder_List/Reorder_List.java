// https://leetcode.com/problems/reorder-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        //Find middle point
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //reverse the second half list
        ListNode pre = null;
        ListNode cur = slow.next;
        slow.next = null;
        while(cur != null){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        //reconnect the lists
        ListNode p1 = head;
        ListNode p2 = pre;
        while(p1 != null && p2 != null){
            ListNode p3 = p1.next;
            p1.next = p2;
            p2 = p2.next;
            p1 = p1.next;
            p1.next = p3;
            p1 = p1.next;
        }
    }
}