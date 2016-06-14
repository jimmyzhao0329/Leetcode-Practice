// https://leetcode.com/problems/symmetric-tree/

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
    private boolean compare(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null && root2 != null || root1 != null && root2 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        return compare(root1.left, root2.right) && compare(root1.right, root2.left);
    }
    
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return compare(root.left, root.right);
    }
}