// https://leetcode.com/problems/sum-root-to-leaf-numbers/

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
    private int helper(TreeNode root, int cur){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return cur * 10 + root.val;
        }
        else{
            return helper(root.left, cur * 10 + root.val) + helper(root.right, cur * 10 + root.val);
        }
    }
    
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
}