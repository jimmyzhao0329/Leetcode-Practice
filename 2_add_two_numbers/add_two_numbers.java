//https://leetcode.com/problems/add-two-numbers/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carry = 0;
        while(l1 != null || l2 != null){
            int temp = carry;
            if(l1 != null){
                temp += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                temp += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(temp % 10);
            carry = temp / 10;
            p = p.next;
        }
        if(carry != 0){
            p.next = new ListNode(carry);
        }
        return dummy.next;
        
    }
}
