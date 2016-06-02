// https://leetcode.com/problems/rotate-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k <= 0 || head == null || head.next == null){
            return head;
        }
        
        ListNode tail = head;
        ListNode newHead = head;
        int len = 1;
        while(tail.next != null){
            tail = tail.next;
            len++;
        }
        
        k %= len;
        if(k > 0){
            tail.next = head;
            for(int i = 0; i < len - k; i++){
                tail = tail.next;
            }
            newHead = tail.next;
            tail.next = null;
        }
        
        return newHead;
    }
}