// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private TreeNode helper(ListNode start, ListNode end){
        if(start == end){
            return null;
        } 
        ListNode fast = start;
        ListNode mid = start;
        while(fast != end && fast.next != end){
            fast = fast.next.next;
            mid = mid.next;
        }
        TreeNode root = new TreeNode(mid.val);
        root.left = helper(start, mid);
        root.right = helper(mid.next, end);
        return root;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        return helper(head, null);
    }
}