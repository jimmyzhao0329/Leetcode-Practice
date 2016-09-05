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
        
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1, ListNode l2){
                if(l1.val < l2.val){
                    return -1;
                }
                else if(l1.val == l2.val){
                    return 0;
                }
                else{
                    return 1;
                }
            }
        });
        
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        for(ListNode ln : lists){
            if(ln != null){
                queue.offer(ln);
            }
        }
        while(!queue.isEmpty()){
            p.next = queue.poll();
            p = p.next;
            if(p.next != null){
                queue.offer(p.next);
            }
        }
        return dummy.next;
    }
}