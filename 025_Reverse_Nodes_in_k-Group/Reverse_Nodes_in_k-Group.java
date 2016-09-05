// https://leetcode.com/problems/reverse-nodes-in-k-group/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k < 2){
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode start = head;
        ListNode then = start.next;
        ListNode nextStart = head;
        while(true){
            int count = 0;
            while(count < k && nextStart != null){
                nextStart = nextStart.next;
                count++;
            }
            if(count < k){
                break;
            }
            while(then != nextStart){
                start.next = then.next;
                then.next = pre.next;
                pre.next = then;
                then = start.next;
            }
            pre = start;
            start = then;
            if(then != null && then.next != null){
               then = then.next; 
            }
            else{
                break;
            }
        }
        return dummy.next;
        
    }
}