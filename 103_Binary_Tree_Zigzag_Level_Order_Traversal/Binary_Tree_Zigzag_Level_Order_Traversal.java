// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        int flag = 0;
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<Integer>();
            int len = q.size();
            for(int i = 0; i < len; i++){
                TreeNode node = q.remove();
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
                if(flag == 0){
                    temp.add(node.val);
                }
                else{
                    temp.add(0, node.val);
                }
            }
            res.add(new ArrayList<Integer>(temp));
            flag = flag ^ 1;
        }
        return res;
    }
}