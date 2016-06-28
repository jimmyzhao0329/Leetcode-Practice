// https://leetcode.com/problems/linked-list-cycle-ii/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        //calculate the circle length
        int count = 1;
        slow = slow.next;
        while(slow != fast){
            count++;
            slow = slow.next;
        }
        //let fast and slow start from head again,
        //and make fast count steps ahead
        fast = head;
        slow = head;
        while(count > 0){
            fast = fast.next;
            count--;
        }
        //make fast and slow pointers move
        while(slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}