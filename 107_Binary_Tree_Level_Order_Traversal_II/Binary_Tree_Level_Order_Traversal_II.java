// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

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
    private void helper(List<List<Integer>> res, TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> cur = new ArrayList<Integer>();
            int len = q.size();
            for(int i = 0; i < len; i++){
                TreeNode node = q.remove();
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
                cur.add(node.val);
            }
            res.add(0, new ArrayList<Integer>(cur));
        }
    }
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return res;
        }
        helper(res, root);
        return res;
    }
}