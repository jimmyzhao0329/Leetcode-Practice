// https://leetcode.com/problems/palindrome-linked-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        //find middle node
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //reverse the second half
        ListNode pre = null;
        ListNode cur = slow.next;
        slow.next = null;
        while(cur != null){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        //compare two parts
        ListNode start = head;
        while(start != null && pre != null){
            if(start.val != pre.val){
                return false;
            }
            start = start.next;
            pre = pre.next;
        }
        return true;
    }
}