// https://leetcode.com/problems/merge-k-sorted-lists/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        
        PriorityQueue<ListNode> pq = 
            new PriorityQueue<ListNode>(lists.length, 
                new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode l1, ListNode l2){
                        return l1.val - l2.val;
                    }
            });
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        
        for(ListNode l : lists){
            if(l != null){
                pq.offer(l);
            }
        }
        while(!pq.isEmpty()){
            p.next = pq.poll();
            p = p.next;
            if(p.next != null){
                pq.offer(p.next);
            }
        }
        return dummy.next;
    }
}