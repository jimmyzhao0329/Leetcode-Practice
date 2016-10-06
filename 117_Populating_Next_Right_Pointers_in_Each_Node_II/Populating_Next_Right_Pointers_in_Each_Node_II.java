// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
p/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null || root.left == null && root.right == null){
            return;
        }
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.offer(root);
        while(!q.isEmpty()){
            int len = q.size();
            TreeLinkNode pre = q.poll();
            if(pre.left != null){
                q.offer(pre.left);
            }
            if(pre.right != null){
                q.offer(pre.right);
            }
            for(int i = 1; i < len; i++){
                TreeLinkNode cur = q.poll();
                pre.next = cur;
                pre = cur;
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
            }
        }
    }
}