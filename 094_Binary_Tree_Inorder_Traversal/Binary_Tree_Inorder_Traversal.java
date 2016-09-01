// https://leetcode.com/problems/binary-tree-inorder-traversal/

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
    //Non-Recursive
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode node = root;
        while(node != null || !st.empty()){
            while(node != null){
                st.push(node);
                node = node.left;
            }
            node = st.pop();
            res.add(node.val);
            node = node.right;
        }
        return res;
    }
    
    
    //Recursive
    /*
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res);
        return res;
    }
    
    public void helper(TreeNode root, List<Integer> res) {
        if(root == null){
            return;
        }
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }
    */
}