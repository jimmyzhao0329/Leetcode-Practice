// https://leetcode.com/problems/binary-tree-paths/

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null){
            return res;
        }
        if(root.left == null && root.right == null){
            res.add(root.val + "");
            return res;
        }
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        for(String s : left){
            res.add(root.val + "->" + s);
        }
        for(String s : right){
            res.add(root.val + "->" + s);
        }
        return res;
    }
}