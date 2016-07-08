// https://leetcode.com/problems/remove-linked-list-elements/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    /* RECURSION
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        if(head.val == val){
            return removeElements(head.next, val);
        }
        head.next = removeElements(head.next, val);
        return head;
    }
    */
    
    // Iteration
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while(pre != null && pre.next != null){
            if(pre.next.val == val){
                pre.next = pre.next.next;
            }
            else{
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}