// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

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
    public void flatten(TreeNode root) {
        
        while(root != null){
            
            if(root.left != null && root.right != null){
                TreeNode node = root.left;
                while(node.right != null){
                    node = node.right;
                }
                node.right = root.right;
            }
            
            if(root.left != null){
                root.right = root.left;
                root.left = null;
            }
            
            root = root.right;
        }
    }
}