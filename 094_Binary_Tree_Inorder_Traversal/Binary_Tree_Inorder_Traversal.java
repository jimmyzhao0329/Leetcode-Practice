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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode node = root;
        while(true){
            while(node != null){
                st.push(node);
                node = node.left;
            }
            if(st.empty()){
                break;
            }
            node = st.peek();
            st.pop();
            res.add(node.val);
            node = node.right;
        }
        return res;
    }
}