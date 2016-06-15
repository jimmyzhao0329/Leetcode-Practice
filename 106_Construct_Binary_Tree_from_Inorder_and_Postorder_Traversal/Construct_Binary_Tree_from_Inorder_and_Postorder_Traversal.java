// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

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
    private TreeNode helper(int[] inorder, int[] postorder, 
                            int inStart, int inEnd,
                            int postStart, int postEnd){
        if(postStart > postEnd){
            return null;
        }               
        TreeNode node = new TreeNode(postorder[postEnd]);
        int r = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == postorder[postEnd]){
                r = i;
                break;
            }
        }
        node.left = helper(inorder, postorder, inStart, r - 1, postStart, postStart + r - inStart - 1);
        node.right = helper(inorder, postorder, r + 1, inEnd, postStart + r - inStart, postEnd - 1);
        return node;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0){
            return null;
        }
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
}