// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

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
    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        if(preStart > preEnd){
            return null;
        }    
        TreeNode node = new TreeNode(preorder[preStart]);
        //find root position in the inorder array
        int r = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == preorder[preStart]){
                r = i;
                break;
            }
        }
        node.left = helper(preorder, inorder, preStart + 1, preStart + r - inStart, inStart, r - 1);
        node.right = helper(preorder, inorder, preStart + r - inStart + 1, preEnd, r + 1, inEnd);
        return node;
        
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
}