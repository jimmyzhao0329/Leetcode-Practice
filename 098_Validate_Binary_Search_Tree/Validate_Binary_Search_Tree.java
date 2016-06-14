// https://leetcode.com/problems/validate-binary-search-tree/

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
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode pre = null;
        TreeNode node = root;
        while(true){
            while(node != null){
                st.push(node);
                node = node.left;
            }
            if(st.empty()){
                break;
            }
            node = st.pop();
            if(pre != null && pre.val >= node.val){
                return false;
            }
            pre = node;
            node = node.right;
        }
        return true;
        
    }
}